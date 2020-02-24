package com.taj.dao;

import java.sql.SQLException;
import java.util.List;

import com.taj.bo.GuestBO;

public interface GuestDAO {
	public int insert(GuestBO bo) throws SQLException;
	public List<GuestBO> getGuest() throws SQLException;
	public int checkOut(int id) throws SQLException;
	public int editGuest(GuestBO bo) throws SQLException;
	public GuestBO getDetailsById(int pId) throws SQLException;
}
