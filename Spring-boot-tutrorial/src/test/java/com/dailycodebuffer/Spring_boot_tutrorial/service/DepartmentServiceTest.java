package com.dailycodebuffer.Spring_boot_tutrorial.service;

import com.dailycodebuffer.Spring_boot_tutrorial.entity.Department;
import com.dailycodebuffer.Spring_boot_tutrorial.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class DepartmentServiceTest {
@Autowired
private DepartmentService departmentService;
@MockBean
private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        Department department=
                Department.builder().departmentName("msc").departmentAddress("bangalore").departmentId(1).build();
        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("msc")).thenReturn(department);
    }
    @Test
    @DisplayName("Get data based on valid department name")
    public void whenValidDepartmentName_theDepartmentShouldDFound(){
        String departmentName="msc";
        Department found =
                departmentService.fetchDepartmenByName(departmentName);
        assertEquals(departmentName,found.getDepartmentName());

    }
}