package com.acnav.academicnavigator.Controller;

import com.acnav.academicnavigator.Model.Course;
import com.acnav.academicnavigator.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

@Controller
@CrossOrigin(origins = "http://localhost:63342/")
public class CourseController {
    @Autowired
    private CourseService service;

}
