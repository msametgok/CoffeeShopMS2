public class Manager extends Employee{

	Manager(int id, String name, String lastName, double wage, String username,
			String password, boolean authority, boolean situation) {
		
     	super(id, name, lastName, wage, username, password, authority, situation);	
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
		return true;
	}

	@Override
	public void setAuthority(boolean authority) {
		// TODO Auto-generated method stub
		super.setAuthority(authority);
	}

	
 
	
}