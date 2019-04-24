package com.cap.dev.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Programs_Offered {
	
@Id	
@Column
@NotNull(message = "Program name is mandatory")
private String program_name;

@NotNull(message = "Description is mandatory")
private String description;

@NotNull(message = "Applicant eligibility is mandatory")
private String applicant_eligibility;

@NotNull(message = "Duration is mandatory")
public int duration;

@NotNull(message = "Degree certificate is mandatory")
public String degree_certificate_offered;

	/*
	 * @JsonIgnore
	 * 
	 * @OneToMany(mappedBy = "programsOffered")
	 */
	/* private List<Programs_Scheduled> programScheduled; */


public String getProgram_name() {
	return program_name;
}
public void setProgram_name(String program_name) {
	this.program_name = program_name;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getApplicant_eligibility() {
	return applicant_eligibility;
}
public void setApplicant_eligibility(String applicant_eligibility) {
	this.applicant_eligibility = applicant_eligibility;
}
public int getDuration() {
	return duration;
}
public void setDuration(int duration) {
	this.duration = duration;
}
public String getDegree_certificate_offered() {
	return degree_certificate_offered;
}
public void setDegree_certificate_offered(String degree_certificate_offered) {
	this.degree_certificate_offered = degree_certificate_offered;
}

}
