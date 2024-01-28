package com.example.demo.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccountDto {
	private String user;
	private String pass;
	private String email;
}
