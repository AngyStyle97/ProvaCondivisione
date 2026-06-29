
package GUI;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import controller.controller;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblNewLabel_1;
	controller c1;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
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
	public login() {
		c1=new controller();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(163, 97, 96, 18);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(163, 148, 96, 18);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("email");
		lblNewLabel.setBounds(91, 100, 44, 12);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("password");
		lblNewLabel_1.setBounds(78, 151, 44, 12);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("accedi");
		btnNewButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String emailinserita = textField.getText();
		        String passwordinserita = textField_1.getText();
		        
		        
		        c1.controllalogin(emailinserita, passwordinserita, login.this);
		    } 
		}); 
				
		btnNewButton.setBounds(213, 200, 84, 20);
		contentPane.add(btnNewButton);
	}
	
	}