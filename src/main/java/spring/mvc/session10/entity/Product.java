package spring.mvc.session10.entity;

public class Product {
	private String productName; // 商品名稱
	private Integer quantity; // 商品數量
	private Double price; // 商品價格
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Product(String productName, Integer quantity, Double price) {
		super();
		this.productName = productName;
		this.quantity = quantity;
		this.price = price;
	}

	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Product [productName=" + productName + ", quantity=" + quantity + ", price=" + price + "]";
	}
}
