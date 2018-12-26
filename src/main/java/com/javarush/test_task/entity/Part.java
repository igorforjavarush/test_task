package com.javarush.test_task.entity;

import javax.persistence.*;

import javax.persistence.Column;


/**
 * Класс для описания сущности
 *
 * @author Igor Reitz on 26.12.2018
 */

@Entity
@Table(name ="test", schema = "test", catalog = "")
public class Part {
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "isNeedForAssembly")
    private boolean isNeedForAssembly;
    @Column(name = "amount")
    private int amount;

    public Part() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isNeedForAssembly() {
        return isNeedForAssembly;
    }

    public void setNeedForAssembly(boolean needForAssembly) {
        isNeedForAssembly = needForAssembly;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
