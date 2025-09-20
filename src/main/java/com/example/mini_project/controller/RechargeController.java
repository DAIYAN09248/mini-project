package com.example.mini_project.controller;

import com.example.mini_project.model.Recharge;
import com.example.mini_project.service.RechargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recharges")
public class RechargeController {
    @Autowired
    private RechargeService rechargeService;

    @PostMapping
    public ResponseEntity<Recharge> createRecharge(@RequestBody Recharge recharge) {
        try {
            Recharge createdRecharge = rechargeService.createRecharge(recharge);
            return new ResponseEntity<>(createdRecharge, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}