package com.javarush.test_task.controllers;

import com.javarush.test_task.entity.Part;
import com.javarush.test_task.model.PagerModel;
import com.javarush.test_task.service.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
import java.util.Optional;

/**
 * @author Igor Reitz on 24.12.2018
 */
@Controller
public class PartController {
    private PartService service;
    private String sortMethod = "ALL";
    private String searchString;
    private static final int PAGE_SIZE = 10; //число записей на одной странице
    private static final int BUTTONS_TO_SHOW = 5;
    private static final int INITIAL_PAGE = 0;

    @Autowired
    public void setPartService(PartService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String list(Model model, @RequestParam("page") Optional<Integer> page) {
        int evalPage = (page.orElse(0) < 1) ? INITIAL_PAGE : page.get() - 1; //текущая страница
        int evalPageSize = PAGE_SIZE;

        Page<Part> partList = filterAndSort(evalPage, evalPageSize);

        PagerModel pager = new PagerModel(partList.getTotalPages(), partList.getNumber(), BUTTONS_TO_SHOW);
        System.out.println(partList.getTotalPages() + " " + partList.getNumber());
        model.addAttribute("parts", partList);
        model.addAttribute("selectedPageSize", evalPageSize);
        model.addAttribute("pager", pager);
        model.addAttribute("computers", computers());
        return "index";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        service.deletePart(id);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        Part part = service.getOne(id);
        model.addAttribute("part", part);
        return "edit";
    }

    @PostMapping("/update")
    public String updatePart(@RequestParam Integer id, @RequestParam String name,
                             @RequestParam(value = "need", required = false) boolean need, @RequestParam Integer amount) {
        Part updatingPart = service.getOne(id);
        updatingPart.setName(name);
        updatingPart.setNeed(need);
        updatingPart.setAmount(amount);
        service.updatePart(updatingPart);
        return "redirect:/";
    }

    @GetMapping("/new")
    public String newPart() {
        return "new";
    }

    @PostMapping("/save")
    public String savePart(@RequestParam String name,
                           @RequestParam(value = "need", required = false) boolean need, @RequestParam Integer amount) {
        service.addPart(name, need, amount);
        return "redirect:/";
    }

    @PostMapping("/search")
    public String searchPart(@RequestParam String search) {
        if (!search.equals("")) {
            sortMethod = "SEARCH";
            searchString = search;
        } else
            sortMethod = "ALL";

        return "redirect:/";
    }

    @GetMapping("/all")
    public String allParts() {
        sortMethod = "ALL";
        return "redirect:/";
    }

    @GetMapping("/need")
    public String neededParts() {
        sortMethod = "NEED";
        return "redirect:/";
    }

    @GetMapping("/not_need")
    public String notNeededParts() {
        sortMethod = "NOT_NEED";
        return "redirect:/";
    }

    private Page<Part> filterAndSort(int evalPage, int evalPageSize) {
        Page<Part> partList = null;
        switch (sortMethod) {
            case "ALL":
                partList = service.getAll(evalPage, evalPageSize);
                break;
            case "SEARCH":
                partList = service.searchPart(searchString, evalPage, evalPageSize);
                //sortMethod = "ALL";
                break;
            case "NEED":
                partList = service.searchNeededParts(evalPage, evalPageSize);
                //sortMethod = "ALL";
                break;
            case "NOT_NEED":
                partList = service.searchOptionalParts(evalPage, evalPageSize);
                //sortMethod = "ALL";
                break;
        }
        return partList;
    }

    private int computers() {
        int result = 0;
        List<Part> list = service.searchNeededParts();
        int minimum = Integer.MAX_VALUE;

        for (Part part : list) {
            if (minimum > part.getAmount())
                minimum = part.getAmount();
        }
        result = minimum;
        return result;
    }
}
