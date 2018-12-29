package com.javarush.test_task.controllers;

import com.javarush.test_task.entity.Part;
import com.javarush.test_task.service.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author Igor Reitz on 24.12.2018
 */
@Controller
public class PartController {
    private PartService service;
    private String sortMethod = "ALL";
    private String searchString;

    @Autowired
    public void setPartService(PartService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String list(Model model) {
        List<Part> partList = filterAndSort();
        model.addAttribute("parts", partList);
        model.addAttribute("computers", computers());
        return "index";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        service.deletePart(id);
        return "redirect:/";
    }

    /**
     * Метод для подготовки страницы Edit Page
     *
     * @param id    запчасти
     * @param model модель для "пробрасывания" запчасти во View
     * @return ссылку на страницу
     */
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

    private List<Part> filterAndSort() {
        List<Part> partList = null;
        switch (sortMethod) {
            case "ALL":
                partList = service.getAll();
                break;
            case "SEARCH":
                partList = service.searchPart(searchString);
                sortMethod = "ALL";
                break;
            case "NEED":
                partList = service.searchNeededParts();
                sortMethod = "ALL";
                break;
            case "NOT_NEED":
                partList = service.searchOptionalParts();
                sortMethod = "ALL";
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
