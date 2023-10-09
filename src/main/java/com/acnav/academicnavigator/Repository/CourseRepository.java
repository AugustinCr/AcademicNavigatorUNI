package com.acnav.academicnavigator.Repository;
import com.acnav.academicnavigator.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findAllByTerm(String chosenTerm);

    default List<Course> findAllByInstructorContaining(String chosenInstructorLast, String chosenInstructorFirst) {
        return findAll().stream().filter(person -> person.getInstructor().equals(chosenInstructorLast + ", " + chosenInstructorFirst)).toList();
    }

}

