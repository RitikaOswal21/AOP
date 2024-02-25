package com.example.springboot.project0.service;

import com.example.springboot.project0.entity.Department;
import com.example.springboot.project0.error.DepartmentNotFoundException;
import com.example.springboot.project0.repository.DepartmentRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DepartmentServiceImpl implements DepartmentService {
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Override
	public Department saveDepartment(Department department) {
		return departmentRepository.save(department);
	}
	@Override
	public List<Department> fetchDepartmentList() {
		
		return departmentRepository.findAll();
	}
	@Override
	public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException {
		Optional<Department> department=
		 departmentRepository.findById(departmentId);
		
		  if(!department.isPresent()) {
	            throw new DepartmentNotFoundException("Department Not Available");
	
		  }

	        return  department.get();
		  }
		  
	@Override
	public void deletedepartmentById(Long departmentId) {
		departmentRepository.deleteById(departmentId);
		
	}
	@Override
	public Department updateDepartment(Long departmentId, Department department) {
		
	Department depDB =departmentRepository.findById(departmentId).get();
	
	if(Objects.nonNull(department.getDepartmentName())&&
			!"".equalsIgnoreCase(department.getDepartmentName())) {
		depDB.setDepartmentName(department.getDepartmentName());
	}
	if(Objects.nonNull(department.getDepartmentCode())&&
			!"".equalsIgnoreCase(department.getDepartmentCode())) {
		depDB.setDepartmentCode(department.getDepartmentName());
	}
	if(Objects.nonNull(department.getDepartmentAddress())&&
			!"".equalsIgnoreCase(department.getDepartmentAddress())) {
		depDB.setDepartmentAddress(department.getDepartmentName());
	}
	 return departmentRepository.save(depDB);
	}
	@Override
	public Department fetchDepartmentByName(String departmentName) {
		
		return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
	}
}

