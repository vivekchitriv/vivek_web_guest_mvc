package com.taj.controller;

import java.io.IOException;
import java.sql.SQLException;

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
@WebServlet("/edit_guest")
public class GuestSearchServlet extends HttpServlet{
	private GuestService service;
	@Override
	public void init(ServletConfig config) throws ServletException {
		service = new GuestServiceImpl();
	}
	
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int pId = 0;
		GuestDTO dto =null;
		RequestDispatcher rd = null;
		pId = Integer.parseInt(req.getParameter("id"));
		try {
			dto = service.getGuestDetailsById(pId);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		req.setAttribute("dto", dto);
		rd = req.getRequestDispatcher("edit_guest.jsp");
		rd.forward(req, res);
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}
}
