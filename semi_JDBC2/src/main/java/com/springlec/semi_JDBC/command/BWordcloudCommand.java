package com.springlec.semi_JDBC.command;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.springlec.semi_JDBC.dao.BDao;
import com.springlec.semi_JDBC.dto.BDto;

public class BWordcloudCommand implements BCommand {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		// String Weather = request.getParameter("Weather");
		
		BDao dao = new BDao();
		ArrayList<BDto> dtos = dao.google_map_weather();
//		BDto dtos = dao.google_map_input(YEAR);
		System.out.println(dtos);
		model.addAttribute("google_map_weather",dtos);	
	}

}
