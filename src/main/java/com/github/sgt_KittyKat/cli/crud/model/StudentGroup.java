package com.github.sgt_KittyKat.cli.crud.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class StudentGroup {
    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField
    private String name;

    public StudentGroup() {
    }

    public StudentGroup(int id, String name) {
        this.id = id;
        this.name = name;
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
}
