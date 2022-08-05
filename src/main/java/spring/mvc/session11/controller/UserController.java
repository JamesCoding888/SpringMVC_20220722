package spring.mvc.session11.controller;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import spring.mvc.session11.entity.User;

@Controller
@RequestMapping("/user")
public class UserController {
	
	private List<User> users = new CopyOnWriteArrayList<>();
	
	@GetMapping("/")
	public String index(Model model, @ModelAttribute User user) {
		user.setName("Java爪哇大屁屁");
		user.setAge(31);
		user.setBirth(new Date());
		
		model.addAttribute("_method", "POST");
		model.addAttribute("submitButtonName", "新增");
		model.addAttribute("users", users);
		//model.addAttribute("user", user); // 因方法中有宣告 @ModelAttribute User user 所以此行不用加入
		return "session11/user";
	}
}
