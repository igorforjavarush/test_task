package com.javarush.test_task.service;

import com.javarush.test_task.entity.Part;
import com.javarush.test_task.repository.PartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
    public void addPart(String name, boolean need, int amount) {
        repository.save(new Part(name,need,amount));
    }

    @Override
    public void updatePart(Part part) {
        repository.save(part);
    }

    @Override
    public void deletePart(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Page<Part> getAll(int evalPage,int evalPageSize) {
        return repository.findAll(PageRequest.of(evalPage,evalPageSize));
    }


    @Override
    public Page<Part> searchPart(String search,int evalPage,int evalPageSize) {
        return repository.findByName(search,PageRequest.of(evalPage,evalPageSize));
    }


    @Override
    public Page<Part> searchNeededParts(int evalPage, int evalPageSize) {
        return repository.findByNeedTrue(PageRequest.of(evalPage,evalPageSize));
    }

    @Override
    public Part getOne(Integer id) {
        return repository.findById(id).get();
    }

    @Override
    public List<Part> searchNeededParts() {
        return repository.findByNeedTrue();
    }

    @Override
    public Page<Part> searchOptionalParts(int evalPage, int evalPageSize) {
        return repository.findByNeedFalse(PageRequest.of(evalPage,evalPageSize));
    }
}
