package com.example.demo.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ch.qos.logback.core.model.Model;


@Controller

public class LoginController {
	
	@GetMapping("/accountLogin")	
	public String getLogin() {
		return "accountLogin";
	}
	
	@GetMapping("/") // ルートURL ("/") に対するGETリクエストを処理します
    public String showList(Authentication loginUser, Model model) {
        loginUser = SecurityContextHolder.getContext().getAuthentication(); // 現在のユーザーの認証情報を取得します
        if (loginUser != null && loginUser.isAuthenticated()) { // ユーザーがログインしている場合
            return "redirect:/index";  // "/index"にリダイレクトします
        }
        return "redirect:/login"; // ユーザーがログインしていない場合、"/login"にリダイレクトします
    }
}
