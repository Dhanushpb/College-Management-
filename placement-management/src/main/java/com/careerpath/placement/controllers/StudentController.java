package com.careerpath.placement.controllers;

import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.careerpath.placement.entities.Student;
import com.careerpath.placement.services.StudentService;

@RestController
@RequestMapping("/api")
public class StudentController {
    @Autowired
    private StudentService service;

    @GetMapping("/students")
    public List<Student> list() {
        return service.listAll();
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<Student> get(@PathVariable Long id) {
        try {
            Student student = service.get(id);
            return new ResponseEntity<>(student, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/students")
    public void add(@RequestBody Student student) {
        service.save(student);
    }

    @PutMapping("/students/{id}")
    public ResponseEntity<?> update(@RequestBody Student student, @PathVariable Long id) {
        try {
            Student existStudent = service.get(id);
            service.save(student);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/students/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
