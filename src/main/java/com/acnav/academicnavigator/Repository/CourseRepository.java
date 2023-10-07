package com.acnav.academicnavigator.Repository;
import com.acnav.academicnavigator.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}

