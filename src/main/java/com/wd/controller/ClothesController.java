package com.wd.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wd.bean.Clothes;
import com.wd.service.ClothesService;

@Controller
public class ClothesController {	
	@Autowired
	private ClothesService clothesService;
	@RequestMapping("/show_do")
	public String show(Model model){
		List<Clothes> clothesList=clothesService.getAlllist();
		for(Clothes clothes:clothesList){
			System.out.println(clothes);
		}
		model.addAttribute("clothesList", clothesList);
		return "/show";
	}
	
	@RequestMapping("/add")
	public String add(){
		return "/add";
	}
	@RequestMapping("/add_do")
	public String add(HttpServletRequest request) throws UnsupportedEncodingException{
		
		request.setCharacterEncoding("utf-8");
		
		String id=request.getParameter("id");
		String param_name=request.getParameter("param_name");
		String param_value=request.getParameter("param_value");
		String remark=request.getParameter("remark");
		Clothes c=new Clothes();
		c.setId(id);
		c.setParam_name(param_name);
		c.setParam_value(param_value);
		c.setRemark(remark); 
		clothesService.add(c);
		return "redirect:show_do";
		
	}
	@RequestMapping("/delete_do")
	public String delete(HttpServletRequest request) throws UnsupportedEncodingException{
		
		request.setCharacterEncoding("utf-8");
		
		String id=request.getParameter("id");
		
		clothesService.delete(id);
		return "redirect:show_do";
	}
	@RequestMapping("/edit_do")
	public String edit(HttpServletRequest request,Model model) throws UnsupportedEncodingException{
		
		request.setCharacterEncoding("utf-8");
		
		String id=request.getParameter("id");
		
		Clothes clothes=clothesService.selectById(id);
		model.addAttribute("clothes", clothes);
		return "/update";
	}
	@RequestMapping("/update_do")
	public String uptate(HttpServletRequest request) throws UnsupportedEncodingException{
		
		request.setCharacterEncoding("utf-8");
		
		String id=request.getParameter("id");
		String param_name=request.getParameter("param_name");
		String param_value=request.getParameter("param_value");
		String remark=request.getParameter("remark");
		Clothes c=new Clothes();
		c.setId(id);
		c.setParam_name(param_name);
		c.setParam_value(param_value);
		c.setRemark(remark); 
		clothesService.update(c);
		return "redirect:show_do";
	}
}
