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
@WebServlet("/edit")
public class GuestEditServlet extends HttpServlet{
	private GuestService service;
	@Override
	public void init(ServletConfig config) throws ServletException {
		service = new GuestServiceImpl();
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		GuestDTO dto = null;
		String result = null;
		RequestDispatcher rd = null;
		
		dto = new GuestDTO();
		dto.setName(req.getParameter("gName"));
		dto.setAddress(req.getParameter("addrs"));
		dto.setIdType(req.getParameter("IdType"));
		dto.setIdNumber(req.getParameter("idNum"));
		dto.setMob(Long.parseLong(req.getParameter("mob")));
		dto.setsNo(Integer.parseInt(req.getParameter("gNo")));
		
		try {
			result  = service.editGuest_details(dto);
		} catch (SQLException e) {
			
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
