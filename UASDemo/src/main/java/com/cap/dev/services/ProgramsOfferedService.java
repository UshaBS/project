package com.cap.dev.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cap.dev.entities.Application;
import com.cap.dev.entities.Programs_Offered;
import com.cap.dev.repositries.ProgramsOfferedRepo;



@Service
public class ProgramsOfferedService {
	
	@Autowired
	private ProgramsOfferedRepo programsofferedrepo;

	
	public Programs_Offered addProgramsOffered(Programs_Offered programsOffered) {
		return programsofferedrepo.save(programsOffered);
	}

	public Programs_Offered updateProgramsOffered(Programs_Offered programsOffered, String programName) {
		return programsofferedrepo.save(programsOffered);
		/*
		 * Programs_Offered programsOfferedExisting =
		 * programsofferedrepo.getOne(programName);
		 * programsOffered.setProgram_name(programName);
		 * BeanUtils.copyProperties(programsOfferedExisting,programsOffered); int
		 * status=programsofferedrepo.updateProgramsOffered(programName,
		 * programsOfferedExisting.getDescription()); return
		 * programsofferedrepo.getOne(programName);
		 */
	}

	public String deleteProgramsOffered(String programName) {
		programsofferedrepo.deleteById(programName);
		return "Program got deleted";
	}

	public List<Programs_Offered> getPrograms() {
		
		return programsofferedrepo.findAll();
	}

}
