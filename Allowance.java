package resouces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JLayeredPane;
import javax.swing.JTabbedPane;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class Allowance extends JFrame {

	private JPanel contentPane;
	private JTextField amounttxt;
	Connection conn ;
	PreparedStatement pst;
	ResultSet rs ;
	private JTextField employeeidtxt;
	private JTextField amnttxt;
	private JTextField txtamount;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Allowance frame = new Allowance();
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
	public Allowance() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 581, 420);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		tabbedPane.setBounds(10, 33, 561, 376);
		contentPane.add(tabbedPane);
		
		JPanel Allowance = new JPanel();
		Allowance.setBackground(new Color(0, 128, 0));
		tabbedPane.addTab("Allowance", null, Allowance, null);
		tabbedPane.setBackgroundAt(0, new Color(0, 128, 0));
		tabbedPane.setForegroundAt(0, new Color(0, 0, 128));
		Allowance.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Allowance Type");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(36, 58, 107, 27);
		Allowance.add(lblNewLabel);
		
		JComboBox allowancecomboBox = new JComboBox();
		allowancecomboBox.setFont(new Font("Tahoma", Font.BOLD, 15));
		allowancecomboBox.setModel(new DefaultComboBoxModel(new String[] {"Food", "Car", "Bus", "Accomodation", "Clothing"}));
		allowancecomboBox.setBounds(207, 57, 191, 33);
		Allowance.add(allowancecomboBox);
		
		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAmount.setBounds(36, 152, 107, 27);
		Allowance.add(lblAmount);
		
		amounttxt = new JTextField();
		amounttxt.setBounds(207, 152, 191, 27);
		Allowance.add(amounttxt);
		amounttxt.setColumns(10);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String allowancetype =allowancecomboBox.getSelectedItem().toString();
				String amount =amounttxt.getText();
				try {
					String sql ="SELECT Employeeid from employeedetailstable";
					conn = DriverManager.getConnection("jdbc:mysql://localhost/humanresoursemanagement","root","");
					pst=conn.prepareStatement(sql);
					rs=pst.executeQuery();
					
					String empvalue;
					while(rs.next()) {
						
						empvalue = rs.getString("Employeeid");
						
						pst = conn.prepareStatement("insert into allowancetable(allowancetype,amount,Employeeid) values(?,?,?)");
						pst.setString(1,allowancetype);
						pst.setString(2,amount);
						pst.setString(3,empvalue);
						pst.executeUpdate();
						
						
					}
					JOptionPane.showMessageDialog(null,"Allowance Added ");
					
				}catch( SQLException | HeadlessException ex){
					JOptionPane.showMessageDialog(null, ex);
				}
				
				
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAdd.setBounds(22, 267, 116, 38);
		Allowance.add(btnAdd);
		
		JPanel individualpane = new JPanel();
		individualpane.setBackground(new Color(192, 192, 192));
		tabbedPane.addTab("Individual", null, individualpane, null);
		individualpane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Employee ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(25, 32, 107, 25);
		individualpane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("AllowanceType");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(26, 93, 125, 25);
		individualpane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Amount");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_2.setBounds(25, 157, 107, 25);
		individualpane.add(lblNewLabel_1_2);
		
		employeeidtxt = new JTextField();
		employeeidtxt.setBounds(237, 24, 191, 33);
		individualpane.add(employeeidtxt);
		employeeidtxt.setColumns(10);
		
		amnttxt = new JTextField();
		amnttxt.setColumns(10);
		amnttxt.setBounds(237, 155, 191, 33);
		individualpane.add(amnttxt);
		
		JComboBox allowancetypecomboBox = new JComboBox();
		allowancetypecomboBox.setModel(new DefaultComboBoxModel(new String[] {"Food", "Car", "Bus", "Accomodation", "Clothing"}));
		allowancetypecomboBox.setFont(new Font("Tahoma", Font.BOLD, 15));
		allowancetypecomboBox.setBounds(237, 89, 191, 33);
		individualpane.add(allowancetypecomboBox);
		
		JButton btnAdd_1 = new JButton("Add");
		btnAdd_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String allowance =allowancetypecomboBox.getSelectedItem().toString();
				String emp= employeeidtxt.getText();
				String amount =amounttxt.getText();
				try {
					String sql ="insert into allowancetable(allowancetype,amount,Employeeid) values(?,?,?)";
					conn = DriverManager.getConnection("jdbc:mysql://localhost/humanresoursemanagement","root","");
					pst=conn.prepareStatement(sql);
						pst.setString(1,allowance);
						pst.setString(2,amount);
						pst.setString(3, emp);
						pst.executeUpdate();
						
					JOptionPane.showMessageDialog(null,"Allowance Added ");
					
				}catch( SQLException | HeadlessException ex){
					JOptionPane.showMessageDialog(null, ex);
				}

				
			}
		});
		btnAdd_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAdd_1.setBounds(45, 247, 116, 38);
		individualpane.add(btnAdd_1);
		
		JPanel departmentpane = new JPanel();
		departmentpane.setBackground(new Color(0, 128, 0));
		tabbedPane.addTab("Department", null, departmentpane, null);
		departmentpane.setLayout(null);
		
		JLabel lblDepartment = new JLabel("Department");
		lblDepartment.setBounds(30, 27, 107, 17);
		lblDepartment.setFont(new Font("Tahoma", Font.BOLD, 14));
		departmentpane.add(lblDepartment);
		
		JLabel lblNewLabel_2_1 = new JLabel("Allowance Type");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_1.setBounds(30, 99, 107, 17);
		departmentpane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Amount");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_2.setBounds(30, 176, 88, 17);
		departmentpane.add(lblNewLabel_2_2);
		
		JComboBox atcomboBox = new JComboBox();
		atcomboBox.setModel(new DefaultComboBoxModel(new String[] {"Food", "Car", "Bus", "Accomodation", "Clothing"}));
		atcomboBox.setFont(new Font("Tahoma", Font.BOLD, 15));
		atcomboBox.setBounds(214, 81, 191, 33);
		departmentpane.add(atcomboBox);
		
		txtamount = new JTextField();
		txtamount.setColumns(10);
		txtamount.setBounds(214, 161, 191, 33);
		departmentpane.add(txtamount);
		
		JComboBox dptcomboBox = new JComboBox();
		dptcomboBox.setModel(new DefaultComboBoxModel(new String[] {"Infomation and Technology(IT)", "Human Resource(HR)", "Accounting", "Cleaners", "Mechanics", "Markerting", "Adminstration"}));
		dptcomboBox.setFont(new Font("Tahoma", Font.BOLD, 15));
		dptcomboBox.setBounds(214, 11, 191, 33);
		departmentpane.add(dptcomboBox);
		
		JButton btnAdd_1_1 = new JButton("Add");
		btnAdd_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String sql ="select Distinct department from employeedetailstable";
					conn = DriverManager.getConnection("jdbc:mysql://localhost/humanresoursemanagement","root","");
					pst=conn.prepareStatement(sql);
					ResultSet rs = pst.executeQuery();
				
				dptcomboBox.removeAllItems();
				while(rs.next()) {
					dptcomboBox.addItem(rs.getString(1));
				}
					
				}
				catch( SQLException | HeadlessException ex){
					JOptionPane.showMessageDialog(null, ex);
				}
				String allowancetype =atcomboBox.getSelectedItem().toString();
				String dpt =dptcomboBox.getSelectedItem().toString();
				String amount =txtamount.getText();
				try {
					String sql ="SELECT Employeeid from employeedetailstable where department = ?";
					conn = DriverManager.getConnection("jdbc:mysql://localhost/humanresoursemanagement","root","");
					pst=conn.prepareStatement(sql);
					pst.setString(1, dpt);
					rs=pst.executeQuery();
					
					String empvalue;
					while(rs.next()) {
						
						empvalue = rs.getString("Employeeid");
						
						pst = conn.prepareStatement("insert into allowancetable(allowancetype,amount,Employeeid) values(?,?,?)");
						pst.setString(1,allowancetype);
						pst.setString(2,amount);
						pst.setString(3,empvalue);
						pst.executeUpdate();
						
						
					}
					JOptionPane.showMessageDialog(null,"Allowance Added ");
					
				}catch( SQLException | HeadlessException ex){
					JOptionPane.showMessageDialog(null, ex);
				}
				
				
			
			}
		});
		btnAdd_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAdd_1_1.setBounds(30, 275, 116, 38);
		departmentpane.add(btnAdd_1_1);
		tabbedPane.setForegroundAt(2, new Color(0, 206, 209));
		tabbedPane.setBackgroundAt(2, new Color(60, 179, 113));
		
		JLabel lblexit = new JLabel("X");
		lblexit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null,"Are you sure you want to close Allowances","Confirmation",JOptionPane.YES_NO_OPTION)==0) {
					Allowance.this.dispose();
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblexit.setForeground(Color.RED);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				lblexit.setForeground(Color.WHITE);
			}
		});
		lblexit.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblexit.setBounds(561, 0, 20, 22);
		contentPane.add(lblexit);
		setUndecorated(true);
	}
}
