package com.example.demoapiget.DTO;

// import java.util.List;

// import com.example.demoapiget.models.ContractData;

// import java.util.List;

// import com.example.demoapiget.models.ContractData;

import lombok.Data;

@Data
public class ContractReponseModel {
    private int status;
    private String messages;
    private Data data;
}
