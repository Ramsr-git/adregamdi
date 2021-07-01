package com.adregamdi.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.adregamdi.api.WeatherAPI;
import com.adregamdi.dto.WeatherDTO;

@Controller
public class MainController {
	
	@Autowired
	private WeatherAPI weatherAPI;
	
	@RequestMapping(value="/", method= {RequestMethod.GET , RequestMethod.POST})
	public  String main(Model model) throws IOException, ParseException {
		
		WeatherDTO jeju = weatherAPI.getWeatherJeju();
		WeatherDTO seogwipo = weatherAPI.getWeatherSeogwipo();
		model.addAttribute("jeju", jeju);
		model.addAttribute("seogwipo", seogwipo);
		
		HttpServletRequest req = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
		String ip = req.getHeader("X-FORWARDED-FOR");
		if (ip == null) {
			ip = req.getRemoteAddr();
		}
		
		System.out.println("메인 : " + ip);
		
		return "main";
	}
}
