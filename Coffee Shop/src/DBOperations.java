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
        String myQuery =  "Select * from List";
        
        ResultSet rs =  statement.executeQuery(myQuery);
        
        while(rs.next()) {
            int id = rs.getInt(1);
            String name = rs.getString(2);
            String lastname = rs.getString(3);
            double wage  = rs.getDouble(4);
            String username = rs.getString(5);
            String password = rs.getString(6);
            boolean authority = rs.getBoolean(7);
           
            
            
            employees.add(new Employee(id, name, lastname, wage, username, password, authority));
            
            
        }
        
        return employees;
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}
	
	
}

public void addEmployee(String name, String lastname, double wage, String username, String password, boolean authority) {
    
    String myQuery = "Insert Into employee (Name,LastName,Wage,UserName,Password,Authority) VALUES (?,?,?,?,?,?) ";  
     
        try {
			preparedStatement = con.prepareStatement(myQuery);
			//preparedStatement.setString(1,"null");
	        preparedStatement.setString(1, name);
	        preparedStatement.setString(2, lastname);
	        preparedStatement.setDouble(3, wage);
	        preparedStatement.setString(4, username);
	        preparedStatement.setString(5, password);
	        preparedStatement.setBoolean(6, authority);
	        
	        
	        preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    
}

public void deleteEmployee(int id) {
	
	String myQuery = "delete from employee where Emp_ID = ?";
	
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

public void nonAuthorizeEmployee(int id) {
	
	String myQuery = "Update employee set Authority = 0 where Emp_ID = ?";
	
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
			String myQuery =  "Select * from ListProduct"; 
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

public ArrayList<String> listSelectedCategory(String cat) {
	
	ArrayList<String> products = new ArrayList<String>();
	String myQuery = "Select P_Name from products p inner join category c on p.Cat_ID = c.Cat_Id where Cat_Name = ? ";
	try {
		preparedStatement = con.prepareStatement(myQuery);
		
		preparedStatement.setString(1, cat);
		
		ResultSet rs =  preparedStatement.executeQuery();
		
		while(rs.next()) {
           
            String category = rs.getString(1);
        
            products.add(category);     
            
        }
		
		return products;
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}	
	
	
}

public double getPrdc(String prname) {
	String myQuery = "SELECT DISTINCT getPRice(?) from products";
	
	try {
		preparedStatement=con.prepareStatement(myQuery);
		
		preparedStatement.setString(1, prname);
		
		ResultSet rs =preparedStatement.executeQuery();
		
		rs.next();
		
		double prc = rs.getDouble(1);
		
		return prc;
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return 0;
	}
}

public void ordersTable(int id, String prdname, double prdprice, int quantity) {
	
	String myQuery="Insert into orders (P_ID,P_Name,P_Price,Quantity) values(?,?,?,?)";
	
	try {
		preparedStatement = con.prepareStatement(myQuery);
		
		preparedStatement.setInt(1, id);
        preparedStatement.setString(2, prdname);
        preparedStatement.setDouble(3, prdprice);  
        preparedStatement.setInt(4, quantity);
        
        preparedStatement.executeUpdate();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

public int getId(String prdct) {
	
String myQuery = "Select P_ID from products where P_Name=?";
	
	try {
		preparedStatement=con.prepareStatement(myQuery);
		
		preparedStatement.setString(1, prdct);
		
		ResultSet rs =preparedStatement.executeQuery();
		
		rs.next();
		
		int prdctId = rs.getInt(1);
		
		return prdctId;
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return 0;
	}
}

public void updateStock(String prdname, int quantity) {
	
	String myQuery = "Call updateStock(?,?)";
	
	try {
		preparedStatement = con.prepareStatement(myQuery);
		
		preparedStatement.setString(1, prdname);
		preparedStatement.setInt(2, quantity);
		preparedStatement.executeQuery();
		
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
}

public int getStock(String prdct) {
String myQuery = "Select Stock from products where P_Name=?";
	
	try {
		preparedStatement=con.prepareStatement(myQuery);
		
		preparedStatement.setString(1, prdct);
		
		ResultSet rs =preparedStatement.executeQuery();
		
		rs.next();
		
		int stock = rs.getInt(1);
		
		return stock;
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return 0;
	}
}

public ArrayList<Employee> oldlistemployees() {
	
ArrayList<Employee> employees = new ArrayList<Employee>();
	
	try {
		
		statement = con.createStatement();
        String myQuery =  "Select * from oldemployees";
        
        ResultSet rs =  statement.executeQuery(myQuery);
        
        while(rs.next()) {
            int id = rs.getInt(1);
            String name = rs.getString(2);
            String lastname = rs.getString(3);
            double wage  = rs.getDouble(4);
            String username = rs.getString(5);
            String password = rs.getString(6);
            boolean authority = rs.getBoolean(7);
           
    
            employees.add(new Employee(id, name, lastname, wage, username, password, authority));
                  
        }
        
        return employees;
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}
	
}

public ArrayList<Orders> listorders() {
	
	ArrayList<Orders> history = new ArrayList<Orders>();
	
	try {
		
		statement = con.createStatement();
		String myQuery =  "Select * from ListOrders"; 
        ResultSet rs =  statement.executeQuery(myQuery);
        
        while(rs.next()) {
            int p_id = rs.getInt(1);
            String prdname = rs.getString(2);
            double price  = rs.getDouble(3);
            int quantity = rs.getInt(4);
            
            history.add(new Orders(p_id, prdname, price,quantity)); 
            
        }
        
        return history;
		
	} catch (SQLException e) {
		
		e.printStackTrace();
		return null;
	}
	
}

public void addStock(String prdname, int addedStock) {

String myQuery="Update products set Stock = (Stock + ?) where P_Name = ?";
	
	try {
		preparedStatement = con.prepareStatement(myQuery);
		
		preparedStatement.setInt(1, addedStock);
        preparedStatement.setString(2, prdname);
        
        preparedStatement.executeUpdate();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
}

