package com.springlec.semi_JDBC.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springlec.semi_JDBC.command.BCommand;
import com.springlec.semi_JDBC.command.BContentCommand;
import com.springlec.semi_JDBC.command.BDeleteCommand;
import com.springlec.semi_JDBC.command.BGoogleMapCommand;

import com.springlec.semi_JDBC.command.BListCommand;
import com.springlec.semi_JDBC.command.BModifyCommand;
import com.springlec.semi_JDBC.command.BWeatherAutoCommand;
import com.springlec.semi_JDBC.command.BWriteCommand;
import com.springlec.semi_JDBC.util.Constant;

@Controller
public class BController {

	BCommand command = null;
	BCommand command2 = null;
	
	private JdbcTemplate template;
	
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
		Constant.template = this.template;
	}
	
	
	@RequestMapping("/list")
	public String list(Model model) {
		System.out.println("list()");
		command = new BListCommand();
		command.execute(model);
		return "list";
//	일 시키기
//	jsp로 넘겨주기
		
	}
	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model) {
		System.out.println("write()");
		model.addAttribute("request",request);
		command = new BWriteCommand();
		command.execute(model);
		return "redirect:list";
	}
	
	
	@RequestMapping("/write_view")
	public String write_view(Model model) {
		System.out.println("write_view()");
		return "write_view";
	}
	
	@RequestMapping("/content_view")
	public String content_view(HttpServletRequest request, Model model) {
		System.out.println("content_view()");
		model.addAttribute("request",request);
		command = new BContentCommand();
		command.execute(model);
		return "content_view";
	}	
   @RequestMapping("/modify")
   public String modify(HttpServletRequest request, Model model) {
      System.out.println("modify()");
      model.addAttribute("request",request);
      command = new BModifyCommand();
      command.execute(model);
      return "redirect:list";
   }
   @RequestMapping("/delete")
   public String delete(HttpServletRequest request, Model model) {
	   System.out.println("delete");
	   model.addAttribute("request",request);
	   command = new BDeleteCommand();
	   command.execute(model);
	   return "redirect:list";	   
   }
	@RequestMapping("/visual")
	public String visual(Model model) {
		System.out.println("visual()");
		return "visual";
	}
	
	@RequestMapping("/wordcloud")
	public String wordcloudShow(Model model) {
		System.out.println("wordcloud()");
		return "wordcloud";
	}	
	
	
	
	 @RequestMapping("/map")
	 public String map() {
	 return "map";
	 }  
	 
	 
	 
	 
//	 @RequestMapping("/google_map")
//	 public String google_map() {
//	 return "google_map";
//	 }  
	 @RequestMapping("/google_map")
	 public String google_map(HttpServletRequest request, Model model) {
		 model.addAttribute("request",request);
		 command = new BWeatherAutoCommand();

		 command.execute(model);
		 return "google_map";
	 }  
	 
	 @RequestMapping("/google_map_input")
	 public String google_map_input(HttpServletRequest request, Model model) {	  
		 
	 System.out.println("google_map_input()");
	 model.addAttribute("request",request);
	 command = new BGoogleMapCommand();
	 command2 = new BWeatherAutoCommand();
	 
	 command.execute(model);
	 command2.execute(model);

	 return "google_map";
	 }  
	 
	 
	@RequestMapping("/google_map_write")
	public String google_map_write(Model model) {
		System.out.println("google_map_write()");
		return "google_map_write";
	} 
	 
	 
	 
	 
	 
	 @RequestMapping("/latlong")
	 public String latolong() {
	 return "latlong";
	 }  
	 
	 
	 
   
}
