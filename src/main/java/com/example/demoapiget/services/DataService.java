package com.example.demoapiget.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demoapiget.DTO.ContractReponseModel;
import com.example.demoapiget.models.ContractData;
import com.example.demoapiget.models.DataEntry;
import com.example.demoapiget.models.ScoreData;

@Service
public class DataService {
    private RestTemplate restTemplate;
    
    @Autowired
    public DataService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    
    public List<DataEntry> getScoreDataByDate(String date) {
        String apiUrl = "https://cads-api.fpt.vn/smartcpe/v2/getDaiyScoreSummary";
        
        // Gửi yêu cầu GET để lấy dữ liệu từ token
        ResponseEntity<ContractReponseModel> responseEntity = restTemplate.getForEntity(apiUrl, ContractReponseModel.class);
        ContractReponseModel apiResponse = responseEntity.getBody();
        
        List<DataEntry> scoreDataList = new ArrayList<>();
        
        // Kiểm tra dữ liệu từ token và trả về dữ liệu tương ứng với ngày so sánh
        if (apiResponse != null && apiResponse.getStatus() == 200 && apiResponse.getData() != null) {
            ContractData data = (ContractData) apiResponse.getData();
            if (data.getDate().equals(date)) {
                data = (ContractData) data.getData();
            }
        }
        
        return scoreDataList;
    }
}
