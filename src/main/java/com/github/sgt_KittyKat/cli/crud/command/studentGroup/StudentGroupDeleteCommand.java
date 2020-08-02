package com.github.sgt_KittyKat.cli.crud.command.studentGroup;

import java.sql.SQLException;

public class StudentGroupDeleteCommand implements StudentGroupCommand{
    private final int id;

    public StudentGroupDeleteCommand(int id) {
        this.id = id;
    }

    @Override
    public void execute() throws SQLException {
        dao().deleteById(id);
        System.out.println("Deleted student group " + id);
    }
}
