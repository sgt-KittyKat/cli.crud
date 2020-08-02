package com.github.sgt_KittyKat.cli.crud;

import com.github.sgt_KittyKat.cli.crud.command.studentGroup.StudentGroupCreateCommand;
import com.github.sgt_KittyKat.cli.crud.command.studentGroup.StudentGroupReadCommand;
import com.github.sgt_KittyKat.cli.crud.command.studentGroup.StudentGroupUpdateCommand;
import com.github.sgt_KittyKat.cli.crud.command.Command;
import com.github.sgt_KittyKat.cli.crud.command.student.StudentCreateCommand;
import com.github.sgt_KittyKat.cli.crud.model.Student;
import com.github.sgt_KittyKat.cli.crud.command.student.StudentDeleteCommand;
import com.github.sgt_KittyKat.cli.crud.command.student.StudentReadCommand;
import com.github.sgt_KittyKat.cli.crud.command.student.StudentUpdateCommand;
import com.github.sgt_KittyKat.cli.crud.command.studentGroup.StudentGroupDeleteCommand;
import com.github.sgt_KittyKat.cli.crud.model.StudentGroup;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String line = scanner.nextLine();
            Command c = parseLine(line);
            c.execute();
        }
    }

    private static Command parseLine(String line) {
        //create student 1 John Doe

        //update student 1 Jane Doe

        //delete student 1

        //read student 1
        Scanner scanner = new Scanner(line);
        String first = scanner.next();
        if (first.equals(CREATE)) {
            return createCommand(scanner);
        } else if (first.equals(READ)) {
            return readCommand(scanner);
        } else if (first.equals(DELETE)) {
            return deleteCommand(scanner);
        } else if (first.equals(UPDATE)) {
            return updateCommand(scanner);
        }
        else throw new RuntimeException("Not supported yet.");
    }

    private static Command createCommand(Scanner scanner) {
        String className = scanner.next();
        if (className.equals(CLASS_STUDENT)) {
            int id = scanner.nextInt();
            String firstName = scanner.next();
            String lastName = scanner.next();
            int group = scanner.nextInt();
            return new StudentCreateCommand(new Student(id, firstName, lastName , group));

        }
        else if (className.equals(CLASS_STUDENT_GROUP)) {
            int id = scanner.nextInt();
            String name = scanner.next();
            return new StudentGroupCreateCommand(new StudentGroup(id, name));
        }
        else throw new RuntimeException("Not supported yet.");
    }

    private static Command readCommand(Scanner scanner) {
        String className = scanner.next();
        if (className.equals(CLASS_STUDENT)) {
            int id = scanner.nextInt();
            return new StudentReadCommand(id);

        } else if (className.equals(CLASS_STUDENT_GROUP)) {
            int id = scanner.nextInt();
            return new StudentGroupReadCommand(id);
        }
            else throw new RuntimeException("Not supported yet.");
    }
    private static Command deleteCommand(Scanner scanner) {
        String className = scanner.next();
        if (className.equals(CLASS_STUDENT)) {
            int id = scanner.nextInt();
            return new StudentDeleteCommand(id);
        } else if (className.equals(CLASS_STUDENT_GROUP)) {
            int id = scanner.nextInt();
            return new StudentGroupDeleteCommand(id);
        } else {
            throw new RuntimeException("Not supported yet.");
        }
    }
    private static Command updateCommand(Scanner scanner) {
        String className = scanner.next();
        if (className.equals(CLASS_STUDENT)) {
            int id = scanner.nextInt();
            String firstName = scanner.next();
            String lastName = scanner.next();
            int groupId = scanner.nextInt();
            return new StudentUpdateCommand(new Student(id, firstName, lastName , groupId));
        }
        else if (className.equals(CLASS_STUDENT_GROUP)) {
            int id = scanner.nextInt();
            String name = scanner.next();
            return new StudentGroupUpdateCommand(new StudentGroup(id, name));
        }
        else throw new RuntimeException("Not supported yet.");
    }
    private static final String CREATE = "create";
    private static final String UPDATE = "update";
    private static final String DELETE = "delete";
    private static final String READ = "read";

    private static final String CLASS_STUDENT = "student";
    private static final String CLASS_STUDENT_GROUP = "student_group";
}
