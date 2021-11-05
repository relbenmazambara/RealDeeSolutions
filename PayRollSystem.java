package resouces;

import javax.swing.JPanel;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JCheckBox;
import javax.swing.JSpinner;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JComboBox;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//import resouces.Allowace;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

public class PayRollSystem extends JPanel {
	private JTextField employeeidtxt;
	private JTextField nametxt;
	private JTextField salarytxt;
	private JTextField payasyouearntxt;
	private JTextField aidsleavetxt;
	
	//private Allowace allowance;
	private JTextField surnametxt;
	private JTextField pensiontxt;
	Connection conn ;
	PreparedStatement pst;
	ResultSet rs ;
	private JTextField txtnetsalary;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public PayRollSystem() {
		setBounds(0,0,690,527);
		setLayout(null);
		
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(240, 255, 240));
		separator.setBounds(20, 52, 532, 8);
		add(separator);
		
		JPanel payrollPanell = new JPanel();
		payrollPanell.setBackground(new Color(0, 128, 128));
		payrollPanell.setBounds(20, 62, 554, 454);
		add(payrollPanell);
		payrollPanell.setLayout(null);
		
	
		
		JLabel lblNewLabel = new JLabel("Employee ID");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel.setBounds(10, 12, 99, 24);
		payrollPanell.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1.setBounds(10, 77, 99, 14);
		payrollPanell.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Salary");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_2.setBounds(10, 158, 46, 14);
		payrollPanell.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Pay As You Earn");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_3.setBounds(10, 191, 111, 24);
		payrollPanell.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Aids Leave");
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_4.setBounds(10, 229, 99, 24);
		payrollPanell.add(lblNewLabel_4);
		
