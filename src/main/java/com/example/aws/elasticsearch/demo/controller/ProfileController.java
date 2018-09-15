package com.example.aws.elasticsearch.demo.controller;

import com.example.aws.elasticsearch.demo.document.ProfileDocument;
import com.example.aws.elasticsearch.demo.service.ProfileService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api/v1/profiles")
public class ProfileController {

    private ProfileService service;

    @Autowired
    public ProfileController(ProfileService service) {

        this.service = service;
    }

    @PostMapping
    public ResponseEntity createProfile(@RequestBody ProfileDocument document) throws Exception {

        return new ResponseEntity(service.createProfileDocument(document), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity updateProfile(@RequestBody ProfileDocument document) throws Exception {

        return new ResponseEntity(service.updateProfile(document), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ProfileDocument findById(@PathVariable String id) throws Exception {

        return service.findById(id);
    }


    @GetMapping
    public List<ProfileDocument> findAll() throws Exception {

        return service.findAll();
    }

    @GetMapping(value = "/search")
    public List<ProfileDocument> search(
            @RequestParam(value = "technology") String technology) throws Exception {
        return service.searchByTechnology(technology);
    }

    @DeleteMapping("/{id}")
    public String deleteProfileDocument(@PathVariable String id) throws Exception {

        return service.deleteProfileDocument(id);

    }


}
