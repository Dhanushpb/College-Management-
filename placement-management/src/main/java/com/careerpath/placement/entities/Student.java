package com.careerpath.placement.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long roll;
    private String qualification;
    private String course;
    private Integer year;
    private Long hallTicketNo;

    // Default constructor
    public Student() {}

    // Parameterized constructor
    public Student(Long id, String name, Long roll, String qualification, String course, Integer year, Long hallTicketNo) {
        this.id = id;
        this.name = name;
        this.roll = roll;
        this.qualification = qualification;
        this.course = course;
        this.year = year;
        this.hallTicketNo = hallTicketNo;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getRoll() {
        return roll;
    }

    public void setRoll(Long roll) {
        this.roll = roll;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Long getHallTicketNo() {
        return hallTicketNo;
    }

    public void setHallTicketNo(Long hallTicketNo) {
        this.hallTicketNo = hallTicketNo;
    }
}
