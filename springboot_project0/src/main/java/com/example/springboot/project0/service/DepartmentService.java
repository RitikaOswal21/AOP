package com.example.springboot.project0.service;
import java.util.List;

import  com.example.springboot.project0.entity.Department;
import com.example.springboot.project0.error.DepartmentNotFoundException;

public interface DepartmentService {
	public Department saveDepartment(Department department);

	public List<Department> fetchDepartmentList();

	public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException;

	public void deletedepartmentById(Long departmentId);

	public Department updateDepartment(Long departmentId, Department department);

	public Department fetchDepartmentByName(String departmentName);

}
