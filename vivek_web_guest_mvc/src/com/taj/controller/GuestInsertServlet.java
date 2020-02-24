package com.taj.controller;

import java.io.IOException;

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
@WebServlet("/add")
public class GuestInsertServlet extends HttpServlet {
	private static GuestService service;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		service = new GuestServiceImpl();
	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String result = null;
		RequestDispatcher rd = null;
		GuestDTO dto = null;
		
		dto = new GuestDTO();
		
		dto.setGuestId(req.getParameter("gId"));
		dto.setName(req.getParameter("gName"));
		dto.setAddress(req.getParameter("addrs"));
		dto.setIdType(req.getParameter("IdType"));
		dto.setIdNumber(req.getParameter("idNum"));
		dto.setMob(Long.parseLong(req.getParameter("mob")));
		
		
		try {
			result = service.insert_Guest_details(dto);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		req.setAttribute("result",result);
		
		rd = req.getRequestDispatcher("view_guest.htm");
		rd.forward(req, res);
	}
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
		
	}
	
}
