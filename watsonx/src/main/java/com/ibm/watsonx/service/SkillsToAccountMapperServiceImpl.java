package com.ibm.watsonx.service;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class SkillsToAccountMapperServiceImpl implements SkillsToAccountMapperService {


    @Override
    public String qualifiedAccount(String candidateCv) {

        Map<String, List<String>> accountMap = new HashMap<>();
        accountMap.put("Finance Account (Java Web & Tech)", List.of("Java", "OOP", "Java EE", "Junit", "Springboot", "Spring", "REST API", "Rest", "WebServices", "AWS", "Cloud", "Deployment", "Unit test", "Build", "Deploy", "Pipeline",
                "Java SE",
                "Java EE",
                "Oracle",
                "JDBC",
                "RESTful",
                "SOAP",
                "Maven",
                "Gradle",
                "JUnit",
                "Design Patterns",
                "OAuth"));
        accountMap.put("Banking Account (Java Web & Tech)", List.of("Java", "OOP", "Java EE", "Junit", "Springboot", "Spring",  "Deployment", "Unit test", "Build", "Deploy", "Pipeline",
                "Java SE",
                "Java EE",
                "MySQL",
                "Gradle",
                "JUnit",
                "Design Patterns",
                "Multithreading",
                "Garbage Collection"));
        accountMap.put("Insurance Account (Java Fullstack)", List.of("Java", "Java EE", "Junit", "Springboot", "Spring", "REST API", "Rest", "WebServices", "UI", "ReactJS", "Javascript", "HTML", "CSS", "AngularJS", "UI", "UX",
                "HTML",
                "CSS",
                "JavaScript",
                "Frontend",
                "React",
                "Angular",
                "Vue",
                "RESTful APIs",
                "SQL", "MongoDB",
                "Git",
                "AWS",
                "Azure",
                "GCP",
                "Docker",
                "Microservice",
                "Agile"));
        accountMap.put("Tech Account (Python)", List.of("Python", "Django", "MySQL", "REST API", "NGINX", "Agile", "Jira", "Node", "PyCharm", "Pandas", "NumPy", "Git", "Virtual Environment",
                "Object-Oriented Programming (OOP)",
                "Data Analysis",
                "Data Visualization",
                "API Development",
                "SQL", "MongoDB",
                "RESTful APIs",
                "Git",
                "Unit Test",
                "Automation",
                "Web Scraping",
                "Machine Learning",
                "AI",
                "AWS",
                "Azure",
                "GCP",
                "Docker",
                "Microservices",
                "CI/CD Pipelines",
                "Agile Methodologies"));

        Map<String, Double> accountMatchPercentage = new HashMap<>();

        for (Map.Entry<String, List<String>> entry : accountMap.entrySet()) {

            System.out.println(entry.getKey());

            int keywordCount = 0;
            for (String s : entry.getValue()) {

                if (candidateCv.toLowerCase().contains(s.toLowerCase())) {
                    System.out.println("Contains " + s);
                    keywordCount++;
                }
            }

            Double percentage = (double) ((keywordCount * 100) / entry.getValue().size());
            accountMatchPercentage.put(entry.getKey(), percentage);

        }

        return "Here's the percentage mapping for each account: \n" + accountMatchPercentage.keySet().stream()
                .map(key -> key + ": " + accountMatchPercentage.get(key) + "%")
                .collect(Collectors.joining("\n"));
    }
}
