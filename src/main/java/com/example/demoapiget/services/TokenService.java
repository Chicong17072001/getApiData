package com.example.demoapiget.services;

import java.util.Arrays;

// import org.springframework.boot.context.logging.LoggingApplicationListener;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;

// import java.net.http.HttpHeaders;

// import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demoapiget.DTO.LoginResponseModel;
import com.example.demoapiget.models.LoginRequest;

@Service
public class TokenService {
    // private static final String TOKEN_API_URL = "https://cads-api.fpt.vn/smartcpe/v2/getToken";
    private RestTemplate restTemplate;

    public TokenService() {
        this.restTemplate = new RestTemplate();
    }

    public String getToken() {
        String accessToken = null;
        String URL = "https://cads-api.fpt.vn/smartcpe/v2/getToken";
        try{
            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            headers.setContentType(MediaType.APPLICATION_JSON);
            LoginRequest loginRequest = new LoginRequest();
            loginRequest.setClientId("QC9b9h0OgstJc3eeWPWOwmpLhb6Dbux6");
            loginRequest.setClientSecret("kM3CtxEfEj0nWrZT3DjCOd31AdAxJlcH");
            HttpEntity<LoginRequest> httpEntity = new HttpEntity<LoginRequest>(loginRequest, headers);
            ResponseEntity<LoginResponseModel> responseEntity = restTemplate.exchange(URL, HttpMethod.POST, httpEntity, LoginResponseModel.class);
            accessToken = responseEntity.getStatusCode().toString();
            System.out.println(responseEntity.getBody().getAccess_token());
            System.out.println(responseEntity.getBody().getToken_type());
            System.out.println(responseEntity.getBody().getExpires_in());
        }catch(Exception e){
            
            e.printStackTrace();
        }
        return accessToken;
    }
}
