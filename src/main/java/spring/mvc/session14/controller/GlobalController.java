package spring.mvc.session14.controller;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;

public class GlobalController {
	// 捕獲使用者輸入格式不正確的例外, 數學錯誤的例外
	// @ExceptionHandler({BindException.class, ArithmeticException.class,
	// RuntimeException.class})
	@ExceptionHandler({ RuntimeException.class })
	public String catchException(Exception ex, Model model, HttpServletRequest request) {
		String referer = request.getHeader("Referer");
		model.addAttribute("ex", "GlobalController 全局異常補獲: " + ex);
		model.addAttribute("referer", referer);
		return "session14/error";
	}
	
	@ModelAttribute(name = "global_map")
	public Map<String, Object> mydata(){
		Map<String, Object> map = new LinkedHashMap();
		map.put("公司名稱", "ABC 股份有限公司");
		map.put("聯絡人", "Jack");
		map.put("電話", "02-1234-5678");
		return map;
	}
	
}
