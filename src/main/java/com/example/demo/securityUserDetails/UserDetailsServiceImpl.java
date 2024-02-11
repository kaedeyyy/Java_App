package com.example.demo.securityUserDetails;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.dao.AccountDao;
import com.example.demo.dto.AccountDto;
import com.example.demo.dto.UserForm;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	//private final AccountDto accountDto;
    
    //public UserDetailsServiceImpl(UserForm userForm) {
    //    this.accountDao = userForm;
    //}
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	
    	// DBからユーザー名に一致するデータを取得し、accountに詰める
    	//AccountDto accountDto = accountDao.findByUsername(username);
    	
//    	return User.withUsername(accountDto.getUser())
//                   .password(accountDto.getPass())
//                   .build();
    	return User.withUsername("user").password("pass").build();
    }

}
