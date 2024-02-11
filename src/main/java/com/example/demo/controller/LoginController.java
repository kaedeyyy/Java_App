package com.example.demo.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dto.UserForm;

import ch.qos.logback.core.model.Model;


@Controller

public class LoginController {
	
	@GetMapping("/accountLogin")	
	public String getLogin() {
		return "accountLogin";
	}
	
	@GetMapping("/")	
	public String index() {
		return "index";
	}
	
//	@GetMapping
//	public ModelAndView loginPage(ModelAndView modelAndView) {
//	    
//		UserForm userForm = new UserForm();  
//		
//	    modelAndView.addObject("userForm", userForm);
//	    modelAndView.setViewName("index");
//	    
//	    return modelAndView;
//	 }
	
//	@GetMapping("/") // ルートURL ("/") に対するGETリクエストを処理します
//	    public String showList(Authentication loginUser, Model model) {
//        loginUser = SecurityContextHolder.getContext().getAuthentication(); // 現在のユーザーの認証情報を取得します
//        if (loginUser != null && loginUser.isAuthenticated()) { // ユーザーがログインしている場合
//            return "redirect:/index";  // "/index"にリダイレクトします
//        }
//        return "redirect:/accountLogin"; // ユーザーがログインしていない場合、"/login"にリダイレクトします
//    }
}
