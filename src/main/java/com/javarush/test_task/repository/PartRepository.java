package com.javarush.test_task.repository;

import com.javarush.test_task.entity.Part;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Igor Reitz on 26.12.2018
 */
public interface PartRepository extends JpaRepository<Part,Integer> {
}
