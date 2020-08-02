package com.github.sgt_KittyKat.cli.crud.command;

import java.sql.SQLException;

public interface Command {
    void execute() throws SQLException;
}
