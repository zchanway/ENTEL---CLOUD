package com.example.daw_resilience.controller;

import com.example.daw_resilience.service.EntelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/plans")
public class PlanController {

    @Autowired
    private EntelService entelService;

    @GetMapping("/{planId}")
    public ResponseEntity<String> checkPlan(@PathVariable Long planId) {
        String response = entelService.checkPlanAvailability(planId);
        return ResponseEntity.ok(response);
    }
}