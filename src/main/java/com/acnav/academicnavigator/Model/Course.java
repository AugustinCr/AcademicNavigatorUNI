package com.acnav.academicnavigator.Model;
import jakarta.persistence.*;

@Entity
public class Course {
    @Id
    @Column(name = "Id")
    private Long id;
    @Column(name = "Year")
    private int year;
    @Column(name = "Term")
    private String term;
    @Column(name = "Course")
    private String course;
    @Column(name = "Section")
    private String section;
    @Column(name = "Instructor")
    private String intructor;
    @Column(name = "Enrollment")
    private int enrolled;
    @Column(name = "Availability")
    private int available;
    @Column(name = "Days")
    private String days;
    @Column(name = "Time")
    private String time;
    @Column(name = "Location")
    private String location;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getIntructor() {
        return intructor;
    }

    public void setIntructor(String intructor) {
        this.intructor = intructor;
    }

    public int getEnrolled() {
        return enrolled;
    }

    public void setEnrolled(int enrolled) {
        this.enrolled = enrolled;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}

