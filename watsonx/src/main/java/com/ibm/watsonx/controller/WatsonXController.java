package com.ibm.watsonx.controller;

import com.ibm.watsonx.service.SkillsToAccountMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class WatsonXController {

    @Autowired
    private SkillsToAccountMapperService service;

    @PostMapping("/candidate/skills/mapping")
    public String getAccount(@RequestBody String candidateSkills) throws IOException {

        return service.qualifiedAccount(candidateSkills);
    }

}
