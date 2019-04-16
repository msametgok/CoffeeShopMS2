import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class AuthorizedMenu extends JFrame {

	private JPanel contentPane;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 716, 502);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 190, 339);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Operations");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(50, 35, 89, 25);
		panel.add(lblNewLabel);
		
		JButton btnShowEmployees = new JButton("Show Employees");
		btnShowEmployees.setBounds(24, 71, 141, 23);
		panel.add(btnShowEmployees);
		
		JButton btnAddEmployee = new JButton("Add Employee");
		btnAddEmployee.setBounds(24, 105, 141, 23);
		panel.add(btnAddEmployee);
		
		JButton btnDeleteEmployee = new JButton("Delete Employee");
		btnDeleteEmployee.setBounds(24, 139, 141, 23);
		panel.add(btnDeleteEmployee);
		
		JButton btnShowCoffees = new JButton("Show Coffees");
		btnShowCoffees.setBounds(24, 207, 141, 23);
		panel.add(btnShowCoffees);
		
		JButton btnRaiseWage = new JButton("Raise Wage");
		btnRaiseWage.setBounds(24, 173, 141, 23);
		panel.add(btnRaiseWage);
		
		JButton btnIncreasePrice = new JButton("Increase Price");
		btnIncreasePrice.setBounds(24, 241, 141, 23);
		panel.add(btnIncreasePrice);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(210, 11, 364, 339);
		contentPane.add(panel_1);
	}
}
