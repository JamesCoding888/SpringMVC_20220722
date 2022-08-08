package spring.mvc.session11.controller;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.mvc.session11.entity.User;

@Controller
@RequestMapping("/user")
public class UserController {
	
	private List<User> users = new CopyOnWriteArrayList<>();
	
	{
		users.add(new User("A01",  18, new Date(), "大學", "男", new String[] {"看電影", "飛盤"}, "aaa"));
		users.add(new User("A02",  19, new Date(), "國中", "女", new String[] {"看書", "飛幾"}, "bbb"));
		users.add(new User("A03",  20, new Date(), "碩士", "男", new String[] {"看球賽", "飛舞"}, "ccc"));
	}
	@GetMapping("/")
	public String index(Model model, @ModelAttribute User user) {
		/**測試用
		user.setName("Java爪哇大屁屁");
		user.setAge(31);
		user.setBirth(new Date());
		 */
		
		model.addAttribute("_method", "POST");
		model.addAttribute("submitButtonName", "新增");
		model.addAttribute("users", users);
		//model.addAttribute("user", user); // 因方法中有宣告 @ModelAttribute User user 所以此行不用加入
		return "session11/user";
	}
	
	@PostMapping("/")
	public String add(@ModelAttribute User user) {
		users.add(user);
		return "redirect:./";
	}
	
	
	@GetMapping("/{index}")
	public String get(Model model, @PathVariable int index) {
		User user = users.get(index);
		model.addAttribute("_method", "PUT");
		model.addAttribute("index", index);
		model.addAttribute("submitButtonName", "修改");
		model.addAttribute("users", users);
		model.addAttribute("user", user);
		return "session11/user";
		
	}
	@PutMapping("/{index}")
	public String update(@ModelAttribute User user, @PathVariable("index") int index) {
		users.set(index, user);
		return "redirect:./";
	}

	@DeleteMapping("/{index}")
	public String delete(@PathVariable("index") int index) {
		users.remove(index);
		return "redirect:./";
	}
	
	
	
	
	
	
}