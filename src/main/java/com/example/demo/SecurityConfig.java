package com.example.demo;

import org.springframework.boot.autoconfigure.security.reactive.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	//パスワードエンコードのロジック
	@Bean
    public PasswordEncoder passwordEncoder() {
        //return new NoOpPasswordEncoder();
		return new BCryptPasswordEncoder();
    }
	
	@Bean
	  public UserDetailsService userDetailsService() {
	      UserDetails admin = User.builder().username("admin")
	              .password(passwordEncoder().encode("pass")).authorities("ADMIN").build();
	      UserDetails user = User.builder().username("user")
	              .password(passwordEncoder().encode("pass")).authorities("USER").build();

	      //System.out.println(passwordEncoder().encode("pass"));
	      //System.out.println(passwordEncoder().encode("password"));

	      return new InMemoryUserDetailsManager(admin, user);
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
            	//th:actionと一致している必要あり
            	.loginProcessingUrl("/login")
                // ログインページへのパスを指定→コントローラーにもGET、/loginでの処理を記載する必要がある
                .loginPage("/accountLogin")
                // ログイン成功時に表示される画面へのパス
                .defaultSuccessUrl("/")
                .permitAll()
            );
            

        return http.build();
    }
}
