package com.cap.dev.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "scheduledProgramID")
public class Programs_Scheduled {
	@Id
	
	@SequenceGenerator(name="myseq",sequenceName ="program_seq", initialValue= 1000, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="myseq")
	private String scheduled_program_id;
	
	@NotNull(message = "ProgramName is Mandatory")
	private String  program_name;
	
	@NotNull(message = "location is Mandatory")
	private String location;
	
	@NotNull(message = "Startdate is Mandatory")
	private String start_date;
	
	@NotNull(message = "Enddate is Mandatory")
	private String end_date;
	
	@NotNull(message = "Sessions per week is Mandatory")
	private int sessions_per_week;
	
	/*
	 * @ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	 * 
	 * @JoinColumn(name="program_name",insertable = false,updatable = false)
	 */
	private Programs_Offered programsOffered;
	/*
	 * @JsonIgnore
	 * 
	 * @OneToMany(mappedBy = "programsScheduled")
	 */
	/* private List<Application> application; */
	
	
	public String getScheduled_program_id() {
		return scheduled_program_id;
	}
	public void setScheduled_program_id(String scheduled_program_id) {
		this.scheduled_program_id = scheduled_program_id;
	}
	public String getProgram_name() {
		return program_name;
	}
	public void setProgram_name(String program_name) {
		this.program_name = program_name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	public int getSessions_per_week() {
		return sessions_per_week;
	}
	public void setSessions_per_week(int sessions_per_week) {
		this.sessions_per_week = sessions_per_week;
	}
	
	

}
