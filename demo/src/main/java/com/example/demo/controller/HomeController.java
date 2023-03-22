package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Exception1.DataNotFoundException;
import com.example.demo.model.Register;
import com.example.demo.service.Services;



@RestController
@RequestMapping("/homepage")
public class HomeController {
	@GetMapping("/getuser")
public String getUser() 
{
return "welcome";	
}
//	@GetMapping("/getbyname/{name}")
//public String getByName(@PathVariable(value="name")String a) 
//{
//return "welcome"+a;	
//}
//	@GetMapping("/getbynamepass/{name}/{password}")
//public String getByNamePass(@PathVariable(value="name")String a,@PathVariable(value="password") String p) 
//{
//return "welcome"+a+","+p;	
//}
	@Autowired
	Services services;
	
	@PostMapping("/register")
	public Register add(@RequestBody Register regi) 
	{
		 
		 
		return services.add1(regi);
		
		
	}
	@GetMapping("/getall")
	public List<Register> getdata1()
	{
		return services.getdata2();
	}
	@GetMapping("/getid/{id}")
	public Optional<Register> getbyid(@PathVariable(value="id") Integer id) 
	{
		return services.getbyid2(id);
		
	}
	@PutMapping("/update/{id}")
	public String update(@PathVariable(value="id") Integer id,
			@RequestBody Register regi) throws DataNotFoundException 
	{
	
		return services.update1(id, regi);
		
		
	}
	
}
