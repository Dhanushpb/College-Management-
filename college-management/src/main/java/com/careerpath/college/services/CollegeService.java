package com.careerpath.college.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.careerpath.college.entities.College;
import com.careerpath.college.repositories.CollegeRepository;

@Service
public class CollegeService {

    @Autowired
    private CollegeRepository repo;

    public List<College> listAll() {
        return repo.findAll();
    }

    public void save(College college) {
        repo.save(college);
    }

    public College get(Long id) {
        return repo.findById(id).orElse(null);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
