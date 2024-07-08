package com.Hospital.Management.System.controller;

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
import org.springframework.web.service.annotation.PutExchange;

import com.Hospital.Management.System.entity.Patient;
import com.Hospital.Management.System.repositeres.PatientRepository;
@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class PatientController {
	
 private PatientRepository patientRepository;

public PatientController(PatientRepository patientRepository) {
	super();
	this.patientRepository = patientRepository;
}
 
@PostMapping
public Patient createPatient(@RequestBody Patient patient) {
	return patientRepository.save(patient);
}

@GetMapping()
public List<Patient> getpatient(){
	return patientRepository.findAll();
}
 
@DeleteMapping("/{id}")
public ResponseEntity<Map<String,Boolean>> deletepatient(@PathVariable Long id) throws AttributeNotFoundException{
Patient patient=patientRepository.findById(id).orElseThrow(()->new AttributeNotFoundException("patient ID not found"+id));
patientRepository.delete(patient);

Map<String, Boolean> response=new HashMap<String,Boolean>();
response.put("Deleted",Boolean.TRUE);// seen into the json massage 
return ResponseEntity.ok(response);

}


@GetMapping("/{id}")
public ResponseEntity<Patient> getpatientbyid(@PathVariable long id) throws AttributeNotFoundException{
	Patient patient= patientRepository.findById(id).orElseThrow(()-> new AttributeNotFoundException("Patient not found by the id"+id));
return ResponseEntity.ok(patient);

}







@PutMapping("/{id}")
public ResponseEntity<Patient> updatePatient(@PathVariable long id, @RequestBody Patient patient) throws AttributeNotFoundException{
	Patient patientdel=patientRepository.findById(id).orElseThrow(()->new AttributeNotFoundException("patient ID not found"+id));
	
	patientdel.setAge(patient.getAge());
	patientdel.setName(patient.getName());
	patientdel.setBlood(patient.getBlood());
	patientdel.setDose(patient.getDose());
	patientdel.setFees(patient.getFees());
	patientdel.setPrescription((patient.getPrescription()));
	patientdel.setUrgency(patient.getUrgency());
	
	
	Patient savepatient=  patientRepository.save(patientdel);
	
	return ResponseEntity.ok(savepatient);
	

}

 
}
