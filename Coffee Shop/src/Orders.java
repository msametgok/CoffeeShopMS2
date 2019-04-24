
public class Orders {
	
	private int prdID;
	private String prdname;
	private double prdprice;
	private int quantity;
	
	Orders(int prdID, String prdname, double prdprice, int quantity){
		
		this.prdID=prdID;
		this.prdname=prdname;
		this.prdprice=prdprice;
		this.quantity=quantity;
	}

	public String getPrdname() {
		return prdname;
	}

	public double getPrdprice() {
		return prdprice;
	}

	public int getPrdID() {
		return prdID;
	}

	public int getQuantity() {
		return quantity;
	}


	
	
}
