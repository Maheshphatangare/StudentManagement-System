 package com.mongo.controller;
import org.springframework.data.domain.Pageable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import com.mongo.entity.Stud;
import com.mongo.repo.StudRepo;

@Controller
@RequestMapping("/")
public class Mycontroller {
	@Autowired
	private StudRepo studrepo;
	//this fire home page
	@GetMapping("/home")
	String home() {
		return "home";
	}
	 //this fire studRegister
	@GetMapping("/studRegester")
	public String studR()
	{
		return "studRegester";
	}
	//this fire viewstud
//	@GetMapping("/viewstud/{page}")
//	public String Studview(@PathVariable("page") Integer page, Model m)
//	{ Pageable pg = PageRequest.of(page - 1, 5);;
//	 Page<Stud> c =this.studrepo.findAll(pg);
//	 m.addAttribute("currentpage",page);
//	 m.addAttribute("totalpage",c.getTotalPages());
//		return"redirect:/avl_stud";
//	}
	@GetMapping("/viewstud/{page}")
	public String Studview(@PathVariable("page") Integer page, Model model) {
	    Pageable pageable = PageRequest.of(page, 5); // Assuming 5 items per page
	    Page<Stud> studentsPage = studrepo.findAll(pageable);
	    model.addAttribute("students", studentsPage.getContent());
	    model.addAttribute("currentPage", page);
	    model.addAttribute("totalPages", studentsPage.getTotalPages());
	    return "viewstud"; // Make sure this corresponds to your view name
	}


	
	// main and imp send data to web page
	@GetMapping("/avl_stud")
	public ModelAndView getallstud()
	{
		List<Stud>list=studrepo.findAll();
		return new ModelAndView("viewstud","stud",list);
		//viewstud--> is page where we want to display
		//stud---> object of Stud class
		// list --> list of all student data
	}
	
	// all commment is use for rest Api
//	@PostMapping("/")
//	public ResponseEntity<?> addStudent(@RequestBody Stud stud)
//	{
//		Stud save=this.studrepo.save(stud);
//		return ResponseEntity.ok(save);
//	}
//
//	@GetMapping("/")
//	public ResponseEntity<?> getStudent()
//	{
//		
//		return ResponseEntity.ok(this.studrepo.findAll());
//	}
//	
	//this is used to save the data to data base
	@PostMapping("/save")
	public String addstud(@ModelAttribute Stud s) {
	
				studrepo.save(s);
		return"redirect:/avl_stud";
	}
	
	//delete data from database
		@RequestMapping("/deletestud/{id}")
		public String deleteStud(@PathVariable("id")int id) {
			studrepo.deleteById(id);
			return "redirect:/avl_stud";
		}
		
		//edit data from database
		@RequestMapping("/editstud/{id}")
		public String editBook(@PathVariable("id") int id,Model model) {
			Stud b=studrepo.findById(id).get();
			model.addAttribute("stud",b);
			return "studedit";
		}
}
