package com.cap.dev.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cap.dev.entities.Application;
import com.cap.dev.entities.Programs_Offered;
import com.cap.dev.repositries.ApplicantRepo;
import com.cap.dev.repositries.ProgramsOfferedRepo;


@Service
public class ApplicantService {
	
	@Autowired
	private ApplicantRepo applicantrepo;
	
	
	public Application applyApplication(Application application) {
		
		return applicantrepo.save(application);
	}

	public String getApplicationStatus(int application_id) {
	    return applicantrepo.findByApplicationId(application_id);
	    
	}

	public Application getApplications(int scheduled_program_id) {
		return applicantrepo.getOne(scheduled_program_id);
		
	}

	public Application acceptOrReject(Application application, int application_id) {
		Application existingApplicant = (Application) applicantrepo.getOne(application_id);
		application.setApplication_id(application_id);
		BeanUtils.copyProperties(application, existingApplicant);
		int status=applicantrepo.updateApplicantDetails(application_id,existingApplicant.getStatus());
		return applicantrepo.getOne(application_id);
	}

	
	

	public List<Application> getApplicants(String status) {
		return applicantrepo.findByStatus(status);
	}

	

}

