package com.example.demo.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.*;
public interface AppointmentRepo extends JpaRepository<Appointment,Integer> {
//List<Appointment> findByPName(String pname);

}
