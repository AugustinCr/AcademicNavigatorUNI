package com.acnav.academicnavigator.Repository;
import com.acnav.academicnavigator.Model.Course;
import jakarta.persistence.TypedQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findAllByTerm(String chosenTerm);

    default List<Course> findAllByInstructorContaining(String chosenInstructorLast, String chosenInstructorFirst) {
        return findAll().stream().filter(person -> person.getInstructor().equals(chosenInstructorLast + ", " + chosenInstructorFirst)).toList();
    }

    List<Course> findAllByLocation(String chosenLocation);


    // Dropdown
    @Query("SELECT DISTINCT entity.term FROM Course entity")
    List<String> findDistinctTerms();

    @Query("SELECT DISTINCT entity.location FROM Course entity")
    List<String> findDistinctLocations();

    @Query("SELECT DISTINCT entity.instructor FROM Course entity")
    List<String> findDistinctInstructors();

    @Query("SELECT entity FROM Course entity " +
            "WHERE (:selectedTerm is null or entity.term = :selectedTerm) " +
            "AND (:selectedInstructor is null or entity.instructor = :selectedInstructor) " +
            "AND (:selectedLocation is null or entity.location = :selectedLocation) ")
    List<Course> filterCourses(String selectedTerm, String selectedInstructor, String selectedLocation);
}

