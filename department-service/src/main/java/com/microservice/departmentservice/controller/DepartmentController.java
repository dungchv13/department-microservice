package com.microservice.departmentservice.controller;

import com.microservice.departmentservice.entity.Department;
import com.microservice.departmentservice.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/")
    public Department saveDepartment(@RequestBody Department department){
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/{id}")
    public Department findById(@PathVariable("id") Long departmentId){
        return departmentService.findById(departmentId);
    }

}
