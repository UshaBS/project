package com.cap.dev.repositries;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cap.dev.entities.Application;
import com.cap.dev.entities.Programs_Offered;

@Repository
public interface ApplicantRepo extends JpaRepository<Application, Integer>{

	

	List<Application> findByStatus(String status);

	@Query("SELECT e.status FROM Application e WHERE e.application_id=:application_id")
	
	String findByApplicationId(int application_id);
	
	@Transactional
	@Modifying
	@Query("UPDATE Application  m SET m.status=:status where m.application_id =:application_id")
	int updateApplicantDetails(@Param(value="application_id") int applicationId,@Param(value="status") String status);

	

}
