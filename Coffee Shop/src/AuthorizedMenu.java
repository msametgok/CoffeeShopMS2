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

public class AuthorizedMenu extends JFrame {

	DBOperations db = new DBOperations();
	DefaultTableModel model;
	
	private JPanel contentPane;
	private JTable empTable;
	private JTable table_1;
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
				//pnlEmpty.setVisible(false);
				pnlProduct.setVisible(false);
				pnlAddEmployee.setVisible(false);
				pnlAddProduct.setVisible(false);
				pnlEmployee.setVisible(true);
				
				model = (DefaultTableModel) empTable.getModel();
				model.setRowCount(0);
				
				
				ArrayList<Employee> employees = new ArrayList<Employee>();
				
				employees = db.listemployees();
				
				if (employees != null ) {
		            
		            for (Employee emp : employees) {
		                Object[] addEmployee = {emp.getId(),emp.getName(),emp.getLastName(),emp.getWage()};
		                
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
				pnlProduct.setVisible(true);
			}
		});
		btnListProducts.setBorder(null);
		btnListProducts.setForeground(Color.WHITE);
		btnListProducts.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnListProducts.setBackground(new Color(75, 0, 130));
		btnListProducts.setBounds(0, 195, 217, 36);
		panel_1.add(btnListProducts);
		
		JButton btnSwitch = new JButton("Switch to Sale");
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
		btnSwitch.setBounds(0, 311, 217, 36);
		panel_1.add(btnSwitch);
		
		JButton btnAddEmployee = new JButton("Add Employee");
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
				pnlAddEmployee.setVisible(true);
			}
		});
		btnAddEmployee.setForeground(Color.WHITE);
		btnAddEmployee.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnAddEmployee.setBorder(null);
		btnAddEmployee.setBackground(new Color(75, 0, 130));
		
		JButton btnAddProduct = new JButton("Add Product");
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
				pnlAddProduct.setVisible(true);
			}
		});
		btnAddProduct.setBounds(0, 242, 217, 36);
		panel_1.add(btnAddProduct);
		btnAddProduct.setForeground(Color.WHITE);
		btnAddProduct.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnAddProduct.setBorder(null);
		btnAddProduct.setBackground(new Color(75, 0, 130));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new MatteBorder(4, 0, 4, 4, (Color) new Color(0, 0, 0)));
		panel_2.setBounds(217, 0, 616, 479);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBorder(new MatteBorder(4, 0, 4, 4, (Color) new Color(75, 0, 130)));
		layeredPane.setBounds(0, 0, 616, 479);
		panel_2.add(layeredPane);
		
		pnlAddProduct = new JPanel();
		pnlAddProduct.setBorder(new MatteBorder(4, 0, 4, 4, (Color) new Color(75, 0, 130)));
		pnlAddProduct.setVisible(false);
		
		pnlProduct = new JPanel();
		pnlProduct.setBorder(new MatteBorder(4, 0, 4, 4, (Color) new Color(75, 0, 130)));
		pnlProduct.setVisible(false);
		
		pnlAddEmployee = new JPanel();
		pnlAddEmployee.setBorder(new MatteBorder(4, 0, 4, 4, (Color) new Color(75, 0, 130)));
		pnlAddEmployee.setVisible(false);
		
		pnlEmployee = new JPanel();
		pnlEmployee.setVisible(false);
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
			           int id = (int)model.getValueAt(selectedrow,0);
			           
			           db.deleteEmployee(id);
			           
			           JOptionPane.showMessageDialog(null, "An employee is deleted.");
			           
			           model.setRowCount(0);
			           
			           ArrayList<Employee> employees = new ArrayList<Employee>();
			           
			           employees = db.listemployees();
						
						if (employees != null ) {
				            
				            for (Employee emp : employees) {
				                Object[] addEmployee = {emp.getId(),emp.getName(),emp.getLastName(),emp.getWage()};
				                
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
		btnDeleteEmployee.setBounds(188, 423, 144, 45);
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
			           int id = (int)model.getValueAt(selectedrow,0);
			          
			           
			           
			           db.authorizeEmployee(id);
			           
			           JOptionPane.showMessageDialog(null, "An employee is authorized.");
			           
			           model.setRowCount(0);
			           
			           ArrayList<Employee> employees = new ArrayList<Employee>();
			           
			           employees = db.listemployees();
						
						if (employees != null ) {
				            
				            for (Employee emp : employees) {
				                Object[] addEmployee = {emp.getId(),emp.getName(),emp.getLastName(),emp.getWage()};
				                
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
		btnAuthorizeEmployee.setBounds(342, 423, 144, 45);
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
		scrollPane.setBorder(new MatteBorder(2, 0, 2, 4, (Color) new Color(75, 0, 130)));
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
				"Id", "Name", "Last Name","Wage"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, true
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
			           int id = (int)model.getValueAt(selectedrow,0);
			           double wage = Double.parseDouble(JOptionPane.showInputDialog("Enter wage"));
			           
			           
			           db.updateEmployee(id,wage);
			           
			           JOptionPane.showMessageDialog(null, "An employee is updated.");
			           
			           model.setRowCount(0);
			           
			           ArrayList<Employee> employees = new ArrayList<Employee>();
			           
			           employees = db.listemployees();
						
						if (employees != null ) {
				            
				            for (Employee emp : employees) {
				                Object[] addEmployee = {emp.getId(),emp.getName(),emp.getLastName(),emp.getWage()};
				                
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
		btnUpdateWage.setBounds(34, 423, 144, 45);
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
		lblWage.setBounds(70, 165, 109, 25);
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
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String name = txtName.getText();
				String lastname = txtLastname.getText();
				double wage = Double.parseDouble(txtWage.getText());
				String username = txtUsername.getText();
				String password = new String(txtPassword.getPassword());
				boolean authority = btnAuthority.isSelected();
				
				db.addEmployee(name, lastname, wage, username, password, authority, true);
				
				JOptionPane.showMessageDialog(null,"New Employee Added to System");
				
				txtName.setText("");
				txtLastname.setText("");
				txtWage.setText("");
				txtUsername.setText("");
				txtPassword.setText("");
				btnAuthority.setSelected(false);
			}
		});
		btnNewButton.setBackground(new Color(75, 0, 130));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnNewButton.setBounds(271, 344, 125, 37);
		pnlAddEmployee.add(btnNewButton);
		pnlProduct.setBounds(0, 0, 616, 479);
		layeredPane.add(pnlProduct);
		pnlProduct.setLayout(null);
		
		table_1 = new JTable();
		table_1.setBounds(10, 53, 596, 359);
		pnlProduct.add(table_1);
		
		JButton button = new JButton("Add Product");
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		button.setBorder(null);
		button.setBackground(new Color(75, 0, 130));
		button.setBounds(255, 423, 144, 45);
		pnlProduct.add(button);
		
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
