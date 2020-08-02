package com.github.sgt_KittyKat.cli.crud.command.student;

import com.github.sgt_KittyKat.cli.crud.command.Command;
import com.github.sgt_KittyKat.cli.crud.configuration.DatabaseUtils;
import com.github.sgt_KittyKat.cli.crud.model.Student;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;

import java.sql.SQLException;

public interface StudentCommand extends Command {
    default Dao<Student, Integer> dao() throws SQLException {
        return DaoManager.createDao(DatabaseUtils.CONNECTION_SOURCE, Student.class);
    }
}
