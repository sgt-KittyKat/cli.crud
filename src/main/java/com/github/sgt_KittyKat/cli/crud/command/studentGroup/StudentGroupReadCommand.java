package com.github.sgt_KittyKat.cli.crud.command.studentGroup;

import com.github.sgt_KittyKat.cli.crud.model.StudentGroup;

import java.sql.SQLException;

public class StudentGroupReadCommand implements StudentGroupCommand{
    private final int id;

    public StudentGroupReadCommand(int id) {
        this.id = id;
    }

    @Override
    public void execute() throws SQLException {
        StudentGroup group = dao().queryForId(id);
        System.out.println("Read student group " + group);
    }
}
