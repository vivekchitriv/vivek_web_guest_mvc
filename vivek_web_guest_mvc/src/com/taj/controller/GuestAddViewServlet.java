package com.taj.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/add_guest")
public class GuestAddViewServlet extends HttpServlet {
		@Override
		public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
				RequestDispatcher rd = null;
				rd = req.getRequestDispatcher("add_guest.jsp");
				rd.forward(req, res);
			}
		@Override
		public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
			doPost(req, res);
		}

	
}
