package com.github.sgt_KittyKat.cli.crud.command.studentGroup;

import com.github.sgt_KittyKat.cli.crud.command.Command;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.github.sgt_KittyKat.cli.crud.configuration.DatabaseUtils;
import com.github.sgt_KittyKat.cli.crud.model.StudentGroup;

import java.sql.SQLException;

public interface StudentGroupCommand extends Command {
    default Dao<StudentGroup, Integer> dao() throws SQLException {
        return DaoManager.createDao(DatabaseUtils.CONNECTION_SOURCE, StudentGroup.class);
    }
}
