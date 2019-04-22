import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class DBOperations {

	private String userName="root";
	private String password="01gs1905samet1996";
	private Connection con = null;
	private PreparedStatement preparedStatement = null;
	private Statement statement = null; 

	public DBOperations() {
		
		String url ="jdbc:mysql://localhost:3306/coffeeshop?useSSL=false";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Driver cannot be found");
			e.printStackTrace();
		}
		
		try {
			con = DriverManager.getConnection(url, userName, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Connection is failed");
			e.printStackTrace();
		}
	}

	public boolean loginmanager(String username, String password) {
		
		String myQuery = "Select UserName, Password from employee where UserName = ? and Password = ? and Authority=1";
		
		try {
			preparedStatement = con.prepareStatement(myQuery);
			preparedStatement.setString(1,username);
			preparedStatement.setString(2, password);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			return rs.next();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			return false;
		}
		
	}
	
public boolean loginstaff(String username, String password) {
		
		String myQuery = "Select UserName, Password, Authority from employee where UserName = ? and Password = ? and Authority=0";
		
		try {
			preparedStatement = con.prepareStatement(myQuery);
			preparedStatement.setString(1,username);
			preparedStatement.setString(2, password);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			return rs.next();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}

public ArrayList<Employee> listemployees() {
	
	ArrayList<Employee> employees = new ArrayList<Employee>();
	
	try {
		
		statement = con.createStatement();
        String myQuery =  "Select Emp_ID, Name, LastName, Wage,UserName, Password,Authority,Situation from employee where Situation = 1";
        
        ResultSet rs =  statement.executeQuery(myQuery);
        
        while(rs.next()) {
            int id = rs.getInt(1);
            String name = rs.getString(2);
            String lastname = rs.getString(3);
            double wage  = rs.getDouble(4);
            String username = rs.getString(5);
            String password = rs.getString(6);
            boolean authority = rs.getBoolean(7);
            boolean situation = rs.getBoolean(8);
            
            
            employees.add(new Employee(id, name, lastname, wage, username, password, authority, situation));
            
            
        }
        
        return employees;
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}
	
	
}

public void addEmployee(String name, String lastname, double wage, String username, String password, boolean authority, boolean situation) {
    
    String myQuery = "Insert Into employee (Name,LastName,Wage,UserName,Password,Authority,Situation) VALUES (?,?,?,?,?,?,?) ";  
     
        try {
			preparedStatement = con.prepareStatement(myQuery);
			//preparedStatement.setString(1,"null");
	        preparedStatement.setString(1, name);
	        preparedStatement.setString(2, lastname);
	        preparedStatement.setDouble(3, wage);
	        preparedStatement.setString(4, username);
	        preparedStatement.setString(5, password);
	        preparedStatement.setBoolean(6, authority);
	        preparedStatement.setBoolean(7, situation);
	        
	        preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    
}

public void deleteEmployee(int id) {
	
	String myQuery = "Update employee set situation = 0 where Emp_ID = ?";
	
		try {
			preparedStatement = con.prepareStatement(myQuery);
			preparedStatement.setInt(1,id);
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
}

public void updateEmployee(int id, double wage) {

	String myQuery = "UPDATE employee SET Wage = ? where Emp_ID = ?";
	
		try {
			preparedStatement = con.prepareStatement(myQuery);
			preparedStatement.setDouble(1, wage);
			preparedStatement.setInt(2,id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	
}

public void authorizeEmployee(int id) {
	
	String myQuery = "Update employee set Authority = 1 where Emp_ID = ?";
	
		try {
			preparedStatement = con.prepareStatement(myQuery);
			preparedStatement.setInt(1,id);
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
}

public ArrayList<Product> listproducts() {
	
		ArrayList<Product> products = new ArrayList<Product>();
	
		try {
			
			statement = con.createStatement();
			String myQuery =  "SELECT P_ID,Cat_Name,P_Name,P_Price,Stock from products p inner join category c on p.Cat_ID=c.Cat_ID"; 
	        ResultSet rs =  statement.executeQuery(myQuery);
	        
	        while(rs.next()) {
	            int p_id = rs.getInt(1);
	            String category = rs.getString(2);
	            String prdname = rs.getString(3);
	            double price  = rs.getDouble(4);
	            int stock = rs.getInt(5);
	            
	            products.add(new Product(p_id, category, prdname, price,stock));     
	            
	        }
	        
	        return products;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			return null;
		}
}

public void addProduct(int category, String prdname, double price, int stock) {
	
	String myQuery = "Insert Into products (Cat_ID,P_Name,P_Price,Stock) VALUES (?,?,?,?)";  
    
    try {
		preparedStatement = con.prepareStatement(myQuery);
		
        preparedStatement.setInt(1, category);
        preparedStatement.setString(2, prdname);
        preparedStatement.setDouble(3,price);
        preparedStatement.setInt(4, stock);
        
        
        preparedStatement.executeUpdate();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

public void deleteProduct(String prdname) {
	
	String myQuery = "CALL DeleteProduct(?)";
	
	try {
		preparedStatement = con.prepareStatement(myQuery);
		
		preparedStatement.setString(1, prdname);
		preparedStatement.executeQuery();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

public void updateProduct(String prdname, double price) {
	
String myQuery = "CALL UpdateProduct(?,?)";
	
	try {
		preparedStatement = con.prepareStatement(myQuery);
		
		preparedStatement.setString(1, prdname);
		preparedStatement.setDouble(2, price);
		preparedStatement.executeQuery();
		
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	
}


	
	
}
