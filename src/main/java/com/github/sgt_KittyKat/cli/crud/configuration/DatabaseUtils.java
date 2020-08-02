package com.github.sgt_KittyKat.cli.crud.configuration;

import com.github.sgt_KittyKat.cli.crud.model.Student;
import com.github.sgt_KittyKat.cli.crud.model.StudentGroup;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

public class DatabaseUtils {
    public static String JDBC_CONNECTION_STRING = "jdbc:sqlite:C:\\SQL\\DBs\\foreignKey.db";

    public static ConnectionSource CONNECTION_SOURCE;

    static {
        try {
            CONNECTION_SOURCE = new JdbcConnectionSource(JDBC_CONNECTION_STRING);
            TableUtils.createTableIfNotExists(CONNECTION_SOURCE, Student.class);
            TableUtils.createTableIfNotExists(CONNECTION_SOURCE, StudentGroup.class);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
