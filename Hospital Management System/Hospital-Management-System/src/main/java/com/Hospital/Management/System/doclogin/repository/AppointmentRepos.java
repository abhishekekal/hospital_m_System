package com.Hospital.Management.System.doclogin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Hospital.Management.System.doclogin.entity.Appointment;

public interface AppointmentRepos extends JpaRepository<Appointment,Long> {

}
