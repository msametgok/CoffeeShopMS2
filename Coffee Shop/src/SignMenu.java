import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import net.miginfocom.swing.MigLayout;
import javax.swing.border.BevelBorder;
import javax.swing.JSeparator;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.Dimension;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.LineBorder;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.MatteBorder;
import java.awt.event.MouseMotionAdapter;

public class SignMenu extends JFrame {

	DBOperations db = new DBOperations();
	
	private JPanel contentPane;
	 JTextField txtUserName;
	private JPasswordField pwdPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignMenu frame = new SignMenu();
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
	
	
			
	public SignMenu() {
		setUndecorated(true);
		setMinimumSize(new Dimension(719, 478));
		setTitle("CoffeeshopMS");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 719, 478);
		contentPane = new JPanel();
		contentPane.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(75, 0, 130)));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		
		panel.setBounds(0, 0, 719, 478);
		panel.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(75, 0, 130)));
		panel.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		panel.setBackground(new Color(255, 255, 255));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(100, 11, 510, 446);
		panel_2.setBorder(null);
		panel_2.setBackground(new Color(255, 255, 255));
		
		JLabel lblUsername = new JLabel("");
		lblUsername.setBounds(86, 126, 42, 50);
		lblUsername.setIcon(new ImageIcon(SignMenu.class.getResource("/icons/icons8-user-male-40.png")));
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblPassword = new JLabel("");
		lblPassword.setBounds(86, 205, 42, 50);
		lblPassword.setIcon(new ImageIcon(SignMenu.class.getResource("/icons/icons8-lock-40.png")));
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		txtUserName = new JTextField();
		txtUserName.setBounds(150, 144, 212, 32);
		txtUserName.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		txtUserName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				
				if(txtUserName.getText().equals("Username")) {
					txtUserName.setText("");
				}
				
			}
			@Override
			public void focusLost(FocusEvent e) {
				
				if(txtUserName.getText().equals("")) {
					txtUserName.setText("Username");
				}
				
			}
		});
		txtUserName.setBorder(null);
		txtUserName.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtUserName.setText("Username");
		txtUserName.setColumns(10);
		
		pwdPassword = new JPasswordField();
		pwdPassword.setBounds(150, 223, 212, 32);
		
		pwdPassword.addFocusListener(new FocusAdapter() {
			
			@Override
			public void focusGained(FocusEvent e) {
				
				char[] passw=pwdPassword.getPassword();
				String mypassword = new String(passw);
				
				if(mypassword.equals("Password")) {
					
					pwdPassword.setText("");
				}
				
			}
			@Override
			public void focusLost(FocusEvent e) {
				char[] passw=pwdPassword.getPassword();
				String mypassword = new String(passw);
				
				if(mypassword.equals("")) {
					
					pwdPassword.setText("Password");
				}
			}
		});
		contentPane.setLayout(null);
		pwdPassword.setBorder(null);
		pwdPassword.setText("Password");
		pwdPassword.setToolTipText("");
		pwdPassword.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String username = txtUserName.getText();
				String password = new String(pwdPassword.getPassword());
				
				boolean isManager = db.loginmanager(username, password);
				boolean isStaff = db.loginstaff(username, password);
				
				if(isManager) {
					dispose();
					AuthorizedMenu autmenu = new AuthorizedMenu();
					autmenu.setVisible(true);
				}
				else if(isStaff) {
					dispose();
					Sale salemenu = new Sale();
					salemenu.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "Wrong Username or Password. Try Again.");
				}
				
			}
		});
		btnLogin.setBounds(262, 274, 116, 39);
		btnLogin.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnLogin.setForeground(new Color(255, 255, 255));
		btnLogin.setBorder(null);
		btnLogin.setBackground(new Color(75, 0, 130));
		
		JLabel lblCoffeeShopManagement = new JLabel("Coffee Shop Management System");
		lblCoffeeShopManagement.setBounds(78, 56, 330, 34);
		lblCoffeeShopManagement.setBorder(null);
		lblCoffeeShopManagement.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		
		JSeparator separator = new JSeparator();
		separator.setBounds(150, 176, 228, 10);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(150, 255, 228, 10);
		panel.setLayout(null);
		panel.add(panel_2);
		panel_2.setLayout(null);
		panel_2.add(lblCoffeeShopManagement);
		panel_2.add(lblUsername);
		panel_2.add(txtUserName);
		panel_2.add(separator);
		panel_2.add(lblPassword);
		panel_2.add(pwdPassword);
		panel_2.add(separator_1);
		panel_2.add(btnLogin);
		contentPane.add(panel);
		
		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.TRAILING);
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		label.setIcon(new ImageIcon(SignMenu.class.getResource("/icons/icons8-cancel-filled-40.png")));
		label.setBounds(668, 0, 48, 46);
		panel.add(label);
	}
}
