package com.Hospital.Management.System.doclogin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Hospital.Management.System.doclogin.entity.Medicine;

public interface medicineRepos extends JpaRepository<Medicine,Long>{

}
