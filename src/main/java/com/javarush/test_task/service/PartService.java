package com.javarush.test_task.service;

import com.javarush.test_task.entity.Part;

import java.util.List;

/**
 * @author Igor Reitz on 26.12.2018
 */
public interface PartService {
    void addPart(String name,boolean isNeedForAssembly,int amount);
    void updatePart(Integer id,String name,boolean isNeedForAssembly,int amount);
    void deletePart(Integer id);

    Part getByName(String name);

    List<Part> getAll();
}