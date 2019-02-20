package com.bonobono.springboard.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LogingController {
	@GetMapping
	public String login() {
		return "login";
	}
	
	@PostMapping
	public String login(HttpSession session,	
						@RequestParam("id") String id, 
						@RequestParam("pw") String pw) {
		final String dbId = "admin";
		final String dbPw = "1234";
		// Session으로 써도 되고
		// Request를 사용하기 위해 HttpservletRequest
		
		if(id.equals(dbId) && pw.equals(dbPw)) {
			// 로그인 성공 -> 로그인 정보 세션 등록 ->...으로 이동
			session.setAttribute(id, id);
			return "redirect:/login";
		} else {
			// 로그인 실패-> 로그인 폼으로 리다이렉트
			return "redirect:/index";
		}
	}
}
