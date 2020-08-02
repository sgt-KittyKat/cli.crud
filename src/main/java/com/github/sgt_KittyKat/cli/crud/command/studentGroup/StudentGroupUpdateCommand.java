package com.github.sgt_KittyKat.cli.crud.command.studentGroup;

import com.github.sgt_KittyKat.cli.crud.model.StudentGroup;

import java.sql.SQLException;

public class StudentGroupUpdateCommand implements StudentGroupCommand {
    private final StudentGroup group;
    public StudentGroupUpdateCommand(StudentGroup group) {
        this.group = group;
    }
    @Override
    public void execute() throws SQLException {
        dao().update(group);
        System.out.println("Updated student group " + group);
    }
}
