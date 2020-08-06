package com.springlec.semi_JDBC.command;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.springlec.semi_JDBC.dao.BDao;
import com.springlec.semi_JDBC.dto.BDto;

public class BListCommand implements BCommand {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		BDao dao = new BDao();
		ArrayList<BDto> dtos = dao.list();
		model.addAttribute("list",dtos);
//		이를 모델에  저장한다

	}

}
