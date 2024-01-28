package com.example.demo.dao;

import org.springframework.stereotype.Service;

import com.example.demo.dto.AccountDto;
import com.example.demo.repository.AccountMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AccountDao {
	
	private final AccountMapper accountMapper;
	
	//ユーザー情報を取得するメソッド
	public AccountDto findByUsername(String username) {
		return accountMapper.findByUsername(username);
	}
	
}
