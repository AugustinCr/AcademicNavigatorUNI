package com.acnav.academicnavigator.Controller;

import com.acnav.academicnavigator.Model.Course;
import com.acnav.academicnavigator.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseRestController {
    @Autowired
    private CourseService service;
}
