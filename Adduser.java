package resouces;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

public class Adduser extends JPanel {
	private JTextField usernametxt;
	private JTextField passwordtxt;
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	private JTextField designationtxt;
	
	
	
	

	/**
	 * Create the panel.
	 */
	public Adduser() {
		setBounds(0,0,690,527);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 646, 505);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 25, 83, 26);
		panel.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Arial", Font.BOLD, 15));
		lblPassword.setBounds(10, 146, 83, 26);
		panel.add(lblPassword);
		
		JLabel lblDesignation = new JLabel("Designation");
		lblDesignation.setFont(new Font("Arial", Font.BOLD, 15));
		lblDesignation.setBounds(10, 274, 98, 26);
		panel.add(lblDesignation);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBounds(246, 361, 197, 121);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnRemoveUser = new JButton("Remove User");
		btnRemoveUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String sql ="DELETE FROM `logintable` WHERE username= ?";
					
					conn = DriverManager.getConnection("jdbc:mysql://localhost/humanresoursemanagement","root","");
					pst=conn.prepareStatement(sql);
					pst.setString(1,usernametxt.getText());
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null,"User Removed Successfully !");
				}
				catch( SQLException | HeadlessException ex){
					JOptionPane.showMessageDialog(null, "DATABASE ERROR !!");
				}
			}
		});
		btnRemoveUser.setBounds(10, 11, 173, 39);
		panel_1.add(btnRemoveUser);
		btnRemoveUser.setForeground(new Color(0, 128, 0));
		btnRemoveUser.setFont(new Font("Arial", Font.BOLD, 14));
		
		JButton btnClear = new JButton("Clear");
		btnClear.setBounds(10, 61, 173, 39);
		panel_1.add(btnClear);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				usernametxt.setText("");
				passwordtxt.setText("");
			}
		});
		btnClear.setForeground(new Color(0, 128, 0));
		btnClear.setFont(new Font("Arial", Font.BOLD, 14));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_2.setBounds(20, 361, 197, 112);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnAdd = new JButton("Add User");
		btnAdd.setBounds(10, 11, 173, 39);
		panel_2.add(btnAdd);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	      
				try{
					String sql ="INSERT INTO `logintable`( username,password,designation) VALUES (?,?,?)";
					conn = DriverManager.getConnection("jdbc:mysql://localhost/humanresoursemanagement","root","");
					pst=conn.prepareStatement(sql);
					pst.setString(1,usernametxt.getText());
					pst.setString(2,passwordtxt.getText());
					pst.setString(3, designationtxt.getText());
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null,"Registered Successfully");
				}

				catch (Exception ex) {
               	 JOptionPane.showMessageDialog(null,"Database Error!");
                }
			}
		});
		btnAdd.setForeground(new Color(0, 128, 0));
		btnAdd.setFont(new Font("Arial", Font.BOLD, 14));
		
		JButton btnNewButton_1_1 = new JButton("Change Details");
		btnNewButton_1_1.setBounds(10, 61, 169, 39);
		panel_2.add(btnNewButton_1_1);
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				try{
					String sql ="UPDATE `logintable` SET `password`=?,` WHWRE username=?";
					conn = DriverManager.getConnection("jdbc:mysql://localhost/humanresoursemanagement","root","");
					pst=conn.prepareStatement(sql);
					pst.setString(1,passwordtxt.getText());
					pst.setString(2, designationtxt.getText());
					pst.setInt(3, Integer.parseInt(usernametxt.getText()));
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null,"Registered Successfully");
				}

				catch (Exception ex) {
               	 JOptionPane.showMessageDialog(null,ex);
                }
			}
		});
		btnNewButton_1_1.setForeground(new Color(0, 128, 0));
		btnNewButton_1_1.setFont(new Font("Arial", Font.BOLD, 14));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_3.setBounds(161, 11, 327, 311);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		usernametxt = new JTextField();
		usernametxt.setBounds(47, 11, 182, 27);
		panel_3.add(usernametxt);
		usernametxt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {
					conn = DriverManager.getConnection("jdbc:mysql://localhost/humanresoursemanagement","root","");
					String sql = "SELECT * FROM  logintable WHERE username =?";
					PreparedStatement pst =conn.prepareStatement(sql);
					pst.setString(1,usernametxt.getText());
					ResultSet rs=pst.executeQuery();
					while(rs.next()) {
						String setid =rs.getString("username");
						usernametxt.setText(setid);
						
						passwordtxt.setText(rs.getString("password"));
						}
					pst.close();
					}catch( SQLException |HeadlessException ex){
						JOptionPane.showMessageDialog(null, "DATABASE ERROR !!");
				}
			}
		});
		usernametxt.setFont(new Font("Tahoma", Font.BOLD, 13));
		usernametxt.setColumns(10);
		
		passwordtxt = new JTextField();
		passwordtxt.setBounds(47, 124, 182, 26);
		panel_3.add(passwordtxt);
		passwordtxt.setFont(new Font("Tahoma", Font.BOLD, 13));
		passwordtxt.setColumns(10);
		
		designationtxt = new JTextField();
		designationtxt.setFont(new Font("Tahoma", Font.BOLD, 13));
		designationtxt.setColumns(10);
		designationtxt.setBounds(47, 247, 182, 26);
		panel_3.add(designationtxt);

	}





	protected char[] getSelectedItem() {
		// TODO Auto-generated method stub
		return null;
	}
}
