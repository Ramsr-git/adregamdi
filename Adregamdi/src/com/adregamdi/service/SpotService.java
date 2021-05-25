package com.adregamdi.service;


import java.util.ArrayList;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import com.adregamdi.dao.SpotDAO;
import com.adregamdi.dto.ReviewDTO;
import com.adregamdi.dto.SpotDTO;
import com.adregamdi.dto.UserDTO;

@Service
@PropertySource("/WEB-INF/properties/options.properties")
public class SpotService {

	@Autowired
	SpotDAO spotDAO;
	
	@Resource(name="loginUserDTO") 
	private UserDTO loginUserDTO;
	
	public void inputContentId(SpotDTO spotDTO) {
		spotDAO.inputContentId(spotDTO);
	}
	
	public void plusLikeCnt(String content_id) {
		spotDAO.plusLikeCnt(content_id);
	}
	
	public ArrayList<SpotDTO> getSpotInfo() {
		return spotDAO.getSpotInfo();
	}
	
	public ArrayList<String> getBestSpotInfo(int range_min, int range_max) {
		return spotDAO.getBestSpotInfo(range_min, range_max);
	}
	
	
	public ArrayList<ReviewDTO> getReviewInfo(String content_id) {
		
		System.out.println("review Service : contentId : "+content_id);
		
		return spotDAO.getReviewInfo(content_id);
	}
	
	public void inputReview(ReviewDTO writeReviewDTO) {
		
		writeReviewDTO.setUser_no(loginUserDTO.getUser_no());
		writeReviewDTO.setUser_name(loginUserDTO.getUser_name());
		
		spotDAO.inputReview(writeReviewDTO);
	}
	
	public void plusReviewCnt(String content_id) {
		spotDAO.plusReviewCnt(content_id);
	}
}
