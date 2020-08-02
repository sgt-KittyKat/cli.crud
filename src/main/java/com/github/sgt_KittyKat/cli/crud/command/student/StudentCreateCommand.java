package com.github.sgt_KittyKat.cli.crud.command.student;

import com.github.sgt_KittyKat.cli.crud.configuration.DatabaseUtils;
import com.github.sgt_KittyKat.cli.crud.model.Student;
import com.github.sgt_KittyKat.cli.crud.model.StudentGroup;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.spring.DaoFactory;

import java.sql.SQLException;

public class StudentCreateCommand implements StudentCommand {
    private final Student student;

    public StudentCreateCommand(Student student) {
        this.student = student;
    }

    public Student getStudent() {
        return student;
    }


    @Override
    public void execute() throws SQLException {
        Dao<StudentGroup, Integer> dao = DaoFactory.createDao(DatabaseUtils.CONNECTION_SOURCE , StudentGroup.class);
        student.setGroup(dao.queryForId(student.getStudentGroupId()));
        dao().create(student);
        System.out.println("Created student " + student);
    }
}
