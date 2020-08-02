package com.github.sgt_KittyKat.cli.crud.command.student;

import java.sql.SQLException;

public class StudentDeleteCommand implements StudentCommand {
    private final int id;
    public StudentDeleteCommand(int id) {
        this.id = id;
    }
    @Override
    public void execute() throws SQLException {
        dao().deleteById(id);
        System.out.println("Deleted student " + id);
    }
}
