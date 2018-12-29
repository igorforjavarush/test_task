package com.javarush.test_task.repository;

import com.javarush.test_task.entity.Part;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author Igor Reitz on 26.12.2018
 */
public interface PartRepository extends JpaRepository<Part,Integer> {
    List<Part> findByName(String name);
    List<Part> findByNeedTrue();
    List<Part> findByNeedFalse();
}
