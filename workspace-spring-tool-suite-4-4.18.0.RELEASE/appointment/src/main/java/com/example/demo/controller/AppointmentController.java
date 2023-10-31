package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.*;
import com.example.demo.model.*;


@RestController
public class AppointmentController {

	@Autowired
	AppointmentRepo repo;
	
	@RequestMapping("/")
	public String home()
	{
		return "home.jsp";
	}
	
	@GetMapping(path="/appointments")
	public List<Appointment> getAppointments()
	{
		return repo.findAll();
	}
	@RequestMapping("/appointment/{pId}")
	public Optional<Appointment> getAlien(@PathVariable("pId")int pId)
	{
		return repo.findById(pId);
		
	}
	@PostMapping(path="/appointment",consumes= {"application/json"})
	public Appointment addAppointment(@RequestBody Appointment appointment)
	{
		repo.save(appointment);
		return appointment;
	}
	@DeleteMapping("/appointment/{pId}")
	public String deleteAlien(@PathVariable int pId)
	{
		Appointment a = repo.getOne(pId);
		repo.delete(a);
		return "deleted";
	}
	@PutMapping(path="/appointment",consumes= {"application/json"})
	public Appointment updateAppointment(@RequestBody Appointment appointment)
	{
		repo.save(appointment);
		return appointment;
	}
	
	
}
