package edu.icet.service;

import edu.icet.model.Student;

import java.util.List;
import java.util.Map;

public interface StudentService {
    Map getStudent();

    void addStudent(Student student);

    void deleteStudentById(Integer id);

    List<Student> findByName(String name);
}
