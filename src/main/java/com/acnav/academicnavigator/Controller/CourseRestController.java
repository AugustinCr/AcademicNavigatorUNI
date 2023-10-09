package com.acnav.academicnavigator.Controller;

import com.acnav.academicnavigator.Model.Course;
import com.acnav.academicnavigator.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseRestController {
    @Autowired
    private CourseService service;

    @GetMapping(value ="/term/{chosenTerm}")
    public List<Course> termFilter(@PathVariable String chosenTerm) {
        return service.filterByTerm(chosenTerm);
    }

    @GetMapping(value ="/instructor/{chosenInstructorLast}/{chosenInstructorFirst}")
    public List<Course> instructorFilter(@PathVariable String chosenInstructorLast, @PathVariable String chosenInstructorFirst) {
        return service.filterByInstructor(chosenInstructorLast, chosenInstructorFirst);
    }

    @GetMapping(value ="/courses")
    public List<Course> allCourses() {
        return service.getAllCourses();
    }
}
