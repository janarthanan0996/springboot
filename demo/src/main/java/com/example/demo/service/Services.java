package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Exception1.DataNotFoundException;
import com.example.demo.model.Register;
import com.example.demo.repository.Repo;

@Service
public class Services {
@Autowired 
Repo repo;

public Register add1(Register regi) 
{
	 return  repo.save(regi);
	
	
}

public List<Register> getdata2() {
	
	return repo.findAll();
}

public Optional<Register> getbyid2(int id) {
	
	return repo.findById(id);
}

public String update1(Integer id, Register regi) throws DataNotFoundException 
{
	Register oldregi=repo.findById(id)
			.orElseThrow(()-> new  DataNotFoundException("user not found"));
	//oldregi.setId(regi.getId());
	oldregi.setName(regi.getName());
	oldregi.setDepartment(regi.getDepartment());
	oldregi.setAddress(regi.getAddress());
	repo.save(oldregi);
	return "updated successfully";
}
}
