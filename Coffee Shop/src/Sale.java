import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.border.MatteBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;

import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Sale extends JFrame {
	
	DBOperations db = new DBOperations();

	private JPanel contentPane;
	private final JPanel pnlOrder = new JPanel();
	private JComboBox categoryBox;
	private JComboBox productBox;
	ArrayList<String> products;
	private JTextField txtOrder;
	private DefaultListModel list = new DefaultListModel();
	private DefaultTableModel model;
	private JTable CartTable;
	double total=0;
	private ArrayList<Orders> basket = new ArrayList<Orders>();
	JLabel lblTotal;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sale frame = new Sale();
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
	@SuppressWarnings({ "unchecked", "serial" })
	public Sale() {
		
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 829, 472);
		contentPane = new JPanel();
		contentPane.setBorder(new MatteBorder(4, 4, 4, 4, (Color) new Color(75, 0, 130)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pnlBill = new JPanel();
		pnlBill.setBackground(new Color(75, 0, 130));
		pnlBill.setBounds(0, 0, 329, 472);
		contentPane.add(pnlBill);
		pnlBill.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new MatteBorder(1, 4, 1, 4, (Color) new Color(75, 0, 130)));
		scrollPane.setBounds(0, 83, 329, 138);
		pnlBill.add(scrollPane);
		
		CartTable = new JTable();
		CartTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Product", "Price", "Quantity"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		CartTable.setForeground(new Color(105, 105, 105));
		CartTable.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		scrollPane.setViewportView(CartTable);
		
		JLabel lblCart = new JLabel("CART");
		lblCart.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblCart.setForeground(new Color(255, 255, 255));
		lblCart.setBounds(136, 38, 56, 27);
		pnlBill.add(lblCart);
		
		JButton btnPay = new JButton("Pay");
		btnPay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if(CartTable.getRowCount()==0) {
					JOptionPane.showMessageDialog(null, "No Amount to be paid");
				}
				
				else {
					  
					for(int crow=0;crow<model.getRowCount();crow++) {
				
					  int id = db.getId(model.getValueAt(crow, 0).toString());
					  
					  Orders ord = new Orders(id,model.getValueAt(crow, 0).toString(),Double.parseDouble(model.getValueAt(crow, 1).toString()),
							  Integer.parseInt(model.getValueAt(crow, 2).toString()));
				
					   db.ordersTable(ord.getPrdID(),ord.getPrdname(),ord.getPrdprice(),ord.getQuantity());
					   
					   db.updateStock(ord.getPrdname(),ord.getQuantity());
					   
			        }
					
					model.setRowCount(0);
					lblTotal.setText("");
					
					JOptionPane.showMessageDialog(null, "Payment completed successfully");
			            
			        }
				}
			
				
			
			//db.putorder(sale.get(0));	
				//textField.setText(""+Double.parseDouble(model.getValueAt(0, 1).toString()));
				//System.out.println(sale.get(0));
				
				
				//ord.getPrdprice();
				
			}
		);
		btnPay.setForeground(new Color(75, 0, 130));
		btnPay.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnPay.setBackground(new Color(255, 255, 255));
		btnPay.setBounds(97, 385, 138, 37);
		pnlBill.add(btnPay);
		
		JLabel lblTtl = new JLabel("Total :");
		lblTtl.setForeground(new Color(255, 255, 255));
		lblTtl.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lblTtl.setBounds(207, 232, 56, 25);
		pnlBill.add(lblTtl);
		
		lblTotal = new JLabel("");
		lblTotal.setForeground(new Color(255, 255, 255));
		lblTotal.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblTotal.setBounds(261, 232, 68, 25);
		pnlBill.add(lblTotal);
		pnlOrder.setBorder(new MatteBorder(4, 0, 4, 4, (Color) new Color(75, 0, 130)));
		pnlOrder.setBackground(new Color(255, 255, 255));
		pnlOrder.setBounds(330, 0, 499, 472);
		contentPane.add(pnlOrder);
		pnlOrder.setLayout(null);
		
		categoryBox = new JComboBox();
		categoryBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				productBox.removeAllItems();
		        
		        ArrayList<String> list = db.listSelectedCategory((String)categoryBox.getSelectedItem());
		        for(int i = 0; i < list.size(); i++){
		            productBox.addItem(list.get(i));
		        } 
			}
		});
		categoryBox.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(75, 0, 130)));
		categoryBox.setForeground(new Color(75, 0, 130));
		categoryBox.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		categoryBox.setBackground(new Color(255, 255, 255));
		categoryBox.setModel(new DefaultComboBoxModel(new String[] {"", "Espresso Based Beverages", "Frappuccino Blended Beverages", "Filter Coffees", "Teas", "Other Beverages", "Sandwiches", "Cookies", "Cakes", "Pastries", "Desserts"}));
		categoryBox.setBounds(87, 22, 324, 37);
		pnlOrder.add(categoryBox);
		
		
		
		products = db.listSelectedCategory((String)categoryBox.getSelectedItem());
		
		productBox = new JComboBox();
		productBox.setForeground(new Color(75, 0, 130));
		productBox.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		productBox.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(75, 0, 130)));
		productBox.setBackground(Color.WHITE);
		productBox.setBounds(87, 70, 324, 37);
		productBox.setModel(new DefaultComboBoxModel(
				
				
				//products.toArray()
				
				));
		pnlOrder.add(productBox);
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(75, 0, 130)));
		panel.setBounds(87, 159, 324, 223);
		pnlOrder.add(panel);
		panel.setLayout(null);
		
		JButton btn1 = new JButton("1");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtOrder.setText(txtOrder.getText()+"1");
				
			}
		});
		btn1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btn1.setForeground(new Color(75, 0, 130));
		btn1.setBackground(new Color(255, 255, 255));
		btn1.setBorder(new MatteBorder(4, 4, 4, 2, (Color) new Color(75, 0, 130)));
		btn1.setBounds(0, 0, 108, 58);
		panel.add(btn1);
		
		JButton btn2 = new JButton("2");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtOrder.setText(txtOrder.getText()+"2");
			}
		});
		btn2.setForeground(new Color(75, 0, 130));
		btn2.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btn2.setBorder(new MatteBorder(4, 2, 4, 2, (Color) new Color(75, 0, 130)));
		btn2.setBackground(new Color(255, 255, 255));
		btn2.setBounds(108, 0, 108, 58);
		panel.add(btn2);
		
		JButton btn3 = new JButton("3");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtOrder.setText(txtOrder.getText()+"3");
			}
		});
		btn3.setForeground(new Color(75, 0, 130));
		btn3.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btn3.setBorder(new MatteBorder(4, 2, 4, 4, (Color) new Color(75, 0, 130)));
		btn3.setBackground(new Color(255, 255, 255));
		btn3.setBounds(216, 0, 108, 58);
		panel.add(btn3);
		
		JButton btn4 = new JButton("4");
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtOrder.setText(txtOrder.getText()+"4");
			}
		});
		btn4.setForeground(new Color(75, 0, 130));
		btn4.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btn4.setBorder(new MatteBorder(2, 4, 4, 2, (Color) new Color(75, 0, 130)));
		btn4.setBackground(new Color(255, 255, 255));
		btn4.setBounds(0, 55, 108, 58);
		panel.add(btn4);
		
		JButton btn5 = new JButton("5");
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtOrder.setText(txtOrder.getText()+"5");
			}
		});
		btn5.setForeground(new Color(75, 0, 130));
		btn5.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btn5.setBorder(new MatteBorder(2, 2, 4, 2, (Color) new Color(75, 0, 130)));
		btn5.setBackground(new Color(255, 255, 255));
		btn5.setBounds(108, 55, 108, 58);
		panel.add(btn5);
		
		JButton btn6 = new JButton("6");
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtOrder.setText(txtOrder.getText()+"6");
			}
		});
		btn6.setForeground(new Color(75, 0, 130));
		btn6.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btn6.setBorder(new MatteBorder(2, 2, 4, 4, (Color) new Color(75, 0, 130)));
		btn6.setBackground(new Color(255, 255, 255));
		btn6.setBounds(216, 55, 108, 58);
		panel.add(btn6);
		
		JButton btn7 = new JButton("7");
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtOrder.setText(txtOrder.getText()+"7");
			}
		});
		btn7.setForeground(new Color(75, 0, 130));
		btn7.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btn7.setBorder(new MatteBorder(2, 4, 4, 2, (Color) new Color(75, 0, 130)));
		btn7.setBackground(new Color(255, 255, 255));
		btn7.setBounds(0, 110, 108, 58);
		panel.add(btn7);
		
		JButton btn8 = new JButton("8");
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtOrder.setText(txtOrder.getText()+"8");
			}
		});
		btn8.setForeground(new Color(75, 0, 130));
		btn8.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btn8.setBorder(new MatteBorder(2, 2, 4, 2, (Color) new Color(75, 0, 130)));
		btn8.setBackground(new Color(255, 255, 255));
		btn8.setBounds(108, 110, 108, 58);
		panel.add(btn8);
		
		JButton btn9 = new JButton("9");
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtOrder.setText(txtOrder.getText()+"9");
			}
		});
		btn9.setForeground(new Color(75, 0, 130));
		btn9.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btn9.setBorder(new MatteBorder(2, 2, 4, 4, (Color) new Color(75, 0, 130)));
		btn9.setBackground(new Color(255, 255, 255));
		btn9.setBounds(216, 110, 108, 58);
		panel.add(btn9);
		
		JButton btn0 = new JButton("0");
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtOrder.setText(txtOrder.getText()+"0");
			}
		});
		btn0.setForeground(new Color(75, 0, 130));
		btn0.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btn0.setBorder(new MatteBorder(2, 2, 4, 2, (Color) new Color(75, 0, 130)));
		btn0.setBackground(new Color(255, 255, 255));
		btn0.setBounds(108, 165, 108, 58);
		panel.add(btn0);
		
		JButton button_10 = new JButton("");
		button_10.setForeground(new Color(75, 0, 130));
		button_10.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		button_10.setBorder(new MatteBorder(2, 2, 4, 4, (Color) new Color(75, 0, 130)));
		button_10.setBackground(new Color(255, 255, 255));
		button_10.setBounds(216, 165, 108, 58);
		panel.add(button_10);
		
		JButton button_8 = new JButton("");
		button_8.setForeground(new Color(75, 0, 130));
		button_8.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		button_8.setBorder(new MatteBorder(2, 4, 4, 2, (Color) new Color(75, 0, 130)));
		button_8.setBackground(new Color(255, 255, 255));
		button_8.setBounds(0, 165, 108, 58);
		panel.add(button_8);
		
		JLabel label = new JLabel("");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				System.exit(0);
			}
		});
		label.setIcon(new ImageIcon(Sale.class.getResource("/icons/icons8-cancel-filled-40.png")));
		label.setBounds(455, 1, 40, 47);
		pnlOrder.add(label);
		
		
		
		JButton btnAddCart = new JButton("Add to Cart");
		btnAddCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if(categoryBox.getSelectedItem().equals(0) || txtOrder.getText().equals("")) {
					
					JOptionPane.showMessageDialog(null, "You cannot add to the cart without selecting the product or specifying the quantity");
				}
				
				else {
					String ctgry = (String)categoryBox.getSelectedItem();
					String prdct = (String)productBox.getSelectedItem();
					int orders = Integer.parseInt(txtOrder.getText());
					
					
					model = (DefaultTableModel) CartTable.getModel();
					
					
					double price =db.getPrdc(prdct);
					
					
				    Object[] obj = {prdct,price,orders};
					
			       
			        total+=price*orders;
					
					model.insertRow(0, obj);
					
			        lblTotal.setText(""+total);

					
					txtOrder.setText("");
					
					
					
					
				}
			}
		});
		btnAddCart.setForeground(new Color(255, 255, 255));
		btnAddCart.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnAddCart.setBackground(new Color(75, 0, 130));
		btnAddCart.setBounds(181, 403, 138, 37);
		pnlOrder.add(btnAddCart);
		
		txtOrder = new JTextField();
		txtOrder.setBounds(87, 118, 324, 30);
		pnlOrder.add(txtOrder);
		txtOrder.setColumns(10);
		
		JLabel label_1 = new JLabel("");
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int orders = Integer.parseInt(txtOrder.getText());
				
				orders/=10;
				
				txtOrder.setText(""+orders);
				
				if(orders==0) {
					txtOrder.setText("");
				}
				
			}
		});
		label_1.setIcon(new ImageIcon("C:\\Users\\admin\\Desktop\\Icons\\icons8-previous-filled-30.png"));
		label_1.setBounds(418, 118, 30, 30);
		pnlOrder.add(label_1);
		
		
	}
}