package spring.mvc.session10.controller;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import spring.mvc.session10.entity.Product;

@Controller
@RequestMapping("/product")
public class ProductController {
	private List<Product> products = new CopyOnWriteArrayList<>();
	
	{
		products.add(new Product("Java", 100, 500.0));
		products.add(new Product("Python", 80, 350.0));
		products.add(new Product("MySQL", 120, 750.0));
	}
	
	// 商品首頁(輸入商品, 查詢所有商品)
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("products", products);
		return "session10/product";
	}

	// 新增商品 - 1st 寫法
	/*
	@PostMapping("/")
	public String add(Product product, Model model) {
		products.add(product);
		model.addAttribute("product", product);
		return "session10/success";
	}
	*/
	
	// 新增商品 - 2nd 寫法 避免 1st 寫法讓使用者 refresh web-page 導致資料二次加入到資料庫中
	@PostMapping("/")
	public String add(Product product, RedirectAttributes attr) {
		products.add(product);
		// 將 product 資料傳給 /addOk 讓 success.jsp 來呈現 (防止網頁重新整理導致二次 submit)
		attr.addFlashAttribute("product", product);
		return "redirect:addOk";
	}

	// 新增商品 - 2nd 寫法
	// 成功
	@GetMapping(value = { "/addOk", "/updateOk" })
	public String success() {
		return "session10/success";
	}
	
	// 查詢單一商品 - 1st 寫法
	/*
	@GetMapping("/{index}")
	public String get(@PathVariable("index") int index, Model model) {
		Product product = products.get(index);
		model.addAttribute("product", product);
		model.addAttribute("index", index);
		return "session10/product_update";
	}
	*/
	// 查詢單一商品 - 2nd 寫法
	@GetMapping("/{index}")
	public String get(@PathVariable("index") int index, Model model, 
					 @RequestParam(name="delete", required = false, defaultValue = "false") boolean delete) {
		Product product = products.get(index);
		model.addAttribute("product", product);
		model.addAttribute("index", index);
		return delete ? "session10/product_delete" : "session10/product_update";
	}
	
	// 修改商品
	@PutMapping("/{index}")
	public String udpate(@PathVariable("index") int index, Product product, RedirectAttributes attr) {
		products.set(index, product);
		attr.addFlashAttribute("product", product);
		return "redirect:updateOk";
	}

	// 刪除商品 - 1st 寫法
	/*
	@RequestMapping(value = "/delete/{index}", method = RequestMethod.GET)
	public String delete(@PathVariable("index") int index, Model model) {
		// 刪除指定位置
		products.remove(index);
		return index(model); 
	}
	*/
	
	// 刪除商品 - 2nd 寫法
	@DeleteMapping("/{index}")
	public String delete(@PathVariable("index") int index) {
		products.remove(index);
		return "redirect:./";
	}
	
}
