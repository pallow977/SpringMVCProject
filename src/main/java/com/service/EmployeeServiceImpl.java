package com.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.dao.EmployeeDao;

@Service
public class EmployeeServiceImpl {
	
	@Autowired
	EmployeeDao employeeDao;

	
	
}
	