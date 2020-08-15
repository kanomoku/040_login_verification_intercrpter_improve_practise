package com.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pojo.User;

@Controller
public class LoginController {
	@RequestMapping("{page}")
	public String main(@PathVariable String page) {
		System.out.println(page);
		///myspringmvc012_login_verification/WebContent/WEB-INF/page/main.jsp
//		return "/WEB-INF/page/"+page+".jsp";  配置viewResolver控制器这里就可以优化成下面的了
		return page;
	}
	
    //和上面的不冲突优先匹配最匹配的
	@RequestMapping("login")
	public String login(User user,HttpServletRequest req) {
		if (user.getUsername().equals("admin")&&user.getPassword().equals("123")) {
			req.getSession().setAttribute("user", user);
			return "main";
		} else {
			return "redirect:/login.jsp";
		}
		
		
	}

}
