package com.example.demo.securityUserDetails;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.dao.AccountDao;
import com.example.demo.dto.AccountDto;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	private final AccountDao accountDao;
    
    public UserDetailsServiceImpl(AccountDao accountDao) {
        this.accountDao = accountDao;
    }
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	
    	// DBからユーザー名に一致するデータを取得し、accountに詰める
    	AccountDto accountDto = accountDao.findByUsername(username);
    	
    	return User.withUsername(accountDto.getUser())
                   .password(accountDto.getPass())
                   .build();
    }

}
