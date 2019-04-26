
public class Staff extends Employee{

	Staff(int id, String name, String lastName, double wage, String username,
			String password, boolean authority) {
		
		super(id, name, lastName, wage, username, password, authority);
	}

	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return super.getId();
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return super.getName();
	}

	@Override
	public String getLastName() {
		// TODO Auto-generated method stub
		return super.getLastName();
	}

	@Override
	public double getWage() {
		// TODO Auto-generated method stub
		return super.getWage();
	}

	@Override
	public void setWage(double wage) {
		// TODO Auto-generated method stub
		super.setWage(wage);
	}

	@Override
	public boolean isAuthority() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setAuthority(boolean authority) {
		// TODO Auto-generated method stub
		super.setAuthority(authority);
	}
	
	

}