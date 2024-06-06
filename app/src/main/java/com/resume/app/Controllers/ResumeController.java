package com.resume.app.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.resume.app.Models.Resume;
import com.resume.app.Services.ResumeService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController("/api")
public class ResumeController {
    @Autowired
    private ResumeService service;

    @GetMapping("/resumes")
    public List<Resume> GetResumes() {
        return service.getResumes();
    }
    @PostMapping("/resume/add")
    public Resume AddResume(@RequestBody Resume resume){
        return service.addResume(resume);
    }
    @PutMapping("/resume/edit/{id}")
    public Resume EditResume(@RequestBody Resume resume, @PathVariable Long uid){
        return service.editResume(uid, resume);
    }
    @DeleteMapping("/resume/delete/{uid}")
    public String DeleteResume(@PathVariable Long uid){
        return service.deleteResume(uid);
    }
}
