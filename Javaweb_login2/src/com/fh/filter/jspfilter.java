package com.fh.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.hk.domain.User;

public class jspfilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		HttpServletRequest rqt = (HttpServletRequest) arg0;
			User existuser=(User) rqt.getSession().getAttribute("existuser");
			if(existuser==null){
				//没有登录
				rqt.setAttribute("msg", "您还没有登录，无访问权限");
				rqt.getRequestDispatcher("../../login.jsp").forward(rqt, arg1);
				
			}else{
				//登录了
				arg2.doFilter(rqt, arg1);
				
			}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
