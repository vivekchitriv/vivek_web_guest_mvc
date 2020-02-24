package com.taj.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.taj.service.GuestService;
import com.taj.service.GuestServiceImpl;
@WebServlet("/check_out")
public class GuestCheckOutServlet extends HttpServlet{
		private static GuestService service;
		
		@Override
		public void init(ServletConfig config) throws ServletException {
			service = new GuestServiceImpl();
		}
		
		@Override
		public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			int id = 0;
			String result = null;
			RequestDispatcher rd = null;
			
			id = Integer.parseInt(req.getParameter("id"));
			
			try {
				result = service.checkout_guest_details(id);
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
			req.setAttribute("result", result);
			rd = req.getRequestDispatcher("view_guest.htm");
			rd.forward(req, res);
		}
		
		@Override
		public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			doPost(req, res);
		}
}
