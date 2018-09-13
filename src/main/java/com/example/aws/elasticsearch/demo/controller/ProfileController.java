package com.example.aws.elasticsearch.demo.controller;

import com.example.aws.elasticsearch.demo.document.ProfileDocument;
import com.example.aws.elasticsearch.demo.service.ProfileService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
public class ProfileController {

    private ProfileService service;

    @Autowired
    public ProfileController(ProfileService service) {

        this.service = service;
    }

    @PostMapping("/profiles")
    public String createName(@RequestBody ProfileDocument document) throws Exception {
        return service.createProfileDocument(document);
    }


    @PutMapping("/profiles")
    public String updateProfile(@RequestBody ProfileDocument document) throws Exception {

        return service.updateProfile(document);
    }

    @GetMapping("/profiles/{id}")
    public ProfileDocument findById(@PathVariable String id) throws Exception {

        return service.findById(id);
    }


    @GetMapping("/profiles")
    public List<ProfileDocument> findAll() throws Exception {

        return service.findAll();
    }

    @GetMapping(value = "/profiles/search")
    public List<ProfileDocument> search(
            @RequestParam(value = "technology") String technology) throws Exception {
        return service.searchByTechnology(technology);
    }

    @DeleteMapping("/leads/{id}")
    public String deleteLeadNameDocument(@PathVariable String id) throws Exception {

        return service.deleteProfileDocument(id);

    }


}
