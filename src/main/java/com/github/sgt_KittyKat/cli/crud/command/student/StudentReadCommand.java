package com.github.sgt_KittyKat.cli.crud.command.student;

import com.github.sgt_KittyKat.cli.crud.model.Student;

import java.sql.SQLException;

public class StudentReadCommand implements StudentCommand {
    private final int id;

    public StudentReadCommand(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }


    @Override
    public void execute() throws SQLException {
        Student student = dao().queryForId(id);
        System.out.println("Read student " + student);
    }
}
