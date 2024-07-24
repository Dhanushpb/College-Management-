package com.careerpath.college.controllers;

import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.careerpath.college.entities.College;
import com.careerpath.college.services.CollegeService;

@RestController
@RequestMapping("/api")
public class CollegeController {

    @Autowired
    private CollegeService service;

    @GetMapping("/colleges")
    public List<College> list() {
        return service.listAll();
    }

    @GetMapping("/colleges/{id}")
    public ResponseEntity<College> get(@PathVariable("id") Long id) {  // Explicit parameter name
        try {
            College college = service.get(id);
            return new ResponseEntity<>(college, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/colleges")
    public ResponseEntity<?> add(@RequestBody College college) {
        try {
            service.save(college);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/colleges/{id}")
    public ResponseEntity<?> update(@RequestBody College college, @PathVariable("id") Long id) {  // Explicit parameter name
        try {
            service.save(college);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/colleges/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {  // Explicit parameter name
        try {
            service.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
