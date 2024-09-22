package edu.icet.controller;

import edu.icet.model.Student;
import edu.icet.service.StudentService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/student")
@Slf4j
public class StudentController {
    final StudentService service;


    @GetMapping("/all")
    public Map getStudent() {
        return service.getStudent();
    }


    @PostMapping("/add-student")
    public void addStudent(@RequestBody Student student, HttpServletRequest request) throws IllegalAccessException {
        String os = request.getHeader("sec-ch-ua-platform");
        if("Windows".equals(os)){
            throw new IllegalAccessException("Os Not supported");
        }

        log.info("Request Received | {}",student);

        service.addStudent(student);
    }


    @DeleteMapping("/{id}")
    public void deleteStudentById(@PathVariable Integer id){
        service.deleteStudentById(id);
    }


    @PutMapping
    public void updateStudent(@RequestBody Student student){
        service.addStudent(student);
    }


    @GetMapping("/find-by-name/{name}")
    public List<Student> findByName(@PathVariable String name){
        return service.findByName(name);
    }
}
