package com.javarush.test_task.controllers;

import com.javarush.test_task.entity.Part;
import com.javarush.test_task.service.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author Igor Reitz on 24.12.2018
 */
@Controller
public class PartController {
    private PartService service;
    private String sortMethod = "ALL";

    @Autowired
    public void setPartService(PartService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String list(Model model) {
        List<Part> partList = filterAndSort();
        model.addAttribute("parts", partList);
        return "index";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        service.deletePart(id);
        return "redirect:/";
    }

    private List<Part> filterAndSort() {
        List<Part> partList = null;
        switch (sortMethod) {
            case "ALL":
                partList = service.getAll();
                break;
            case "DESC":
                partList = null;
                break;
        }
        return partList;
    }
}
