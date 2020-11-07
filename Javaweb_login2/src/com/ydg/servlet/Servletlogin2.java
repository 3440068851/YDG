package com.ydg.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hk.domain.User;
import com.tg.model.Jmodel;


/**
 * Servlet implementation class Servletlogin2
 */
public class Servletlogin2 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			request.setCharacterEncoding("UTF-8");
			String username=request.getParameter("username");
			String password=request.getParameter("password");
//获取客户端提交的图像码
			String clientImageCode = request.getParameter("checkCode");
//获取服务器端的图像码
			String checkcode =(String)request.getSession().getAttribute("imageCode");
			request.setCharacterEncoding("UTF-8");
			response.getWriter().println("提交的验证码为"+clientImageCode);
			response.getWriter().println("服务器的验证码为"+checkcode);
			//验证码具有一次性，需要清空session
			request.getSession().removeAttribute("imagecode");
			
			//校验一次性验证码
			if(!clientImageCode.equalsIgnoreCase(checkcode)){
				request.setAttribute("msg", "验证码输入错误！");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
				//return;
			}

	


		//封装数据
		User user = new User();
		
		user.setUsername(username);
		user.setPassword(password);
		//处理数据
		Jmodel jmodel=new Jmodel();
		User existUser = null;
		try {
			existUser = jmodel.login(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//页面跳转
		if(existUser==null){
			//登录失败
			//request域保存一个值
			request.setAttribute("msg", "用户名或密码错误，登录失败！");
			//使用请求转发进行跳转
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}else{
			//登录成功
			
			//保存用户信息，保存到会话中
			HttpSession session = request.getSession();
			session.setAttribute("existuser", existUser);
			String remember = request.getParameter("remember");
			if("true".equals(remember)){
				//已经勾选了
				Cookie cookie = new Cookie("remember",existUser.getUsername());
				//设置有效路径
				//cookie.setPath("/Javaweb_login2");
				//设置有效时间
				cookie.setMaxAge(60*60*24);
				//将cookie回写到浏览器
				response.addCookie(cookie);
			
			}
			response.sendRedirect("/Javaweb_login2/jsp/success.jsp");
			
			
			
			
	}
	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
