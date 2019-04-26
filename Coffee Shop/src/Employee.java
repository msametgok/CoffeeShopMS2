public class Employee {

	private int id;
	private String name;
	private String lastName;
	private double wage;
	private String username;
	private String password;
	private boolean authority;
	//private boolean situation;
	
	Employee(int id, String name, String lastName, double wage, String username,
				String password, boolean authority){
	
		this.id=id;
		this.name=name;
		this.lastName=lastName;
		this.wage=wage;
		this.username=username;
		this.password=password;
		this.authority=authority;
		//this.situation=situation;
	}

	public int getId() {
		return id;
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

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
