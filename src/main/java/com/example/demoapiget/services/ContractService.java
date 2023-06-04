package com.example.demoapiget.services;

// import java.util.Arrays;
// import java.util.List;

// import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.example.demoapiget.models.ContractData;

import lombok.Data;

@Service
public class ContractService {
        
        @Autowired
        private RestTemplate restTemplate;
        public ContractReponseModel getContracts(String contract,String date) 
        {
            String URL = "https://cads-api.fpt.vn/smartcpe/v2/getDaiyScoreSummary";
            UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(URL)
            .queryParam("contract", contract)
            .queryParam("date", date);
            ResponseEntity<ContractReponseModel> responseEntity = restTemplate.getForEntity(builder.toUriString(), ContractReponseModel.class);
            ContractReponseModel contractReponseModel = responseEntity.getBody();
            
            // Kiểm tra dữ liệu từ token và trả về kết quả dựa trên contract và date
            if (contractReponseModel != null && contractReponseModel.getStatus() == 200 && contractReponseModel.getData() != null) {
                Data contractData = contractReponseModel.getData();
                if (((ContractData) contractData).getContract().equals(contract) && ((ContractData) contractData).getDate().equals(date)) {
                    return contractReponseModel;
                }
             }
        
        // Trả về thông báo lỗi nếu không tìm thấy dữ liệu phù hợp
        ContractReponseModel errorResponse = new ContractReponseModel();
        errorResponse.setStatus(404);
        errorResponse.setMessages("Data not found for the given contract and date.");
        return errorResponse;
            // return accessScore;
        }
    }
// String accessScore = null;
// String URL = "https://cads-api.fpt.vn/smartcpe/v2/getDaiyScoreSummary";
// try{
//     HttpHeaders headers = new HttpHeaders();
//     headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//     headers.setContentType(MediaType.APPLICATION_JSON);
//     ResponseEntity<ContractReponseModel> responseEntity = restTemplate.getForEntity(URL, ContractReponseModel.class);
//     ContractData contractData = new ContractData();
//     HttpEntity<ContractData> httpEntity = new HttpEntity<ContractData>(contractData, headers);
//     ContractReponseModel contractReponseModel = responseEntity.getBody();
    
//     // Kiểm tra dữ liệu từ token và trả về kết quả dựa trên contract và date
//     if (contractReponseModel != null && contractReponseModel.getStatus() == 200 && contractReponseModel.getData() != null) {
//         List<ContractData> data = contractReponseModel.getData();
//         if (data.equals(contract) && data.equals(date)) {
//             return contractReponseModel;
//         }
//     }
//     // accessScore = responseEntity.getStatusCode().toString();
//     // System.out.println(responseEntity.getBody().getStatus());
//     // System.out.println(responseEntity.getBody().getMessages());
//     // System.out.println(responseEntity.getBody().getData());
// }catch(Exception e){
    
//     e.printStackTrace();
// }