		employeeidtxt = new JTextField();
		employeeidtxt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {
					conn = DriverManager.getConnection("jdbc:mysql://localhost/humanresoursemanagement","root","");
					String sql = "SELECT * FROM  employeedetailstable WHERE Employeeid =?";
					PreparedStatement pst =conn.prepareStatement(sql);
					pst.setString(1,employeeidtxt.getText());
					ResultSet rs=pst.executeQuery();
					while(rs.next()) {
						String setid =rs.getString("Employeeid");
				employeeidtxt.setText(setid);
						
						nametxt.setText(rs.getString("Name"));
						surnametxt.setText(rs.getString("Surname"));
						}
					pst.close();
					}catch( SQLException |HeadlessException ex){
						JOptionPane.showMessageDialog(null, "DATABASE ERROR !!");
					}
				
			}
		});
		employeeidtxt.setFont(new Font("Arial", Font.BOLD, 13));
		employeeidtxt.setBounds(339, 11, 176, 27);
		payrollPanell.add(employeeidtxt);
		employeeidtxt.setColumns(10);
		
		nametxt = new JTextField();
		nametxt.setFont(new Font("Arial", Font.BOLD, 13));
		nametxt.setBounds(339, 68, 176, 33);
		payrollPanell.add(nametxt);
		nametxt.setColumns(10);
		
		salarytxt = new JTextField();
		salarytxt.setFont(new Font("Arial", Font.BOLD, 13));
		salarytxt.setBounds(339, 152, 176, 27);
		payrollPanell.add(salarytxt);
		salarytxt.setColumns(10);
		
		payasyouearntxt = new JTextField();
		payasyouearntxt.setText("0.09");
		payasyouearntxt.setFont(new Font("Arial", Font.BOLD, 13));
		payasyouearntxt.setBounds(339, 190, 176, 27);
		payrollPanell.add(payasyouearntxt);
		payasyouearntxt.setColumns(10);
		
		aidsleavetxt = new JTextField();
		aidsleavetxt.setText("0.05");
		aidsleavetxt.setFont(new Font("Arial", Font.BOLD, 13));
		aidsleavetxt.setBounds(339, 228, 176, 27);
		payrollPanell.add(aidsleavetxt);
		aidsleavetxt.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("Surname");
		lblNewLabel_2_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_2_1.setBounds(10, 120, 82, 14);
		payrollPanell.add(lblNewLabel_2_1);
		
		surnametxt = new JTextField();
		surnametxt.setFont(new Font("Arial", Font.BOLD, 13));
		surnametxt.setColumns(10);
		surnametxt.setBounds(339, 112, 176, 33);
		payrollPanell.add(surnametxt);
		
		pensiontxt = new JTextField();
		 pensiontxt.setText("0.1");
		pensiontxt.setFont(new Font("Arial", Font.BOLD, 13));
		pensiontxt.setColumns(10);
		pensiontxt.setBounds(339, 268, 176, 33);
		payrollPanell.add(pensiontxt);
		
		JLabel lblNewLabel_4_1 = new JLabel("Pension");
		lblNewLabel_4_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_4_1.setBounds(10, 272, 99, 24);
		payrollPanell.add(lblNewLabel_4_1);
		
		txtnetsalary = new JTextField();
		
		txtnetsalary.setFont(new Font("Arial", Font.BOLD, 13));
		txtnetsalary.setColumns(10);
		txtnetsalary.setBounds(339, 341, 176, 33);
		payrollPanell.add(txtnetsalary);
		
		JPanel panel = new JPanel();
		panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(10, 385, 509, 58);
		payrollPanell.add(panel);
		panel.setLayout(null);
		
		JButton btnAllowance = new JButton("Add Allowance");
		btnAllowance.setBounds(10, 11, 142, 33);
		panel.add(btnAllowance);
		btnAllowance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			 Allowance a = new Allowance();
			a.setVisible(true);
			}
		});
		btnAllowance.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JButton btnExecute = new JButton("Execute");
		btnExecute.setBounds(406, 11, 93, 33);
		panel.add(btnExecute);
		btnExecute.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String sql ="INSERT INTO `payrolltable`(`Employeeid`, `Name`, `surname`, `Salary`, `netsalary`) VALUES (?,?,?,?,?)";
					conn = DriverManager.getConnection("jdbc:mysql://localhost/humanresoursemanagement","root","");
					pst=conn.prepareStatement(sql);
					pst.setString(1,employeeidtxt.getText());
					pst.setString(2,nametxt.getText());
					pst.setString(3,surnametxt.getText());
					pst.setString(4,salarytxt.getText());
					pst.setString(5,txtnetsalary.getText());
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null,"Payment Made Successfully !");
				}

				catch (Exception ex) {
               	 JOptionPane.showMessageDialog(null,ex);
                }
			}
		});
		btnExecute.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JButton btnClear = new JButton("Clear");
		btnClear.setBounds(308, 11, 88, 34);
		panel.add(btnClear);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salarytxt.setText("");
				txtnetsalary.setText("");
				employeeidtxt.setText("");
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JButton btnnetsalary = new JButton("Net Salary");
		btnnetsalary.setBounds(170, 11, 128, 32);
		panel.add(btnnetsalary);
		btnnetsalary.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double netsalary;
				double payAsYouEarn;
				double aidsleave;
				double pension;
				double salary;
				payAsYouEarn =Double.parseDouble(payasyouearntxt.getText());
				aidsleave =Double.parseDouble(aidsleavetxt.getText());
				pension =Double.parseDouble(pensiontxt.getText());
				salary =Double.parseDouble(salarytxt.getText());
				netsalary =salary *(payAsYouEarn+aidsleave+pension);
				txtnetsalary.setText(Double.toString(netsalary));
			}
		});
		btnnetsalary.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblNewLabel_4_1_1 = new JLabel("NetSalary");
		lblNewLabel_4_1_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_4_1_1.setBounds(10, 345, 99, 24);
		payrollPanell.add(lblNewLabel_4_1_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.BOLD, 13));
		textField.setColumns(10);
		textField.setBounds(339, 307, 176, 27);
		payrollPanell.add(textField);
		
		JLabel lblNewLabel_5 = new JLabel("Total hours");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_5.setBounds(10, 307, 82, 24);
		payrollPanell.add(lblNewLabel_5);
		
		JLabel lblNewLabel_9 = new JLabel("Employee PayRoll");
		lblNewLabel_9.setForeground(new Color(0, 0, 128));
		lblNewLabel_9.setBackground(new Color(0, 0, 128));
		lblNewLabel_9.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_9.setBounds(20, 11, 178, 30);
		add(lblNewLabel_9);
		
		JButton btnReport = new JButton("Report");
		btnReport.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnReport.setBounds(558, 0, 108, 33);
		add(btnReport);
	}
}
