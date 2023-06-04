package com.example.demoapiget.services;

import java.util.Arrays;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.example.demoapiget.DTO.ContractReponseModel;
import com.example.demoapiget.DTO.LoginResponseModel;
import com.example.demoapiget.models.ContractData;
import com.example.demoapiget.models.LoginRequest;
@Service
public class ContractService {
        
    private RestTemplate restTemplate;

    public ContractService() {
        this.restTemplate = new RestTemplate();
    }

        public String getContracts(String contract,String date) 
        {
            String accessScore = null;
            String URL = "https://cads-api.fpt.vn/smartcpe/v2/getDaiyScoreSummary";
            try{
                String accessToken = getAccessToken();
                HttpHeaders headers = new HttpHeaders();
                headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
                headers.setContentType(MediaType.APPLICATION_JSON);
                ContractData contractData = new ContractData();
                contractData.setContract(contract);
                contractData.setDate(date);
                headers.set("Authorization",accessToken);
                HttpEntity<ContractData> httpEntity = new HttpEntity<ContractData>(contractData, headers);
                ResponseEntity<ContractReponseModel> responseEntity = restTemplate.exchange(URL, HttpMethod.POST, httpEntity, ContractReponseModel.class);
                accessScore = responseEntity.getStatusCode().toString();
                System.out.println(responseEntity.getBody().getStatus());
                System.out.println(responseEntity.getBody().getMessages());
                System.out.println(responseEntity.getBody().getData());
                // System.out.println(responseEntity.getBody().());
            }catch(Exception e){
                e.printStackTrace();
            }
           
            return accessScore;
        }
        private String getAccessToken() {
            String accessTokens = null;
            String tokenUrl = "https://cads-api.fpt.vn/smartcpe/v2/getToken";    
            try {
                HttpHeaders headers = new HttpHeaders();
                headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
                headers.setContentType(MediaType.APPLICATION_JSON);
        
                LoginRequest loginRequest = new LoginRequest();
                loginRequest.setClientId("QC9b9h0OgstJc3eeWPWOwmpLhb6Dbux6");
                loginRequest.setClientSecret("kM3CtxEfEj0nWrZT3DjCOd31AdAxJlcH");
        
                HttpEntity<LoginRequest> httpEntity = new HttpEntity<>(loginRequest, headers);
                ResponseEntity<LoginResponseModel> responseEntity = restTemplate.exchange(tokenUrl, HttpMethod.POST, httpEntity, LoginResponseModel.class);
                if (responseEntity.getStatusCode() == HttpStatus.OK) {
                    accessTokens = responseEntity.getStatusCode().toString();
                    System.out.println(responseEntity.getBody().getAccess_token());
                    return accessTokens = responseEntity.getBody().getAccess_token();
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            return accessTokens;
        }
    }

