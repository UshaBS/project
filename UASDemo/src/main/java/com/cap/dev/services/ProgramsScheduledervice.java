package com.cap.dev.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cap.dev.entities.Application;

import com.cap.dev.entities.Programs_Offered;
import com.cap.dev.entities.Programs_Scheduled;
import com.cap.dev.repositries.ApplicantRepo;

import com.cap.dev.repositries.ProgramsScheduledRepo;


@Service
public class ProgramsScheduledervice{
	
	@Autowired
	private ProgramsScheduledRepo programsscheduledrepo;
	
	public List<Programs_Scheduled> getAllPrograms() {
		return programsscheduledrepo.findAll();
	}

	
	public Programs_Scheduled addProgramsScheduled(Programs_Scheduled programscheduled) {
		
		return programsscheduledrepo.save(programscheduled);
	}


	public Programs_Scheduled updateProgramsScheduled(Programs_Scheduled programscheduled) {
	    return programsscheduledrepo.save(programscheduled);
	}


	public String deleteProgramsScheduled(String scheduled_program_id) {
		programsscheduledrepo.deleteById(scheduled_program_id);
		return "Program got deleted successfully";
	}


	/*
	 * public Programs_Scheduled getParticularProgram(String startDate, String
	 * endDate) { return
	 * programsscheduledrepo.getParticularProgram(startDate,endDate); }
	 */

	

}
