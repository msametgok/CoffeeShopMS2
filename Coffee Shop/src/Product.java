public class Product {

	private int productID;
	private String category;
	private String prdName;
	private double price;
	private int stock;
	
	Product(int productID, String category, String prdName, double price, int stock){
		
		this.productID=productID;
		this.category=category;
		this.prdName=prdName;
		this.price=price;
		this.stock=stock;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getProductID() {
		return productID;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getPrdName() {
		return prdName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
}
