package com.cap.dev.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cap.dev.Exception.UniversityAdmissionException;
import com.cap.dev.entities.Application;

import com.cap.dev.entities.Programs_Offered;
import com.cap.dev.entities.Programs_Scheduled;
import com.cap.dev.services.ApplicantService;
import com.cap.dev.services.ProgramsOfferedService;
import com.cap.dev.services.ProgramsScheduledervice;

@RestController
public class AppController {

	@Autowired
	private ApplicantService applicantServ;
	
	@Autowired
	private ProgramsScheduledervice programsScheduledServ;
	
	@Autowired
	private ProgramsOfferedService programsOfferedServ;


	/************************************Applicant services*********************************************/
	

@RequestMapping(value="/scheduledprograms")	
public List<Programs_Scheduled> getAllPrograms() throws UniversityAdmissionException{
	try{
		return programsScheduledServ.getAllPrograms();
	}
	catch(Exception e) {
		throw new UniversityAdmissionException(204,e.getMessage());
	}
}



@RequestMapping(value="/applyapplication",method=RequestMethod.POST)
public Application applyApplication(@RequestBody Application application) throws UniversityAdmissionException {
	try {
	return applicantServ.applyApplication(application);
	}
	catch(Exception e) {
		throw new UniversityAdmissionException(500,e.getMessage());
	}
}


@RequestMapping(value="/getapplicationstatus/{application_id}")
public String getApplicationStatus(@PathVariable int application_id) throws UniversityAdmissionException {
	try{
		return applicantServ.getApplicationStatus(application_id);
	}
	catch(Exception e) {
		throw new UniversityAdmissionException(204,e.getMessage());
	}
	
}


/***************************MAC Services***************************************/


@RequestMapping(value="/getapplication/{scheduled_program_id}")
public Application getApplications(@PathVariable int scheduled_program_id) throws UniversityAdmissionException {
	try{
		return applicantServ.getApplications(scheduled_program_id);
	}
	catch(Exception e) {
		throw new UniversityAdmissionException(204,e.getMessage());
	}
}



@RequestMapping(value="/applicationstatus/{application_id}",method=RequestMethod.PUT)
public Application acceptOrReject(@RequestBody Application application,@PathVariable int application_id) throws UniversityAdmissionException {
	try{
		return applicantServ.acceptOrReject(application,application_id);
	}
	catch(Exception e) {
		throw new UniversityAdmissionException(204,e.getMessage());
	}
}









/**********************Administration Services(ProgramsScheduled)****************************/




@RequestMapping(value="/ProgramsScheduled",method=RequestMethod.POST)
public Programs_Scheduled addProgramsScheduled(@RequestBody Programs_Scheduled programscheduled) throws UniversityAdmissionException {
	try{
		return programsScheduledServ.addProgramsScheduled(programscheduled);
	}
	catch(Exception e) {
		throw new UniversityAdmissionException(400,e.getMessage());
	}
}


@RequestMapping(value="/ProgramsScheduled",method=RequestMethod.PUT)
public Programs_Scheduled updateProgramsScheduled(@RequestBody Programs_Scheduled programscheduled) throws UniversityAdmissionException {
	try{
		return programsScheduledServ.updateProgramsScheduled(programscheduled);
	}
	catch(Exception e) {
		throw new UniversityAdmissionException(204,e.getMessage());
	}
}



@RequestMapping(value="/ProgramsScheduled/{scheduled_program_id}",method=RequestMethod.DELETE)
public String deleteProgramsScheduled(@PathVariable String scheduled_program_id) throws UniversityAdmissionException {
	try{
		return programsScheduledServ.deleteProgramsScheduled(scheduled_program_id);
	}
	catch(Exception e) {
		throw new UniversityAdmissionException(204,e.getMessage());
	}

}
/**********************Administration(managing ProgramsOffered)***************************/




@RequestMapping(value="/ProgramsOffered",method=RequestMethod.POST)
public Programs_Offered addProgramsOffered(@RequestBody Programs_Offered programsOffered) throws UniversityAdmissionException {
	try{
		return programsOfferedServ.addProgramsOffered(programsOffered);
	}
	catch(Exception e) {
		throw new UniversityAdmissionException(204,e.getMessage());
	}
}



@RequestMapping(value="/ProgramsOffered",method=RequestMethod.PUT)
public Programs_Offered updateProgramsOffered(@RequestBody Programs_Offered programsOffered,@PathVariable String program_name) throws UniversityAdmissionException {
	try{
		return programsOfferedServ.updateProgramsOffered(programsOffered,program_name);
	}
	catch(Exception e) {
		throw new UniversityAdmissionException(204,e.getMessage());
	}
}

@RequestMapping(value="/ProgramsOffered/{program_name}",method=RequestMethod.DELETE)
public String deleteProgramsOffered(@PathVariable String program_name) throws UniversityAdmissionException {
	try{
		return programsOfferedServ.deleteProgramsOffered(program_name);
	}
	catch(Exception e) {
		throw new UniversityAdmissionException(204,e.getMessage());
	}
}


@RequestMapping(value="/ProgramsOffered")	
public List<Programs_Offered> getPrograms() throws UniversityAdmissionException{
	try{
		return programsOfferedServ.getPrograms();
	}
	catch(Exception e) {
		throw new UniversityAdmissionException(204,e.getMessage());
	}
}
/***************************Administration services ******************************/


@RequestMapping(value="/ApplicationGet/{status}",method=RequestMethod.GET)
public List<Application> getAllApplicants(@PathVariable String status) throws UniversityAdmissionException {
	try{
		return applicantServ.getApplicants(status);
	}
	catch(Exception e) {
		throw new UniversityAdmissionException(204,e.getMessage());
	}
}


	/*
	 * @RequestMapping(value="/ProgramsScheduledProgram/{start_date}/{end_date}")
	 * public Programs_Scheduled getParticularProgram(@PathVariable String
	 * start_date,@PathVariable String end_date) throws UniversityAdmissionException
	 * { start_date=start_date.replace('-', '/'); end_date=end_date.replace('-',
	 * '/'); try{ return
	 * programsScheduledServ.getParticularProgram(start_date,end_date); }
	 * catch(Exception e) { throw new
	 * UniversityAdmissionException(204,e.getMessage()); } }
	 */


}
