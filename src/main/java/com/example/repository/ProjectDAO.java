package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.beans.Project;
@Repository
public interface ProjectDAO extends JpaRepository<Project,Integer>{

}
