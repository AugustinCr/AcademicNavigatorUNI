package com.acnav.academicnavigator.Controller;

import com.acnav.academicnavigator.Model.Course;
import com.acnav.academicnavigator.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class CourseRestController {
    @Autowired
    private CourseService service;

    @GetMapping(value ="/courses")
    public List<Course> getCourses() {
        return service.getCourses();
    }

    @GetMapping("/terms")
    public List<String> getTerms() {
        return service.getTerms();
    }

    @GetMapping("/instructors")
    public List<String> getInstructors() {
        return service.getInstructors();
    }

    @GetMapping("/locations")
    public List<String> getLocations() {
        return service.getLocations();
    }

    @GetMapping("/days")
    public List<String> getDays() {
        return service.getDays();
    }

    @GetMapping(value ="/filter")
    public List<Course> getFilteredCourses(@RequestParam(name = "term", required = false) String selectedTerm,
                                           @RequestParam(name = "instructor", required = false) String selectedInstructor,
                                           @RequestParam(name = "location", required = false) String selectedLocation,
                                           @RequestParam(name = "day", required = false) String selectedDay) {
        return service.filterCourses(selectedTerm, selectedInstructor, selectedLocation, selectedDay);
    }

    @GetMapping(value ="/term/{chosenTerm}")
    public List<Course> termFilter(@PathVariable String chosenTerm) {
        return service.filterByTerm(chosenTerm);
    }

    @GetMapping(value ="/instructor/{chosenInstructorLast}/{chosenInstructorFirst}")
    public List<Course> instructorFilter(@PathVariable String chosenInstructorLast, @PathVariable String chosenInstructorFirst) {
        return service.filterByInstructor(chosenInstructorLast, chosenInstructorFirst);
    }

    @GetMapping(value ="/location/{chosenLocation}")
    public List<Course> locationFilter(@PathVariable String chosenLocation) {
        return service.filterByLocation(chosenLocation);
    }
}
