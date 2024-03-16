package com.springmvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.springmvc.beans.Student;
import com.springmvc.dao.StudentDao;


@Controller
public class MyController 
{
	@Autowired
	StudentDao dao;
	
    @GetMapping(value = "/")
	public String home()
	{
		return "index";
	}
    @PostMapping(value = "/insert")
    public String insert(@ModelAttribute Student student,Model model)
    {
    	int a=dao.insert(student);
    	model.addAttribute("htt", student);
		return "insert";
		
    }
}
