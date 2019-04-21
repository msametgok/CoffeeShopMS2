import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.border.MatteBorder;

public class Sale extends JFrame {

	private JPanel contentPane;
	private final JPanel pnlOrder = new JPanel();

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
	@SuppressWarnings("unchecked")
	public Sale() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 829, 472);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pnlBill = new JPanel();
		pnlBill.setBackground(new Color(75, 0, 130));
		pnlBill.setBounds(0, 0, 258, 433);
		contentPane.add(pnlBill);
		pnlOrder.setBackground(new Color(255, 255, 255));
		pnlOrder.setBounds(257, 0, 558, 433);
		contentPane.add(pnlOrder);
		pnlOrder.setLayout(null);
		
		JComboBox categoryBox = new JComboBox();
		categoryBox.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(75, 0, 130)));
		categoryBox.setForeground(new Color(75, 0, 130));
		categoryBox.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		categoryBox.setBackground(new Color(255, 255, 255));
		categoryBox.setModel(new DefaultComboBoxModel(new String[] {"Espresso Based Beverages","Frappuccino Blended Beverages","Filter Coffees","Teas",
				"Other Beverages","Sandwiches","Cookies","Cakes","Pastries","Desserts"}));
		categoryBox.setBounds(65, 38, 324, 37);
		pnlOrder.add(categoryBox);
		
		JComboBox productBox = new JComboBox();
		productBox.setForeground(new Color(75, 0, 130));
		productBox.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		productBox.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(75, 0, 130)));
		productBox.setBackground(Color.WHITE);
		productBox.setBounds(65, 108, 324, 37);
		productBox.setModel(new DefaultComboBoxModel(
				
				String [] boxproducts = 
				
				
				
				));
		pnlOrder.add(productBox);
	}
}
