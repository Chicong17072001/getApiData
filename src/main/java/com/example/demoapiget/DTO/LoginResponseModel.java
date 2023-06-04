package com.example.demoapiget.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponseModel {
    private String token_type;
    private String access_token;
    private int expires_in;
}
