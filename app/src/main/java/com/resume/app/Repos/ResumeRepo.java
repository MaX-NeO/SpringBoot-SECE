package com.resume.app.Repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.resume.app.Models.Resume;

public interface ResumeRepo extends JpaRepository<Resume, Long> {

}
