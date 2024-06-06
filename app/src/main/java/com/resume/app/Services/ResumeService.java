package com.resume.app.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resume.app.Models.Resume;
import com.resume.app.Repos.ResumeRepo;

@Service
public class ResumeService {

    @Autowired
    private ResumeRepo resume;

    public List<Resume> getResumes() {
        return resume.findAll();
    }

    public Resume addResume(Resume data) {
        return resume.save(data);
    }

    public Resume editResume(Long id, Resume newdata) {

        Resume findres = resume.findById(id).orElse(null);

        if (findres != null) {
            findres.setName(newdata.getName());
            findres.setAddress(newdata.getAddress());
            findres.setPhone(newdata.getPhone());
            findres.setProfileurl(newdata.getProfileurl());
            return resume.saveAndFlush(findres);
        }
        return null;
    }

    public String deleteResume(Long id) {

        resume.deleteById(id);
        return id + " User Deleted !";
    }
}
