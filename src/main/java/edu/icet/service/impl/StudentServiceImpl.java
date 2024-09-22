package edu.icet.service.impl;

import edu.icet.model.Student;
import edu.icet.repository.NativeStudentRepository;
import edu.icet.repository.StudentRepository;
import edu.icet.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    final StudentRepository repository;
    final NativeStudentRepository nativeStudentRepository;

    @Override
    public Map getStudent(){
        List<Student> listOfStudents = repository.findAll();
        Long studentCount = nativeStudentRepository.getRecordCount();

        Map response = new HashMap<>();
        response.put("studentList",listOfStudents);
        response.put("studentCount",studentCount);
        return response;
    }

    @Override
    public void addStudent(Student student) {
        repository.save(student);
    }

    @Override
    public void deleteStudentById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public List<Student> findByName(String name) {
        return repository.findByName(name);
    }

}
