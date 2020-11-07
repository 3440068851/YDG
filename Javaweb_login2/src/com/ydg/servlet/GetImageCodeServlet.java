package com.ydg.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import imagecode.ImageCodeUtil;

/**
 * Servlet implementation class GetImageCodeServlet
 */
public class GetImageCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//…Ë÷√‰Ø¿¿∆˜≤ª“™ª∫¥Ê
				response.setHeader("pragma", "no-cache");
				response.setHeader("cache-control", "no-cache");
				response.setHeader("expires", "0");
				response.setContentType("image/jpeg");
				HttpSession session = request.getSession();
				ServletOutputStream sos = response.getOutputStream();
				String code = ImageCodeUtil.generateSimpleImageCode(sos);
				session.setAttribute("imageCode", code);

	}
 

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
