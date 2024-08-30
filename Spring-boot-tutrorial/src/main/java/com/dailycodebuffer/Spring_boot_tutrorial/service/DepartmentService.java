package com.dailycodebuffer.Spring_boot_tutrorial.service;

import com.dailycodebuffer.Spring_boot_tutrorial.entity.Department;
import com.dailycodebuffer.Spring_boot_tutrorial.error.DepartmentNotFound;
import org.springframework.stereotype.Service;

import java.util.List;

public interface DepartmentService {
    public Department saveDepartmrent(Department department);

   public List<Department> fetchDepartmentList();

  public   Department fetchDepartmenById(long departmentId) throws DepartmentNotFound;

    public void deleteDepartmentById(long departmentId);

   public Department updateDepartment(Long departmentId, Department department);


   public Department fetchDepartmenByName(String departmentName);
}
