package com.javarush.test_task.service;

import com.javarush.test_task.entity.Part;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author Igor Reitz on 26.12.2018
 */
public interface PartService {
    void addPart(String name,boolean need,int amount);
    void updatePart(Part part);
    void deletePart(Integer id);

    Page<Part> getAll(int evalPage,int evalPageSize);

    Page<Part> searchPart(String search,int evalPage,int evalPageSize);

    Page<Part> searchNeededParts(int evalPage, int evalPageSize);

    Page<Part> searchOptionalParts(int evalPage, int evalPageSize);

    Part getOne(Integer id);

    List<Part> searchNeededParts();
}