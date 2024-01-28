package com.example.demo;

import org.springframework.boot.autoconfigure.security.reactive.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	//パスワードエンコードのロジック
	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
	@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
        	
        	
        //.logout((logout) -> logout.permitAll())
            .authorizeHttpRequests(requests -> requests
            		.requestMatchers(PathRequest.toStaticResources().atCommonLocations().toString()).permitAll()
            	    .requestMatchers("/accountLogin").permitAll()
            	    //.requestMatchers("/admin/**").hasAuthority("ROLE_ADMIN")
           	    .anyRequest().authenticated()
            )
            
            .formLogin(form -> form
            	//.loginProcessingUrl("/accountLogin")
                // ログインページへのパスを指定→コントローラーにもGET、/loginでの処理を記載する必要がある
                .loginPage("/accountLogin")
                // ログイン成功時に表示される画面へのパス
                .defaultSuccessUrl("/")
                .permitAll()
            );
            

        return http.build();
    }
}
