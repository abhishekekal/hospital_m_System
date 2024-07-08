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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Hospital.Management.System.doclogin.entity.Appointment;
import com.Hospital.Management.System.doclogin.repository.AppointmentRepos;


@RestController
@RequestMapping("/api/v2")
@CrossOrigin("*")
public class Appointmentcontrooler {
	
private	AppointmentRepos apppAppointmentRepos;

public Appointmentcontrooler(AppointmentRepos apppAppointmentRepos) {
	super();
	this.apppAppointmentRepos = apppAppointmentRepos;
}

@PostMapping
public Appointment appointment(@RequestBody Appointment appointment) {
	return apppAppointmentRepos.save(appointment);
}
	
@GetMapping
public List<Appointment> getappointment(){
	return apppAppointmentRepos.findAll();
}

//imp

@DeleteMapping("/{id}")
public ResponseEntity<Map<String,Boolean>> deleteAppointment( @PathVariable Long id) throws AttributeNotFoundException{
Appointment appointment=apppAppointmentRepos.findById(id).orElseThrow(()->new AttributeNotFoundException("Appointment ID not found"+id));
apppAppointmentRepos.delete(appointment);

Map<String, Boolean> response=new HashMap<String,Boolean>();
response.put("Deleted",Boolean.TRUE);// seen into the json massage 
return ResponseEntity.ok(response);

}

}
