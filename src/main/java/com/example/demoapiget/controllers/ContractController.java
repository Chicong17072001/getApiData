package com.example.demoapiget.controllers;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoapiget.DTO.ContractReponseModel;
import com.example.demoapiget.services.ContractService;



@RestController
public class ContractController {
    @Autowired
    private ContractService contractService;
    @GetMapping("/score")
    public ContractReponseModel getContracts( @RequestParam("contract") String contract,@RequestParam("date") String date) {
        return contractService.getContracts(contract, date);
    }
}
