package com.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginIntercepter implements HandlerInterceptor{
/*	使用springmvc拦截器实现登陆验证

	1. 把页面放入到web-inf中.
		1.1 放入到web-inf中后必须通过控制器转发到页面.
		1.2 springmvc拦截器拦截的是控制器,不能拦截jsp
		
	2. 通过拦截器拦截全部控制器,需要在拦截器内部放行login控制器*/
	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
		System.out.println("请求url ："+arg0.getRequestURI());
		if (arg0.getRequestURI().endsWith("login")) {
			return true;
		}else {
			Object attribute = arg0.getSession().getAttribute("user");
			if (attribute!=null) {
				return true;
			}else {
				System.out.println("重定向1");
				arg1.sendRedirect("/login.jsp");
				System.out.println("重定向2");
				return false;
			}
		}
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
	}
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
	}


}
