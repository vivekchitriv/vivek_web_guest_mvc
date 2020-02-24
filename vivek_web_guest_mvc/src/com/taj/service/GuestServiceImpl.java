package com.taj.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.taj.bo.GuestBO;
import com.taj.dao.GuestDAO;
import com.taj.dao.GuestDAOImpl;
import com.taj.dto.GuestDTO;

public class GuestServiceImpl implements GuestService{

	@Override
	public String insert_Guest_details(GuestDTO dto) throws SQLException {
		int count = 0;
		GuestDAO dao = null;
		GuestBO bo = null;
		
		dao = new GuestDAOImpl();
		bo = new GuestBO();
		
		bo.setGuestId(dto.getGuestId());
		bo.setName(dto.getName());
		bo.setAddress(dto.getAddress());
		bo.setIdType(dto.getIdType());
		bo.setIdNumber(dto.getIdNumber());
		bo.setMob(dto.getMob());
		
		count = dao.insert(bo);
		if(count>0)
			return "data added successfully";
		else
			return "data added failed";
	}

	@Override
	public List<GuestDTO> get_Guest_details() throws SQLException {
		GuestDAO dao = null;
		List<GuestBO> listBO = null;
		List<GuestDTO> listDTO = new ArrayList<GuestDTO>();
		dao = new GuestDAOImpl();
		listBO = dao.getGuest();
		listBO.forEach(bo->{
			GuestDTO dto = new GuestDTO();
			dto.setsNo(bo.getsNo());
			dto.setGuestId(bo.getGuestId());
			dto.setName(bo.getName());
			dto.setAddress(bo.getAddress());
			dto.setIdType(bo.getIdType());
			dto.setIdNumber(bo.getIdNumber());
			dto.setMob(bo.getMob());
			dto.setCheckIn(bo.getCheckIn());
			dto.setCheckOut(bo.getCheckOut());
			
			
			listDTO.add(dto);
			
		});
		return listDTO;
	}

	@Override
	public String checkout_guest_details(int id) throws SQLException {
		GuestDAO dao = null;
		int result = 0;
		dao = new GuestDAOImpl();
		result = dao.checkOut(id);
		if(result>0)
			return "Guest CheckOut Successfully";
		else
			return "Guest CheckOut Failed";
	}

	@Override
	public String editGuest_details(GuestDTO dto) throws SQLException {
		GuestBO bo = null;
		GuestDAO dao = null;
		int result= 0;
		dao = new GuestDAOImpl();
		bo = new GuestBO();
		bo.setName(dto.getName());
		bo.setAddress(dto.getAddress());
		bo.setIdType(dto.getIdType());
		bo.setIdNumber(dto.getIdNumber());
		bo.setMob(dto.getMob());
		bo.setsNo(dto.getsNo());
		result = dao.editGuest(bo);
		if(result>0)
			return "Details Update Successfully";
		else	
			return "Details updated Failed";
			
	}

	@Override
	public GuestDTO getGuestDetailsById(int pId) throws SQLException {
		GuestDAO dao = null;
		GuestBO bo = null;
		GuestDTO dto = null;
		
		dao = new GuestDAOImpl();
		dto = new GuestDTO();
		bo = dao.getDetailsById(pId);
		dto.setsNo(bo.getsNo());
		dto.setGuestId(bo.getGuestId());
		dto.setName(dto.getName());
		dto.setAddress(bo.getAddress());
		dto.setIdType(bo.getIdType());
		dto.setIdNumber(bo.getIdNumber());
		dto.setCheckIn(bo.getCheckIn());
		dto.setCheckOut(bo.getCheckOut());
		
		return dto;	
	}

}
