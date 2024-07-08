package com.Hospital.Management.System.doclogin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.management.AttributeNotFoundException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.Hospital.Management.System.doclogin.entity.Medicine;
import com.Hospital.Management.System.doclogin.repository.medicineRepos;

@RestController
@RequestMapping("/api/v3")
@CrossOrigin("*")
public class medicinecontroller {
	
	private medicineRepos medicineRepos;

	public medicinecontroller(com.Hospital.Management.System.doclogin.repository.medicineRepos medicineRepos) {
		super();
		this.medicineRepos = medicineRepos;
	}
	@PostMapping
	public Medicine intertmedicine(@RequestBody  Medicine medicine) {
		return medicineRepos.save(medicine);
		
	}
	
	@GetMapping()
	public List<Medicine>getmedicine(){
		return medicineRepos.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Medicine> getmedicinesbyid(@PathVariable long id) throws AttributeNotFoundException{
	Medicine medicine=	medicineRepos.findById(id).orElseThrow(()-> new AttributeNotFoundException("Medicine not found "+id));
	
	return ResponseEntity.ok(medicine);
	}
    @PutMapping("/{id}")
	public ResponseEntity<Medicine> updateMedicine(@PathVariable long id, @RequestBody Medicine medicinedata) throws AttributeNotFoundException{
	Medicine medicine=	medicineRepos.findById(id).orElseThrow(()-> new AttributeNotFoundException("Medicine not found "+id));
	
	medicine.setStock(medicinedata.getStock());
	medicine.setDrugName(medicinedata.getDrugName());

	medicineRepos.save(medicine);
	return ResponseEntity.ok(medicine);
	}
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String,Boolean>> deletemediciences( @PathVariable Long id) throws AttributeNotFoundException{
    Medicine medicine=medicineRepos.findById(id).orElseThrow(()->new AttributeNotFoundException("Appointment ID not found"+id));
    medicineRepos.delete(medicine);

    Map<String, Boolean> response=new HashMap<String,Boolean>();
    response.put("Deleted",Boolean.TRUE);// seen into the json massage 
    return ResponseEntity.ok(response);

    }
}
