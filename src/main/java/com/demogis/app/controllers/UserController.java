package com.demogis.app.controllers;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.demogis.app.models.entity.User;
import com.demogis.app.models.service.IUserService;

@Controller
@SessionAttributes("user") 
public class UserController {

	@Autowired
	private IUserService userService; 
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	private String Listar(Model model ) {
		System.out.println("  LISTAR "  );
		model.addAttribute("title", "list User");
		model.addAttribute("users", userService.listUsers());
		return "list"; 
	}
	
	@GetMapping(value="/form")
	public String create(Model model) {
		System.out.println("  CREATE "  );
		User user = new User();
		model.addAttribute("user", user);
		model.addAttribute("title", "User Form Create");
		return "form";
	}
	
	@RequestMapping(value = "/form/{id}")
	public String edit(@PathVariable(value="id") Long id ,Model model) {
		System.out.println("  edit "  );
		User user = null;
		if (id > 0) {
			user = userService.findUser(id);
		}else {
				return "redirect:list";
		}
		model.addAttribute("user", user);		
		model.addAttribute("title", "Edit User");
		
		return "form";
	}
	

	
	@RequestMapping(value = "/form", method = RequestMethod.POST)
	public String save(User user, SessionStatus status, HttpServletRequest request) {
		
		String ua = request.getHeader("user-agent").toLowerCase();
		if (ua.contains("windows") || ua.contains("mozilla") || ua.contains("firefox") ) {//....
			user.setIsMobile("N");
		}else {
			user.setIsMobile("Y");
		}



		userService.save(user);
		status.setComplete(); 
		return "redirect:list";
	}
	
	@GetMapping(value="/ver/{id}")
	public String ver(@PathVariable(value="id") Long id, Model model) {
		User user = userService.findUser(id);
		model.addAttribute("user",user);
		model.addAttribute("titulo","Detalle del User");
		return"ver";
	}

	
}




