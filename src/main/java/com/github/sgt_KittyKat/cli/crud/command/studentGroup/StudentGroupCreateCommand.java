package com.github.sgt_KittyKat.cli.crud.command.studentGroup;

import com.github.sgt_KittyKat.cli.crud.model.StudentGroup;

import java.sql.SQLException;

public class StudentGroupCreateCommand implements StudentGroupCommand{
    private final StudentGroup group;

    public StudentGroupCreateCommand(StudentGroup group) {
        this.group = group;
    }

    @Override
    public void execute() throws SQLException {
        dao().create(group);
        System.out.println("Created student group" + group);
    }
}
