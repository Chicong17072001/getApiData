package com.example.demoapiget.services;

import java.util.Arrays;

// import java.util.Arrays;
// import java.util.List;

// import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
// import org.springframework.http.HttpEntity;
// import org.springframework.http.HttpHeaders;
// import org.springframework.http.HttpMethod;
// // import org.springframework.http.HttpEntity;
// // import org.springframework.http.HttpHeaders;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.MediaType;
// import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.demoapiget.DTO.ContractReponseModel;
import com.example.demoapiget.DTO.LoginResponseModel;
import com.example.demoapiget.models.ContractData;

import lombok.Data;

@Service
public class ContractService {
        
    @Autowired
    private RestTemplate restTemplate;
    public String getContracts(String contract,String date) 
    {
        String AccessScore = null;
        String URL = "https://cads-api.fpt.vn/smartcpe/v2/getDaiyScoreSummary";
        try{
            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            headers.setContentType(MediaType.APPLICATION_JSON);
            ContractData contractData = new ContractData();
            contractData.setContract(contract);
            contractData.setDate(date);
            LoginResponseModel loginResponseModel = new LoginResponseModel();
            headers.set("Authorization",loginResponseModel.getAccess_token());
            HttpEntity<ContractData> httpEntity = new HttpEntity<ContractData>(contractData, headers);
            ResponseEntity<ContractReponseModel> responseEntity = restTemplate.exchange(URL, HttpMethod.POST, httpEntity, ContractReponseModel.class);
            // ContractReponseModel contractReponseModel = responseEntity.getBody();
            AccessScore = responseEntity.getStatusCode().toString();
            System.out.println(responseEntity.getBody().getStatus());
            System.out.println(responseEntity.getBody().getMessages());
            System.out.println(responseEntity.getBody().getData());
        }catch(Exception e){
            e.printStackTrace();
        }
       
        return AccessScore;
    }
    }

