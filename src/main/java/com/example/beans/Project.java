package com.example.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="project")
public class Project {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="project_id")
	private int projectId;
	@Column(name="project_name")
	private String projectName;
//	@OneToOne
//	private Employee Employee;
	
	
}
