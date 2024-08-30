package com.dailycodebuffer.Spring_boot_tutrorial.controller;

import com.dailycodebuffer.Spring_boot_tutrorial.entity.Department;
import com.dailycodebuffer.Spring_boot_tutrorial.error.DepartmentNotFound;
import com.dailycodebuffer.Spring_boot_tutrorial.service.DepartmentService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    // Creating a logger for the DepartmentController class
    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);


    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department) {
        LOGGER.info("Inside fetchDepartmentList Of DepartmentController");
        return departmentService.saveDepartmrent(department);

    }
    @GetMapping("/departments")
    public List<Department> fetchAllDepartments() {
        return departmentService.fetchDepartmentList();
    }
    @GetMapping("/departments/{id}")
    public Department fetchDepartmentById(@PathVariable("id") long departmentId) throws DepartmentNotFound {
        return departmentService.fetchDepartmenById(departmentId);

    }
    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") long departmentId) {
       departmentService.deleteDepartmentById(departmentId);

        return "department deleted succesfully";
    }
     @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId, @RequestBody Department department) {
      return  departmentService.updateDepartment(departmentId,department);
    }
    @GetMapping("/departments/name/{name}")
   public Department fetchDepartmentByName(@PathVariable("name") String departmentName) {
       return departmentService.fetchDepartmenByName(departmentName);

    }
}
