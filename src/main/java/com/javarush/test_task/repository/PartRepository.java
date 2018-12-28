package com.javarush.test_task.repository;

import com.javarush.test_task.entity.Part;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author Igor Reitz on 26.12.2018
 */
public interface PartRepository extends JpaRepository<Part,Integer> {
    //Метод для поиска записи по имени
    //@Query("select b from test b where b.name = :name")
    //Part findByName(@Param("name") String name);
}
