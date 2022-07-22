package spring.mvc.session08.controller;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import spring.mvc.session08.entity.User;

@Controller
@RequestMapping("/hello")
public class HelloController {

	/* 
	 * 1.
	 * 執行路徑: /mvc/hello/welcome
	 * /mvc 在 web.xml 中有定義
	 * /hello 找到 HelloController
	 * /welcome 執行 welcome() 方法
	*/
	@RequestMapping("/welcome")
	@ResponseBody
	public String welcome() {
		return "Welcome SpringMVC !";
	}
	/*
	 * 2. 
	 * ?後面帶參數 @RequestParam
	 * 執行路徑： /mvc/hello/sayhi?name=John&age=18
	 */
	@RequestMapping(value = "sayhi")
	@ResponseBody
	public String sayHi(@RequestParam(value = "name", required = false) String name,
										 @RequestParam(value = "age", defaultValue = "10") Integer age) {
		return String.format("Hi %s %d",name, age);
	}
	
	/*
	 * 3. Lab 練習
	 * 執行路徑: /mvc/hello/bmi?h=170&w=60
	 * 執行結果: bmi = 20.76
	 */
	@RequestMapping(value = "/bmi")
	@ResponseBody
	public String getBmiValue(@RequestParam(value = "weight") Double weight,
										 @RequestParam(value = "height") Double height) {

		Double bmi = weight / Math.pow(height/100, 2);
		return String.format("BMI: %.2f", bmi);
		//BMI = 體重(公斤) / 身高2(公尺2)
	}
	
	/*
	 * 4. 同名多參數資料
	 * 執行路徑: /mvc/hello/age?age=18&age=19&age=20
	 * 計算出; 資料筆數, 總和, 平均, 最大值, 最小值
	 * 
	 */
	@RequestMapping(value = "/age")
	@ResponseBody
	public String age(@RequestParam("age") List<Integer> ageList){
		// Int 的 統計物件
		IntSummaryStatistics stat = ageList.stream()
																			.mapToInt(Integer::intValue)
																			.summaryStatistics();
		return String.format("%s", stat.toString());
	}
	
	/*
	 * Map 參數(常用於 form 表單)
	 * 執行路徑: /mvc/hello/person?name=Tomcat&score=100&age=18&pass=true
	 */
	@RequestMapping(value = "/person")
	@ResponseBody
	public String getPerson(@RequestParam Map<String, String> person) {
		return person.toString();
	}
	
	/*
	 * 6. pojo(entity) 參數自動配置
	 * 執行路徑: /mvc/hello/user?name=Tomcat&score=95.5&age=18&pass=true
	 */
	@RequestMapping(value = "/user")
	@ResponseBody
	public String getUser(User user) {
		return user.toString();
	}
	
	
}
