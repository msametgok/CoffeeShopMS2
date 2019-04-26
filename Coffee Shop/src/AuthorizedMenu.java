import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import java.awt.Rectangle;
import java.awt.ComponentOrientation;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JSeparator;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JScrollPane;
import javax.swing.JPasswordField;
import javax.swing.JToggleButton;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class AuthorizedMenu extends JFrame {

	DBOperations db = new DBOperations();
	DefaultTableModel model;
	
	private JPanel contentPane;
	private JTable empTable;
	private JTable prdTable;
	private JPanel pnlProduct;
	private JPanel pnlEmployee;
	private JPanel pnlAddEmployee;
	private JPanel pnlAddProduct;
	private JPanel pnlEmpty;
	private JTextField txtSearch;
	private JTextField txtLastname;
	private JTextField txtWage;
	private JTextField txtUsername;
	private JTextField txtName;
	private JPasswordField txtPassword;
	private JTextField txtSearchPrd;
	private JTextField txtPname;
	private JTextField txtPrice;
	private JComboBox categoryBox;
	private JTextField txtStock;
	private JPanel pnlSalesHistory;
	private JTable tblHistory;
	double total = 0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AuthorizedMenu frame = new AuthorizedMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings("unchecked")
	public AuthorizedMenu() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 833, 479);
		contentPane = new JPanel();
		contentPane.setBorder(new MatteBorder(4, 4, 4, 4, (Color) new Color(75, 0, 130)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(75, 0, 130)));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 833, 479);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 217, 479);
		panel_1.setForeground(new Color(255, 255, 255));
		panel_1.setBorder(null);
		panel_1.setBackground(new Color(75, 0, 130));
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblOperations = new JLabel("Operations");
		lblOperations.setHorizontalAlignment(SwingConstants.CENTER);
		lblOperations.setForeground(new Color(255, 255, 255));
		lblOperations.setBackground(new Color(255, 255, 255));
		lblOperations.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblOperations.setBounds(0, 29, 217, 26);
		panel_1.add(lblOperations);
		
		JButton btnListEmployee = new JButton("List Employees");
		btnListEmployee.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnListEmployee.setBackground(new Color(255, 255, 255));
				btnListEmployee.setForeground(new Color(75, 0, 130));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnListEmployee.setBackground(new Color(75, 0, 130));
				btnListEmployee.setForeground(new Color(255, 255, 255));
			}
		});
		btnListEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnlEmpty.setVisible(false);
				pnlProduct.setVisible(false);
				pnlAddEmployee.setVisible(false);
				pnlAddProduct.setVisible(false);
				pnlSalesHistory.setVisible(false);
				pnlEmployee.setVisible(true);
				
				model = (DefaultTableModel) empTable.getModel();
				model.setRowCount(0);
				
				
				ArrayList<Employee> employees = new ArrayList<Employee>();
				
				employees = db.listemployees();
				
				if (employees != null ) {
		            
		            for (Employee emp : employees) {
		            	
		            	String aut;
		            	
		            	if(emp.isAuthority()==true) {

		            			aut = "Manager";
		            	}
		            	else {
		            			aut= "Staff"; 
		            	}
		            	
		                Object[] addEmployee = {aut,emp.getId(),emp.getName(),emp.getLastName(),emp.getWage()};
		                
		                model.addRow(addEmployee);
		               
		            }
		            
		        }
			}
		});
		btnListEmployee.setBorder(null);
		btnListEmployee.setBackground(new Color(75, 0, 130));
		btnListEmployee.setForeground(new Color(255, 255, 255));
		btnListEmployee.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnListEmployee.setBounds(0, 101, 217, 36);
		panel_1.add(btnListEmployee);
		
		JButton btnListProducts = new JButton("List Products");
		btnListProducts.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnListProducts.setBackground(new Color(255, 255, 255));
				btnListProducts.setForeground(new Color(75, 0, 130));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnListProducts.setBackground(new Color(75, 0, 130));
				btnListProducts.setForeground(new Color(255, 255, 255));
			}
		});
		btnListProducts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnlEmpty.setVisible(false);
				pnlEmployee.setVisible(false);
				pnlAddEmployee.setVisible(false);
				pnlAddProduct.setVisible(false);
				pnlSalesHistory.setVisible(false);
				pnlProduct.setVisible(true);
				
				
				model = (DefaultTableModel) prdTable.getModel();
				model.setRowCount(0);
				
				
				ArrayList<Product> products = new ArrayList<Product>();
				
				products = db.listproducts();
			
				if (products != null ) {
		            
		            for (Product prd : products) {
		                Object[] addProduct = {prd.getProductID(),prd.getCategory(),prd.getPrdName(),prd.getPrice(),prd.getStock()};
		                
		                model.addRow(addProduct);
		               
		            }
		            
		        }
			}
		});
		btnListProducts.setBorder(null);
		btnListProducts.setForeground(Color.WHITE);
		btnListProducts.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnListProducts.setBackground(new Color(75, 0, 130));
		btnListProducts.setBounds(0, 195, 217, 36);
		panel_1.add(btnListProducts);
		
		JButton btnSwitch = new JButton("Switch to Sale");
		btnSwitch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Sale salescreen = new Sale();
				salescreen.setVisible(true);
			}
		});
		btnSwitch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnSwitch.setBackground(new Color(255,255,255));
				btnSwitch.setForeground(new Color(75,0,130));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnSwitch.setBackground(new Color(75,0,130));
				btnSwitch.setForeground(new Color(255,255,255));
			}
		});
		btnSwitch.setForeground(Color.WHITE);
		btnSwitch.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnSwitch.setBorder(null);
		btnSwitch.setBackground(new Color(75, 0, 130));
		btnSwitch.setBounds(0, 432, 217, 36);
		panel_1.add(btnSwitch);
		
		JButton btnAddEmployee = new JButton("Add New Employee");
		btnAddEmployee.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAddEmployee.setBackground(new Color(255, 255, 255));
				btnAddEmployee.setForeground(new Color(75, 0, 130));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnAddEmployee.setBackground(new Color(75, 0, 130));
				btnAddEmployee.setForeground(new Color(255, 255, 255));
			}
		});
		btnAddEmployee.setBounds(0, 148, 217, 36);
		panel_1.add(btnAddEmployee);
		btnAddEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnlEmpty.setVisible(false);
				pnlEmployee.setVisible(false);
				pnlAddProduct.setVisible(false);
				pnlProduct.setVisible(false);
				pnlSalesHistory.setVisible(false);
				pnlAddEmployee.setVisible(true);
			}
		});
		btnAddEmployee.setForeground(Color.WHITE);
		btnAddEmployee.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnAddEmployee.setBorder(null);
		btnAddEmployee.setBackground(new Color(75, 0, 130));
		
		JButton btnAddProduct = new JButton("Add New Product");
		btnAddProduct.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAddProduct.setBackground(new Color(255, 255, 255));
				btnAddProduct.setForeground(new Color(75, 0, 130));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnAddProduct.setBackground(new Color(75, 0, 130));
				btnAddProduct.setForeground(new Color(255, 255, 255));
			}
		});
		btnAddProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnlEmpty.setVisible(false);
				pnlEmployee.setVisible(false);
				pnlProduct.setVisible(false);
				pnlAddEmployee.setVisible(false);
				pnlSalesHistory.setVisible(false);
				pnlAddProduct.setVisible(true);
			}
		});
		btnAddProduct.setBounds(0, 242, 217, 36);
		panel_1.add(btnAddProduct);
		btnAddProduct.setForeground(Color.WHITE);
		btnAddProduct.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnAddProduct.setBorder(null);
		btnAddProduct.setBackground(new Color(75, 0, 130));
		
		JButton btnHistory = new JButton("Sales History");
		btnHistory.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				
				btnHistory.setBackground(new Color(255, 255, 255));
				btnHistory.setForeground(new Color(75, 0, 130));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				
				btnHistory.setBackground(new Color(75, 0, 130));
				btnHistory.setForeground(new Color(255, 255, 255));
			}
		});
		btnHistory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				pnlEmpty.setVisible(false);
				pnlEmployee.setVisible(false);
				pnlProduct.setVisible(false);
				pnlAddEmployee.setVisible(false);
				pnlAddProduct.setVisible(false);
				pnlSalesHistory.setVisible(true);
				
				model = (DefaultTableModel) tblHistory.getModel();
				model.setRowCount(0);
				
				
				ArrayList<Orders> orderHistory = new ArrayList<Orders>();
				
				orderHistory = db.listorders();
			
				if (orderHistory != null ) {
		            
		            for (Orders ord : orderHistory) {
		            	
		                Object[] addOrder = {ord.getPrdID(),ord.getPrdname(),ord.getPrdprice(),ord.getQuantity()};
		                
		                model.addRow(addOrder);
		               
		            }
		            
		        }
			}
			
			
		});
		btnHistory.setForeground(Color.WHITE);
		btnHistory.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnHistory.setBorder(null);
		btnHistory.setBackground(new Color(75, 0, 130));
		btnHistory.setBounds(0, 289, 217, 36);
		panel_1.add(btnHistory);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new MatteBorder(4, 0, 4, 4, (Color) new Color(0, 0, 0)));
		panel_2.setBounds(217, 0, 616, 479);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBorder(new MatteBorder(4, 0, 4, 4, (Color) new Color(75, 0, 130)));
		layeredPane.setBounds(0, 0, 616, 479);
		panel_2.add(layeredPane);
		
		pnlAddEmployee = new JPanel();
		pnlAddEmployee.setBorder(new MatteBorder(4, 0, 4, 4, (Color) new Color(75, 0, 130)));
		pnlAddEmployee.setVisible(false);
		
		pnlAddProduct = new JPanel();
		pnlAddProduct.setBorder(new MatteBorder(4, 0, 4, 4, (Color) new Color(75, 0, 130)));
		pnlAddProduct.setVisible(false);
		
		pnlEmployee = new JPanel();
		pnlEmployee.setVisible(false);
		
		pnlProduct = new JPanel();
		pnlProduct.setBackground(new Color(255, 255, 255));
		pnlProduct.setBorder(new MatteBorder(4, 0, 4, 4, (Color) new Color(75, 0, 130)));
		pnlProduct.setVisible(false);
		
		pnlSalesHistory = new JPanel();
		pnlSalesHistory.setVisible(false);
		pnlSalesHistory.setBackground(new Color(255, 255, 255));
		pnlSalesHistory.setBorder(new MatteBorder(4, 0, 4, 4, (Color) new Color(75, 0, 130)));
		pnlSalesHistory.setBounds(0, 0, 616, 479);
		layeredPane.add(pnlSalesHistory);
		pnlSalesHistory.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		scrollPane_2.setBorder(new MatteBorder(4, 0, 4, 0, (Color) new Color(75, 0, 130)));
		scrollPane_2.setBounds(0, 102, 612, 222);
		pnlSalesHistory.add(scrollPane_2);
		
		tblHistory = new JTable();
		tblHistory.setForeground(new Color(105, 105, 105));
		tblHistory.setFont(new Font("Segoe UI", Font.BOLD, 16));
		tblHistory.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Product Id", "Product Name", "Price", "Quantity"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tblHistory.getColumnModel().getColumn(0).setPreferredWidth(15);
		tblHistory.getColumnModel().getColumn(2).setPreferredWidth(15);
		tblHistory.getColumnModel().getColumn(3).setPreferredWidth(15);
		scrollPane_2.setViewportView(tblHistory);
		
		JLabel label_7 = new JLabel("");
		label_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				System.exit(0);
			}
		});
		label_7.setIcon(new ImageIcon(AuthorizedMenu.class.getResource("/icons/icons8-cancel-filled-40.png")));
		label_7.setBounds(572, 2, 40, 47);
		pnlSalesHistory.add(label_7);
		pnlProduct.setBounds(0, 0, 616, 479);
		layeredPane.add(pnlProduct);
		pnlProduct.setLayout(null);
		
		JButton btnDeleteProduct = new JButton("Delete Product");
		btnDeleteProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int selectedrow = prdTable.getSelectedRow();
			       
			       if (selectedrow == -1) {
			           if (model.getRowCount() == 0 ) {
			               JOptionPane.showMessageDialog(null,"Table is empty.");
			           }
			           else {
			        	   JOptionPane.showMessageDialog(null,"Please select a row.");
			           }
			      
			       }
			       else {
			           String prdname = (String) prdTable.getValueAt(selectedrow,2);
			           
			           
			           db.deleteProduct(prdname);
			           
			           JOptionPane.showMessageDialog(null, "A Product is deleted.");
			           
			           model.setRowCount(0);
			           
			           ArrayList<Product> products = new ArrayList<Product>();
			           
			           products = db.listproducts();
						
						if (products != null ) {
				            
				            for (Product prd : products) {
				                Object[] addProduct = {prd.getProductID(),prd.getCategory(),prd.getPrdName(),prd.getPrice(),prd.getStock()};
				                
				                model.addRow(addProduct);
				               
				            }
				            
				        }
			           
			       }
			}
		});
		btnDeleteProduct.setForeground(Color.WHITE);
		btnDeleteProduct.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnDeleteProduct.setBorder(null);
		btnDeleteProduct.setBackground(new Color(75, 0, 130));
		btnDeleteProduct.setBounds(89, 406, 144, 45);
		pnlProduct.add(btnDeleteProduct);
		
		JLabel label = new JLabel("");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		label.setIcon(new ImageIcon(AuthorizedMenu.class.getResource("/icons/icons8-cancel-filled-40.png")));
		label.setBounds(572, 2, 40, 47);
		pnlProduct.add(label);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBorder(new MatteBorder(4, 0, 4, 0, (Color) new Color(75, 0, 130)));
		scrollPane_1.setBounds(0, 83, 612, 257);
		pnlProduct.add(scrollPane_1);
		
		prdTable = new JTable();
		prdTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Product ID", "Category", "Product Name", "Price", "Stock"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		prdTable.getColumnModel().getColumn(0).setPreferredWidth(15);
		prdTable.getColumnModel().getColumn(1).setPreferredWidth(100);
		prdTable.getColumnModel().getColumn(2).setPreferredWidth(100);
		prdTable.getColumnModel().getColumn(3).setPreferredWidth(15);
		prdTable.getColumnModel().getColumn(4).setPreferredWidth(15);
		scrollPane_1.setViewportView(prdTable);
		prdTable.setForeground(new Color(105, 105, 105));
		prdTable.setFont(new Font("Segoe UI", Font.BOLD, 14));
		
		txtSearchPrd = new JTextField();
		txtSearchPrd.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				String search = txtSearchPrd.getText();
				
				TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model);
		        prdTable.setRowSorter(tr);
		        tr.setRowFilter(RowFilter.regexFilter(search));

		        
			}
		});
		
		txtSearchPrd.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtSearchPrd.getText().equals("Search")) {
					txtSearchPrd.setText("");
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtSearchPrd.getText().equals("")) {
					txtSearchPrd.setText("Search");
				}
			}
		});
		txtSearchPrd.setText("Search");
		txtSearchPrd.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		txtSearchPrd.setColumns(10);
		txtSearchPrd.setBorder(null);
		txtSearchPrd.setBounds(89, 34, 438, 30);
		pnlProduct.add(txtSearchPrd);
		
		JLabel label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon(AuthorizedMenu.class.getResource("/icons/icons8-google-web-search-filled-40.png")));
		label_6.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		label_6.setBounds(34, 27, 40, 44);
		pnlProduct.add(label_6);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(75, 0, 130));
		separator_1.setBounds(90, 64, 437, 4);
		pnlProduct.add(separator_1);
		
		JButton btnUpdatePrice = new JButton("Update Price");
		btnUpdatePrice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int selectedrow = prdTable.getSelectedRow();
				
				//JOptionPane.showMessageDialog(null, selectedrow);
			       
			       if (selectedrow == -1) {
			           if (model.getRowCount() == 0 ) {
			               JOptionPane.showMessageDialog(null,"Table is empty.");
			           }
			           else {
			        	   JOptionPane.showMessageDialog(null,"Please select a row.");
			           }
			      
			       }
			       else {
			           String prdname = (String) prdTable.getValueAt(selectedrow,2);
			           
			           double price = Double.parseDouble(JOptionPane.showInputDialog("Enter price"));
			           
			           db.updateProduct(prdname,price);
			           
			           JOptionPane.showMessageDialog(null, prdname + "'s price is updated.");
			           
			           model.setRowCount(0);
			           
			           ArrayList<Product> products = new ArrayList<Product>();
			           
			           products = db.listproducts();
						
						if (products != null ) {
				            
				            for (Product prd : products) {
				                Object[] addProduct = {prd.getProductID(),prd.getCategory(),prd.getPrdName(),prd.getPrice(),prd.getStock()};
				                
				                model.addRow(addProduct);
				               
				            }
				            
				        }
			           
			       }
			}
		});
		btnUpdatePrice.setForeground(Color.WHITE);
		btnUpdatePrice.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnUpdatePrice.setBorder(null);
		btnUpdatePrice.setBackground(new Color(75, 0, 130));
		btnUpdatePrice.setBounds(248, 406, 144, 45);
		pnlProduct.add(btnUpdatePrice);
		
		JButton btnAddStock = new JButton("Add Stock");
		btnAddStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				   int selectedrow = prdTable.getSelectedRow();
				
				
			       
			       if (selectedrow == -1) {
			           if (model.getRowCount() == 0 ) {
			               JOptionPane.showMessageDialog(null,"Table is empty.");
			           }
			           else {
			        	   JOptionPane.showMessageDialog(null,"Please select a row.");
			           }
			      
			       }
			       else {
			           String prdname = (String) prdTable.getValueAt(selectedrow,2);
			           
			           int addedStock = Integer.parseInt(JOptionPane.showInputDialog("Enter stock"));
			           
			           db.addStock(prdname,addedStock);
			           
			           JOptionPane.showMessageDialog(null, prdname + "'s stock is changed.");
			           
			           model.setRowCount(0);
			           
			           ArrayList<Product> products = new ArrayList<Product>();
			           
			           products = db.listproducts();
						
						if (products != null ) {
				            
				            for (Product prd : products) {
				                Object[] addProduct = {prd.getProductID(),prd.getCategory(),prd.getPrdName(),prd.getPrice(),prd.getStock()};
				                
				                model.addRow(addProduct);
				               
				            }
				            
				        }
			           
			       }
			}
		});
		btnAddStock.setForeground(Color.WHITE);
		btnAddStock.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnAddStock.setBorder(null);
		btnAddStock.setBackground(new Color(75, 0, 130));
		btnAddStock.setBounds(402, 406, 144, 45);
		pnlProduct.add(btnAddStock);
		pnlEmployee.setBorder(new MatteBorder(4, 0, 4, 4, (Color) new Color(75, 0, 130)));
		pnlEmployee.setBackground(new Color(255, 255, 255));
		pnlEmployee.setBounds(0, 0, 616, 479);
		layeredPane.add(pnlEmployee);
		pnlEmployee.setLayout(null);
		
		JButton btnDeleteEmployee = new JButton("Delete Employee");
		btnDeleteEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int selectedrow = empTable.getSelectedRow();
			       
			       if (selectedrow == -1) {
			           if (model.getRowCount() == 0 ) {
			               JOptionPane.showMessageDialog(null,"Table is empty.");
			           }
			           else {
			        	   JOptionPane.showMessageDialog(null,"Please select a row.");
			           }
			      
			       }
			       else {
			           int id = (int)empTable.getValueAt(selectedrow,1);
			           
			           db.deleteEmployee(id);
			           
			           JOptionPane.showMessageDialog(null, "An employee is deleted.");
			           
			           model.setRowCount(0);
			           
			           ArrayList<Employee> employees = new ArrayList<Employee>();
			           
			           employees = db.listemployees();
						
						if (employees != null ) {
				            
				            for (Employee emp : employees) {
				            	String aut;
				            	
				            	if(emp.isAuthority()==true) {

				            			aut = "Manager";
				            	}
				            	else {
				            			aut= "Staff"; 
				            	}
				            	
				                Object[] addEmployee = {aut,emp.getId(),emp.getName(),emp.getLastName(),emp.getWage()};
				                
				                model.addRow(addEmployee);
				               
				            }      
				        }
			           
			       }
			}
		});
		btnDeleteEmployee.setForeground(Color.WHITE);
		btnDeleteEmployee.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnDeleteEmployee.setBorder(null);
		btnDeleteEmployee.setBackground(new Color(75, 0, 130));
		btnDeleteEmployee.setBounds(157, 423, 144, 45);
		pnlEmployee.add(btnDeleteEmployee);
		
		JButton btnAuthorizeEmployee = new JButton("Authorize Employee");
		btnAuthorizeEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 int selectedrow = empTable.getSelectedRow();
				
				 if (selectedrow == -1) {
			           if (model.getRowCount() == 0 ) {
			               JOptionPane.showMessageDialog(null,"Table is empty.");
			           }
			           else {
			        	   JOptionPane.showMessageDialog(null,"Please select a row.");
			           }
			      
			       }
			       else {
			           int id = (int)empTable.getValueAt(selectedrow,1);
			          
			           
			           
			           db.authorizeEmployee(id);
			           
			           JOptionPane.showMessageDialog(null, "An employee is authorized.");
			           
			           model.setRowCount(0);
			           
			           ArrayList<Employee> employees = new ArrayList<Employee>();
			           
			           employees = db.listemployees();
						
						if (employees != null ) {
				            
				            for (Employee emp : employees) {
				            	String aut;
				            	
				            	if(emp.isAuthority()==true) {

				            			aut = "Manager";
				            	}
				            	else {
				            			aut= "Staff"; 
				            	}
				            	
				                Object[] addEmployee = {aut,emp.getId(),emp.getName(),emp.getLastName(),emp.getWage()};
				                
				                model.addRow(addEmployee);
				               
				            }
				            
				        }
	
			       }
			}
		});
		btnAuthorizeEmployee.setForeground(Color.WHITE);
		btnAuthorizeEmployee.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnAuthorizeEmployee.setBorder(null);
		btnAuthorizeEmployee.setBackground(new Color(75, 0, 130));
		btnAuthorizeEmployee.setBounds(311, 423, 144, 45);
		pnlEmployee.add(btnAuthorizeEmployee);
		
		txtSearch = new JTextField();
		txtSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				String search = txtSearch.getText();
				
				TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model);
		        
		        
		        empTable.setRowSorter(tr);
		        
		        
		        tr.setRowFilter(RowFilter.regexFilter(search));
			}
		});
		txtSearch.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				
				if(txtSearch.getText().equals("Search")) {
					txtSearch.setText("");
				}
				
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtSearch.getText().equals("")) {
					txtSearch.setText("Search");
				}
			}
		});
		
		txtSearch.setBorder(null);
		txtSearch.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		txtSearch.setText("Search");
		txtSearch.setBounds(89, 34, 438, 30);
		pnlEmployee.add(txtSearch);
		txtSearch.setColumns(10);
		
		JLabel lblSearch = new JLabel("");
		lblSearch.setIcon(new ImageIcon(AuthorizedMenu.class.getResource("/icons/icons8-google-web-search-filled-40.png")));
		lblSearch.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblSearch.setBounds(34, 27, 40, 45);
		pnlEmployee.add(lblSearch);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(75, 0, 130));
		separator.setBounds(90, 64, 437, 4);
		pnlEmployee.add(separator);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new MatteBorder(4, 0, 4, 4, (Color) new Color(75, 0, 130)));
		scrollPane.setForeground(Color.WHITE);
		scrollPane.setBackground(new Color(255, 255, 255));
		scrollPane.setBounds(0, 83, 616, 217);
		pnlEmployee.add(scrollPane);
		
		empTable = new JTable();
		empTable.setForeground(new Color(105, 105, 105));
		scrollPane.setViewportView(empTable);
		empTable.setFont(new Font("Segoe UI", Font.BOLD, 14));
		empTable.setBorder(null);
		empTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Authority", "Id", "Name", "Last Name", "Wage"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, true, true, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		
		JButton btnUpdateWage = new JButton("Update Wage");
		btnUpdateWage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int selectedrow = empTable.getSelectedRow();
				
				 if (selectedrow == -1) {
			           if (model.getRowCount() == 0 ) {
			               JOptionPane.showMessageDialog(null,"Table is empty.");
			           }
			           else {
			        	   JOptionPane.showMessageDialog(null,"Please select a row.");
			           }
			      
			       }
			       else {
			           int id = (int)empTable.getValueAt(selectedrow,1);
			           double wage = Double.parseDouble(JOptionPane.showInputDialog("Enter wage"));
			           
			           
			           db.updateEmployee(id,wage);
			           
			           JOptionPane.showMessageDialog(null, "An employee is updated.");
			           
			           model.setRowCount(0);
			           
			           ArrayList<Employee> employees = new ArrayList<Employee>();
			           
			           employees = db.listemployees();
						
						if (employees != null ) {
				            
				            for (Employee emp : employees) {
				            	String aut;
				            	
				            	if(emp.isAuthority()==true) {

				            			aut = "Manager";
				            	}
				            	else {
				            			aut= "Staff"; 
				            	}
				            	
				                Object[] addEmployee = {aut,emp.getId(),emp.getName(),emp.getLastName(),emp.getWage()};
				                
				                model.addRow(addEmployee);
				               
				            }
				            
				        }
	
			       }
			}
		});
		btnUpdateWage.setForeground(Color.WHITE);
		btnUpdateWage.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnUpdateWage.setBorder(null);
		btnUpdateWage.setBackground(new Color(75, 0, 130));
		btnUpdateWage.setBounds(5, 423, 144, 45);
		pnlEmployee.add(btnUpdateWage);
		
		JLabel label_2 = new JLabel("");
		label_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		label_2.setIcon(new ImageIcon(AuthorizedMenu.class.getResource("/icons/icons8-cancel-filled-40.png")));
		label_2.setBounds(572, 2, 40, 47);
		pnlEmployee.add(label_2);
		
		JButton btnNonauthorize = new JButton("Non-Authorize");
		btnNonauthorize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 int selectedrow = empTable.getSelectedRow();
					
				 if (selectedrow == -1) {
			           if (model.getRowCount() == 0 ) {
			               JOptionPane.showMessageDialog(null,"Table is empty.");
			           }
			           else {
			        	   JOptionPane.showMessageDialog(null,"Please select a row.");
			           }
			      
			       }
			       else {
			           int id = (int)empTable.getValueAt(selectedrow,1);
			          
			           
			           
			           db.nonAuthorizeEmployee(id);
			           
			           JOptionPane.showMessageDialog(null, "An employee is non-authorized.");
			           
			           model.setRowCount(0);
			           
			           ArrayList<Employee> employees = new ArrayList<Employee>();
			           
			           employees = db.listemployees();
						
						if (employees != null ) {
				            
				            for (Employee emp : employees) {
				            	String aut;
				            	
				            	if(emp.isAuthority()==true) {

				            			aut = "Manager";
				            	}
				            	else {
				            			aut= "Staff"; 
				            	}
				            	
				                Object[] addEmployee = {aut,emp.getId(),emp.getName(),emp.getLastName(),emp.getWage()};
				                
				                model.addRow(addEmployee);
				               
				            }
				            
				        }
	
			       }
			}
		});
		btnNonauthorize.setForeground(Color.WHITE);
		btnNonauthorize.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnNonauthorize.setBorder(null);
		btnNonauthorize.setBackground(new Color(75, 0, 130));
		btnNonauthorize.setBounds(465, 423, 144, 45);
		pnlEmployee.add(btnNonauthorize);
		
		JButton btnOldEmp = new JButton(">");
		btnOldEmp.setVerticalAlignment(SwingConstants.TOP);
		btnOldEmp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				model = (DefaultTableModel) empTable.getModel();
				model.setRowCount(0);
				
				
				ArrayList<Employee> oldemployees = new ArrayList<Employee>();
				
				oldemployees = db.oldlistemployees();
				
				
				
				if (oldemployees != null ) {
		            
		            for (Employee emp : oldemployees) {
		            	
		            	String aut;
		            	
		            	if(emp.isAuthority()==true) {

		            			aut = "Manager";
		            	}
		            	else {
		            			aut= "Staff"; 
		            	}
		            	
		                Object[] addoldEmployee = {aut,emp.getId(),emp.getName(),emp.getLastName(),emp.getWage()};
		                
		                model.addRow(addoldEmployee);
		               
		            }
		            
		        }
			}
		});
		btnOldEmp.setForeground(Color.WHITE);
		btnOldEmp.setFont(new Font("Segoe UI", Font.BOLD, 20));
		btnOldEmp.setBorder(null);
		btnOldEmp.setBackground(new Color(75, 0, 130));
		btnOldEmp.setBounds(558, 311, 30, 30);
		pnlEmployee.add(btnOldEmp);
		
		JButton btnPre = new JButton("<");
		btnPre.setVerticalAlignment(SwingConstants.TOP);
		btnPre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model = (DefaultTableModel) empTable.getModel();
				model.setRowCount(0);
				
				
				ArrayList<Employee> employees = new ArrayList<Employee>();
				
				employees = db.listemployees();
				
				if (employees != null ) {
		            
		            for (Employee emp : employees) {
		            	
		            	String aut;
		            	
		            	if(emp.isAuthority()==true) {

		            			aut = "Manager";
		            	}
		            	else {
		            			aut= "Staff"; 
		            	}
		            	
		                Object[] addEmployee = {aut,emp.getId(),emp.getName(),emp.getLastName(),emp.getWage()};
		                
		                model.addRow(addEmployee);
		               
		            }
		            
		        }
			}
		});
		btnPre.setForeground(Color.WHITE);
		btnPre.setFont(new Font("Segoe UI", Font.BOLD, 20));
		btnPre.setBorder(null);
		btnPre.setBackground(new Color(75, 0, 130));
		btnPre.setBounds(10, 311, 30, 30);
		pnlEmployee.add(btnPre);
		pnlAddProduct.setBackground(Color.WHITE);
		pnlAddProduct.setBounds(0, 0, 616, 479);
		layeredPane.add(pnlAddProduct);
		pnlAddProduct.setLayout(null);
		
		JLabel label_4 = new JLabel("");
		label_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		label_4.setIcon(new ImageIcon(AuthorizedMenu.class.getResource("/icons/icons8-cancel-filled-40.png")));
		label_4.setBounds(572, 2, 40, 47);
		pnlAddProduct.add(label_4);
		
		txtPname = new JTextField();
		txtPname.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		txtPname.setColumns(10);
		txtPname.setBorder(null);
		txtPname.setBounds(239, 138, 243, 20);
		pnlAddProduct.add(txtPname);
		
		txtPrice = new JTextField();
		txtPrice.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		txtPrice.setColumns(10);
		txtPrice.setBorder(null);
		txtPrice.setBounds(239, 184, 243, 20);
		pnlAddProduct.add(txtPrice);
		
		JLabel lblCategory = new JLabel("Category");
		lblCategory.setForeground(new Color(75, 0, 130));
		lblCategory.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblCategory.setBounds(69, 87, 98, 27);
		pnlAddProduct.add(lblCategory);
		
		JLabel lblProductName = new JLabel("Product Name");
		lblProductName.setForeground(new Color(75, 0, 130));
		lblProductName.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblProductName.setBounds(69, 133, 135, 27);
		pnlAddProduct.add(lblProductName);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setForeground(new Color(75, 0, 130));
		lblPrice.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblPrice.setBounds(69, 179, 125, 27);
		pnlAddProduct.add(lblPrice);
		
		JSeparator separator_8 = new JSeparator();
		separator_8.setForeground(new Color(75, 0, 130));
		separator_8.setBackground(new Color(75, 0, 130));
		separator_8.setBounds(239, 158, 243, 2);
		pnlAddProduct.add(separator_8);
		
		JSeparator separator_9 = new JSeparator();
		separator_9.setForeground(new Color(75, 0, 130));
		separator_9.setBackground(new Color(75, 0, 130));
		separator_9.setBounds(239, 204, 243, 2);
		pnlAddProduct.add(separator_9);
		
		JButton btnAddPrd = new JButton("Add");
		btnAddPrd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int category =categoryBox.getSelectedIndex()+1;
				String prdname = txtPname.getText();
				double price = Double.parseDouble(txtPrice.getText());
				int stock = Integer.parseInt(txtStock.getText());
						
				db.addProduct(category,prdname,price,stock);
						
				JOptionPane.showMessageDialog(null,"New Product Added to System");
						
				//categoryBox.setSelectedItem("");
				txtPname.setText("");
				txtPrice.setText("");
				txtStock.setText("");
			}
		});
		btnAddPrd.setForeground(Color.WHITE);
		btnAddPrd.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnAddPrd.setBackground(new Color(75, 0, 130));
		btnAddPrd.setBounds(284, 290, 125, 37);
		pnlAddProduct.add(btnAddPrd);
		
		categoryBox = new JComboBox();
		categoryBox.setMaximumRowCount(6);
		categoryBox.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		categoryBox.setForeground(new Color(75, 0, 130));
		categoryBox.setBackground(Color.WHITE);
		categoryBox.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(75, 0, 130)));
		categoryBox.setModel(new DefaultComboBoxModel(new String[] {"Espresso Based Beverages","Frappuccino Blended Beverages","Filter Coffees","Teas",
																	"Other Beverages","Sandwiches","Cookies","Cakes","Pastries","Desserts" }));
		categoryBox.setBounds(239, 87, 241, 32);
		pnlAddProduct.add(categoryBox);
		
		JLabel lblStock = new JLabel("Stock");
		lblStock.setForeground(new Color(75, 0, 130));
		lblStock.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblStock.setBounds(69, 225, 125, 27);
		pnlAddProduct.add(lblStock);
		
		txtStock = new JTextField();
		txtStock.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		txtStock.setColumns(10);
		txtStock.setBorder(null);
		txtStock.setBounds(239, 230, 243, 20);
		pnlAddProduct.add(txtStock);
		
		JSeparator separator_7 = new JSeparator();
		separator_7.setForeground(new Color(75, 0, 130));
		separator_7.setBackground(new Color(75, 0, 130));
		separator_7.setBounds(239, 250, 243, 2);
		pnlAddProduct.add(separator_7);
		pnlAddEmployee.setBackground(Color.WHITE);
		pnlAddEmployee.setBounds(0, 0, 616, 479);
		layeredPane.add(pnlAddEmployee);
		pnlAddEmployee.setLayout(null);
		
		txtLastname = new JTextField();
		txtLastname.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		txtLastname.setBorder(null);
		txtLastname.setColumns(10);
		txtLastname.setBounds(224, 136, 243, 20);
		pnlAddEmployee.add(txtLastname);
		
		txtWage = new JTextField();
		
		txtWage.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		txtWage.setBorder(null);
		txtWage.setColumns(10);
		txtWage.setBounds(224, 172, 243, 20);
		pnlAddEmployee.add(txtWage);
		
		txtUsername = new JTextField();
		txtUsername.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		txtUsername.setBorder(null);
		txtUsername.setColumns(10);
		txtUsername.setBounds(224, 210, 243, 20);
		pnlAddEmployee.add(txtUsername);
		
		txtName = new JTextField();
		txtName.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		txtName.setBorder(null);
		txtName.setColumns(10);
		txtName.setBounds(224, 100, 243, 20);
		pnlAddEmployee.add(txtName);
		
		JLabel label_3 = new JLabel("");
		label_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		label_3.setIcon(new ImageIcon(AuthorizedMenu.class.getResource("/icons/icons8-cancel-filled-40.png")));
		label_3.setBounds(572, 2, 40, 47);
		pnlAddEmployee.add(label_3);
		
		txtPassword = new JPasswordField();
		txtPassword.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		txtPassword.setBorder(null);
		txtPassword.setBounds(224, 246, 243, 20);
		pnlAddEmployee.add(txtPassword);
		
		JRadioButton btnAuthority = new JRadioButton("Authority");
		btnAuthority.setForeground(new Color(75, 0, 130));
		btnAuthority.setBackground(new Color(255, 255, 255));
		btnAuthority.setBorder(null);
		btnAuthority.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnAuthority.setBounds(224, 289, 119, 25);
		pnlAddEmployee.add(btnAuthority);
		
		JLabel lblName = new JLabel("Name");
		lblName.setForeground(new Color(75, 0, 130));
		lblName.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblName.setBounds(70, 93, 82, 25);
		pnlAddEmployee.add(lblName);
		
		JLabel lblUserName = new JLabel("Lastname");
		lblUserName.setForeground(new Color(75, 0, 130));
		lblUserName.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblUserName.setBounds(70, 129, 109, 25);
		pnlAddEmployee.add(lblUserName);
		
		JLabel label_5 = new JLabel("Username");
		label_5.setForeground(new Color(75, 0, 130));
		label_5.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		label_5.setBounds(70, 203, 109, 25);
		pnlAddEmployee.add(label_5);
		
		JLabel lblWage = new JLabel("Wage");
		lblWage.setForeground(new Color(75, 0, 130));
		lblWage.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblWage.setBounds(70, 165, 109, 27);
		pnlAddEmployee.add(lblWage);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(new Color(75, 0, 130));
		lblPassword.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblPassword.setBounds(70, 239, 109, 25);
		pnlAddEmployee.add(lblPassword);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBackground(new Color(75, 0, 130));
		separator_2.setForeground(new Color(75, 0, 130));
		separator_2.setBounds(224, 120, 243, 2);
		pnlAddEmployee.add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setForeground(new Color(75, 0, 130));
		separator_3.setBackground(new Color(75, 0, 130));
		separator_3.setBounds(224, 156, 243, 2);
		pnlAddEmployee.add(separator_3);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setForeground(new Color(75, 0, 130));
		separator_4.setBackground(new Color(75, 0, 130));
		separator_4.setBounds(224, 192, 243, 2);
		pnlAddEmployee.add(separator_4);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setForeground(new Color(75, 0, 130));
		separator_5.setBackground(new Color(75, 0, 130));
		separator_5.setBounds(224, 230, 243, 2);
		pnlAddEmployee.add(separator_5);
		
		JSeparator separator_6 = new JSeparator();
		separator_6.setForeground(new Color(75, 0, 130));
		separator_6.setBackground(new Color(75, 0, 130));
		separator_6.setBounds(224, 266, 243, 2);
		pnlAddEmployee.add(separator_6);
		
		JButton btnAddEmp = new JButton("Add");
		btnAddEmp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String name = txtName.getText();
				String lastname = txtLastname.getText();
				double wage = Double.parseDouble(txtWage.getText());
				String username = txtUsername.getText();
				String password = new String(txtPassword.getPassword());
				boolean authority = btnAuthority.isSelected();
				
				db.addEmployee(name, lastname, wage, username, password, authority);
				
				JOptionPane.showMessageDialog(null,"New Employee Added to System");
				
				txtName.setText("");
				txtLastname.setText("");
				txtWage.setText("");
				txtUsername.setText("");
				txtPassword.setText("");
				btnAuthority.setSelected(false);
			}
		});
		btnAddEmp.setBackground(new Color(75, 0, 130));
		btnAddEmp.setForeground(new Color(255, 255, 255));
		btnAddEmp.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnAddEmp.setBounds(271, 344, 125, 37);
		pnlAddEmployee.add(btnAddEmp);
		
		pnlEmpty = new JPanel();
		pnlEmpty.setBorder(new MatteBorder(4, 0, 4, 4, (Color) new Color(75, 0, 130)));
		pnlEmpty.setBackground(new Color(255, 255, 255));
		pnlEmpty.setBounds(0, 0, 616, 479);
		layeredPane.add(pnlEmpty);
		pnlEmpty.setLayout(null);
		
		JLabel label_1 = new JLabel("");
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		label_1.setIcon(new ImageIcon(AuthorizedMenu.class.getResource("/icons/icons8-cancel-filled-40.png")));
		label_1.setBounds(572, 2, 40, 47);
		pnlEmpty.add(label_1);
		
	}
}
