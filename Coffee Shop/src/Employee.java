public class Employee {

	private int id;
	private String name;
	private String lastName;
	private double wage;
	private boolean authority;
	
	Employee(int id, String name, String lastName, double wage, boolean authority){
	
		this.id=id;
		this.name=name;
		this.lastName=lastName;
		this.wage=wage;
		this.authority=authority;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public double getWage() {
		return wage;
	}

	public void setWage(double wage) {
		this.wage = wage;
	}

	public boolean isAuthority() {
		return authority;
	}

	public void setAuthority(boolean authority) {
		this.authority = authority;
	}
	
}
