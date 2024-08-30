package com.dailycodebuffer.Spring_boot_tutrorial.controller;

import com.dailycodebuffer.Spring_boot_tutrorial.entity.Department;
import com.dailycodebuffer.Spring_boot_tutrorial.error.DepartmentNotFound;
import com.dailycodebuffer.Spring_boot_tutrorial.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentService departmentService;

    private Department department;

    @BeforeEach
    void setUp() {
        department = Department.builder().departmentAddress("bangalore").
                departmentCode("it-4").departmentName("mca").departmentId(3l).build();
    }

    @Test
    void saveDepartment() throws Exception {
        Department inputDepartment = Department.builder().departmentAddress("bangalore").
                departmentCode("it-4").departmentName("mca").build();
        Mockito.when(departmentService.saveDepartmrent(inputDepartment))
                .thenReturn(department);


        mockMvc.perform(post("/departments")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "\t\t\"departmentName\":\"mca\",\t\t\n" +
                        "\t\t\"departmentAddress\":\"bangalore\",\n" +
                        "\t\t\"departmentCode\":\"it-4\"\n" +
                        "\n" +
                        "}")).andExpect(status().isOk());
    }

    @Test
    void fetchDepartmentById() throws Exception {
        Mockito.when(departmentService.fetchDepartmenById(1L))
                .thenReturn(department);

        mockMvc.perform(get("/departments/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.departmentName")
                        .value(department.getDepartmentName()));
    }
}
