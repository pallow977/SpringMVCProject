package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.entity.EmployeeEntity;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public EmployeeEntity authenticate(String emailId, String password) {
		EmployeeEntity employeeEntity=null;
		
		String sql="select * from employee where emailId=? and password=?";
		Object[] data= {emailId,password};  //pl@gmail.com      1111
		try {
		     employeeEntity=jdbcTemplate.queryForObject(sql, data, new BeanPropertyRowMapper<>(EmployeeEntity.class));
		}catch(Exception e) {
			e.printStackTrace();
		}
		return employeeEntity;  //employeeEntity may be null(if record not exist) or not null(if record exist)
	}

	//Get all records
	@Override
	public List<EmployeeEntity> getAllEmployee() {
		List<EmployeeEntity> employee=jdbcTemplate.query("select * from employee",new BeanPropertyRowMapper<>(EmployeeEntity.class)); //we will get all the records in the form of objects
		return employee; //this employee is a refereference variable which is collection of list of the Employees
	} 

}
