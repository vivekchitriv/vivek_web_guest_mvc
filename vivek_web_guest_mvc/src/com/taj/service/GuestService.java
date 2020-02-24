package com.taj.service;

import java.sql.SQLException;
import java.util.List;

import com.taj.dto.GuestDTO;

public interface GuestService {
	public String insert_Guest_details(GuestDTO dto) throws SQLException;
	public List<GuestDTO> get_Guest_details() throws SQLException; 
	public String checkout_guest_details(int id) throws SQLException;
	public String editGuest_details(GuestDTO dto) throws SQLException;
	public GuestDTO getGuestDetailsById(int pId) throws SQLException; 
}
