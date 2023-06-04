package com.example.demoapiget.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demoapiget.services.ContractService;
@RestController
public class TokenController {
    
    @Autowired
    private ContractService contractService;
    @PostMapping("/score")
    public String getContracts( String contract,String date) {
        return contractService.getContracts(contract, date);
    }
}
