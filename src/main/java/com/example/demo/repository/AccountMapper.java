package com.example.demo.repository;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.dto.AccountDto;

@Mapper
public interface AccountMapper {
	
	//ユーザー情報の取得
	AccountDto findByUsername(String username);
}
