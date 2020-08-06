package com.springlec.semi_JDBC.command;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.springlec.semi_JDBC.dao.BDao;
import com.springlec.semi_JDBC.dto.BDto;

public class BGoogleMapCommand implements BCommand {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		String YEAR = request.getParameter("YEAR");
		String MONTH = request.getParameter("MONTH");
		String HOUR = request.getParameter("HOUR");
		String NEIGHBOURHOOD = request.getParameter("NEIGHBOURHOOD");
		String TYPE = request.getParameter("TYPE");
		String Weather = request.getParameter("Weather");
		
		BDao dao = new BDao();
		ArrayList<BDto> dtos = dao.google_map_input(YEAR, MONTH, HOUR, NEIGHBOURHOOD, TYPE, Weather);
//		BDto dtos = dao.google_map_input(YEAR);
		System.out.println(YEAR);
		model.addAttribute("google_map",dtos);
		
		

		
	}

}
