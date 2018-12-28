package com.javarush.test_task.service;

import com.javarush.test_task.entity.Part;
import com.javarush.test_task.repository.PartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Igor Reitz on 26.12.2018
 */
@Service
public class PartServiceImpl implements PartService {
    private PartRepository repository;

    @Autowired
    public void setProductRepository(PartRepository repository) {
        this.repository = repository;
    }

    @Override
    public void addPart(String name, boolean isNeedForAssembly, int amount) {

    }

    @Override
    public void updatePart(Integer id, String name, boolean isNeedForAssembly, int amount) {

    }

    @Override
    public void deletePart(Integer id) {
        repository.delete(repository.getOne(id));
    }

    @Override
    public Part getByName(String name) {
        return null;
        //return repository.findByName(name);
    }

    @Override
    public List<Part> getAll() {
        return repository.findAll();
    }
}