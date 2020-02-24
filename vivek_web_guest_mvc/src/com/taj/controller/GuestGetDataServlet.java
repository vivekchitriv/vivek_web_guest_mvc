package com.taj.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.taj.dto.GuestDTO;
import com.taj.service.GuestService;
import com.taj.service.GuestServiceImpl;
@WebServlet("/view_guest.htm")
public class GuestGetDataServlet extends HttpServlet{
		private static GuestService service;
		
		@Override
		public void init(ServletConfig config) throws ServletException {
				service = new GuestServiceImpl();
		}
		@Override
		public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			List<GuestDTO> listDTO = null;
			
			try {
				listDTO = service.get_Guest_details();
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			req.setAttribute("guest", listDTO);
			RequestDispatcher rd = req.getRequestDispatcher("view_guest.jsp");
			rd.forward(req, res);
			
		}
		
		@Override
		public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
					
			doPost(req, res);
		}
}
