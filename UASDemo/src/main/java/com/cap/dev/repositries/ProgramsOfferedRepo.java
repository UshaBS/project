package com.cap.dev.repositries;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.cap.dev.entities.Programs_Offered;

public interface ProgramsOfferedRepo extends JpaRepository<Programs_Offered, String>{

	@Transactional
	@Modifying
	@Query("UPDATE Programs_Offered e SET e.description=:description WHERE e.program_name=:program_name")
	int updateProgramsOffered(String program_name, String description);

	
	

	

}
