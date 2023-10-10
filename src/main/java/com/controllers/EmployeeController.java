package com.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dto.EmployeeDTO;
import com.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping({"/login","/"})
	public String authenticateUser() {
		return "login";    // /WEB-INF/pages/login.jsp
	}	
	
	@PostMapping("/validate")
	//from client side two data are coming. So our first work is to read the data
	public String authenticateEmp(@RequestParam String emailId,@RequestParam String password,Model model) {
		EmployeeDTO employeeDTO=employeeService.authenticate(emailId,password);
		
		if(employeeDTO!=null) {
		
			System.out.println("Record exist");
			model.addAttribute("employeeDTO", employeeDTO);
			//return "congratulation";
			return "congratulations";
			
		}else {
			System.out.println("Record does not exist");
			model.addAttribute("message", "Wrong credential");
			return "login";			
		}			
	}
	//get all records
	@GetMapping("/showEmployee")
	public String getAllEmployee(Model model) {
		List<EmployeeDTO> employeeDTO =employeeService.getAllEmployee();
		
		System.out.println("List of records ="+employeeDTO.size()); //9
		model.addAttribute("employeeDTO", employeeDTO);
		
		return "showAll";
	}
	
	
}
