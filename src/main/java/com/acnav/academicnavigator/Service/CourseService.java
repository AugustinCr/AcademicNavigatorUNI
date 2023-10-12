package com.acnav.academicnavigator.Service;

import com.acnav.academicnavigator.Model.Course;
import com.acnav.academicnavigator.Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepository repository;

    public List<Course> filterByTerm(String chosenTerm) {
        return repository.findAllByTerm(chosenTerm);
    }

    public List<Course> filterByInstructor(String chosenInstructorLast, String chosenInstructorFirst) {
        return repository.findAllByInstructorContaining(chosenInstructorLast, chosenInstructorFirst);
    }

    public List<Course> filterByLocation(String chosenLocation) {
        return repository.findAllByLocation(chosenLocation);
    }


    public List<Course> getCourses() {
        return repository.findAll();
    }

    public List<String> getTerms() {
        return repository.findDistinctTerms();
    }

    public List<String> getLocations() {
        return repository.findDistinctLocations();
    }

    public List<String> getInstructors() {
        return repository.findDistinctInstructors();
    }

    public List<Course> filterCourses(String selectedTerm, String selectedInstructor, String selectedLocation) {
        return repository.filterCourses(selectedTerm, selectedInstructor, selectedLocation);
    }
}
