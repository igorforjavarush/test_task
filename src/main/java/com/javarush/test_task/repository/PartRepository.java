package com.javarush.test_task.repository;

import com.javarush.test_task.entity.Part;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * @author Igor Reitz on 26.12.2018
 */
public interface PartRepository extends JpaRepository<Part,Integer> {
    Page<Part> findByName(String name, Pageable pageable);
    Page<Part> findByNeedTrue(Pageable pageable);
    List<Part> findByNeedTrue();
    Page<Part> findByNeedFalse(Pageable pageable);
}
