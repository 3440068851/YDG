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
//��ȡ�ͻ����ύ��ͼ����
			String clientImageCode = request.getParameter("checkCode");
//��ȡ�������˵�ͼ����
			String checkcode =(String)request.getSession().getAttribute("imageCode");
			request.setCharacterEncoding("UTF-8");
			response.getWriter().println("�ύ����֤��Ϊ"+clientImageCode);
			response.getWriter().println("����������֤��Ϊ"+checkcode);
			//��֤�����һ���ԣ���Ҫ���session
			request.getSession().removeAttribute("imagecode");
			
			//У��һ������֤��
			if(!clientImageCode.equalsIgnoreCase(checkcode)){
				request.setAttribute("msg", "��֤���������");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
				//return;
			}

	


		//��װ����
		User user = new User();
		
		user.setUsername(username);
		user.setPassword(password);
		//��������
		Jmodel jmodel=new Jmodel();
		User existUser = null;
		try {
			existUser = jmodel.login(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//ҳ����ת
		if(existUser==null){
			//��¼ʧ��
			//request�򱣴�һ��ֵ
			request.setAttribute("msg", "�û�����������󣬵�¼ʧ�ܣ�");
			//ʹ������ת��������ת
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}else{
			//��¼�ɹ�
			
			//�����û���Ϣ�����浽�Ự��
			HttpSession session = request.getSession();
			session.setAttribute("existuser", existUser);
			String remember = request.getParameter("remember");
			if("true".equals(remember)){
				//�Ѿ���ѡ��
				Cookie cookie = new Cookie("remember",existUser.getUsername());
				//������Ч·��
				//cookie.setPath("/Javaweb_login2");
				//������Чʱ��
				cookie.setMaxAge(60*60*24);
				//��cookie��д�������
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
