package spring.mvc.session12.controller;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.mvc.session12.entity.Person;

@Controller
@RequestMapping("/person")
class PersonContorller {
	private List<Person> people = new CopyOnWriteArrayList<Person>();
	
	@GetMapping("/")
	public String index(Model model, @ModelAttribute Person person ) {
		model.addAttribute("people", people);
		return "session12/person";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
