package com.cap.dev.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.cap.dev.services.ApplicantService;
import com.cap.dev.services.ProgramsOfferedService;
import com.cap.dev.services.ProgramsScheduledervice;


@Controller
public class ApplicationController {
	
	@Autowired
	private ApplicantService applicantserv;
	
	@Autowired
	private ProgramsScheduledervice programsofferedservice;
	
	@Autowired
	private ProgramsOfferedService programscheduledservice;
}
