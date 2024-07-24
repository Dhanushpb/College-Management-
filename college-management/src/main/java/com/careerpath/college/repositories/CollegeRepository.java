package com.careerpath.college.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.careerpath.college.entities.College;

public interface CollegeRepository extends JpaRepository<College, Long> {
}
