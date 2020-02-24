package com.taj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.taj.bo.GuestBO;
import com.taj.connection.ConnectionManager;

public class GuestDAOImpl implements GuestDAO {
	private static Connection con;
	private static final String INSERT_GUEST = "INSERT INTO GUEST_DETAILS(SNO,GUESTID,NAME,ADDRESS,IDTYPE,IDNUMBER,MOB,CHECKIN_DT) VALUES (SEQ_GUEST_DETAILS.NEXTVAL,?,?,?,?,?,?,SYSDATE)";
	private static final String GET_GUEST = "SELECT SNO,GUESTID,NAME,ADDRESS,IDTYPE,IDNUMBER,MOB,CHECKIN_DT,CHECKOUT_DT,ISALIVE FROM GUEST_DETAILS";
	private static final String CHECKOUT_GUEST = " UPDATE GUEST_DETAILS SET CHECKOUT_DT = SYSDATE,ISALIVE = 'N' WHERE SNO =?";
	private static final String EDIT_GUEST = "UPDATE GUEST_DETAILS SET NAME =? ,ADDRESS =?, IDTYPE=?, IDNUMBER=?, MOB=? WHERE SNO =? ";
	private static final String GET_GUEST_DETAILS_BY_ID = "SELECT SNO,GUESTID,NAME,ADDRESS,IDTYPE,IDNUMBER,MOB,CHECKIN_DT,CHECKOUT_DT,ISALIVE FROM GUEST_DETAILS WHERE SNO = ?";
	
	
	@Override
	public int insert(GuestBO bo) throws SQLException {
		
		int count = 0;
		con = ConnectionManager.getConnection();
		PreparedStatement ps =null;
		ps = con.prepareStatement(INSERT_GUEST);
		ps.setString(1, bo.getGuestId());
		ps.setString(2, bo.getName());
		ps.setString(3, bo.getAddress());
		ps.setString(4, bo.getIdType());
		ps.setString(5, bo.getIdNumber());
		ps.setLong(6, bo.getMob());
		count = ps.executeUpdate();
		return count;
	}

	@Override
	public List<GuestBO> getGuest() throws SQLException {
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(GET_GUEST);
		rs = ps.executeQuery();
		List<GuestBO> listBO = new ArrayList<GuestBO>();
		while(rs.next())
		{
			GuestBO bo = new GuestBO();
			bo.setsNo(rs.getInt(1));
			bo.setGuestId(rs.getString(2));
			bo.setName(rs.getString(3));
			bo.setAddress(rs.getString(4));
			bo.setIdType(rs.getString(5));
			bo.setIdNumber(rs.getString(6));
			bo.setMob(rs.getLong(7));
			bo.setCheckIn(rs.getTimestamp(8));
			bo.setCheckOut(rs.getTimestamp(9));
			
			listBO.add(bo);
		}
		return listBO;
	}

	@Override
	public int checkOut(int id) throws SQLException {
		int result = 0;
		con = ConnectionManager.getConnection();
		PreparedStatement ps = null;
		ps = con.prepareStatement(CHECKOUT_GUEST);
		ps.setInt(1, id);
		result = ps.executeUpdate();
		return result;
		
	}

	@Override
	public int editGuest(GuestBO bo) throws SQLException {
		
		con = ConnectionManager.getConnection();
		PreparedStatement ps = null;
		int result = 0;
		ps = con.prepareStatement(EDIT_GUEST);
		
		ps.setString(1, bo.getName());
		ps.setString(2, bo.getAddress());
		ps.setString(3, bo.getIdType());
		ps.setString(4, bo.getIdNumber());
		ps.setLong(5, bo.getMob());
		ps.setInt(6, bo.getsNo());
		result = ps.executeUpdate();
		return result;
	}

	@Override
	public GuestBO getDetailsById(int pId) throws SQLException {
		con = ConnectionManager.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		GuestBO bo = null;
		ps = con.prepareStatement(GET_GUEST_DETAILS_BY_ID);
		ps.setInt(1, pId);
		rs = ps.executeQuery();
		if(rs.next())
		{
			bo = new GuestBO();
			bo.setsNo(rs.getInt(1));
			bo.setGuestId(rs.getString(2));
			bo.setName(rs.getString(3));
			bo.setAddress(rs.getString(4));
			bo.setIdType(rs.getString(5));
			bo.setIdNumber(rs.getString(6));
			bo.setMob(rs.getLong(7));
			bo.setCheckIn(rs.getTimestamp(8));
			bo.setCheckOut(rs.getTimestamp(9));
			
		}
		return bo;
	
	}
	}
