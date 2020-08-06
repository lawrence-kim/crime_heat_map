package com.springlec.semi_JDBC.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.springlec.semi_JDBC.dao.BDao;

public class BWriteCommand implements BCommand {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		String bName = request.getParameter("bName");
		String bTel = request.getParameter("bTel");
		String bAddress = request.getParameter("bAddress");
		String bEmail = request.getParameter("bEmail");
		String bRelation = request.getParameter("bRelation");
		
		BDao dao = new BDao();
		dao.write(bName,bTel,bAddress,bEmail,bRelation);
	}

}
