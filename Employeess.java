package resouces;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import java.sql.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseEvent;
import java.io.File;
import java.awt.event.MouseAdapter;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

;

public class Employeess extends JPanel {
	private JTextField nametxt;
	private JTextField reference1txt;
	private JTextField phonetxt;
	private JTextField Addresstxt;
	private JTextField nationalitytxt;
	/**
	 * @wbp.nonvisual location=273,-31
	 */
	private final JTextField textField = new JTextField();
	private JTextField surnametxt;
	private JTextField reference2txt;
	private JTextField accountnumbertxt;
	private JTextField banknametxtt;
	private JTextField banknametxt;
	
	
	Connection conn ;
	PreparedStatement pst;
	ResultSet rs ;
	private JTextField dobtxtt;
	private JTextField txtemployeeid;
	private JTextField parthtxt;
	private JTextField jdatetxt;
	
	/**
	 * Create the panel.
	 */
	public Employeess() {
		setForeground(new Color(0, 0, 139));
		textField.setColumns(10);
		setBounds(0,0,690,527);
		setLayout(null);
		
		JPanel personaldetailspanel = new JPanel();
		personaldetailspanel.setBorder(UIManager.getBorder("InternalFrame.border"));
		personaldetailspanel.setBounds(10, 72, 372, 359);
		add(personaldetailspanel);
		personaldetailspanel.setLayout(null);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Arial", Font.BOLD, 15));
		lblName.setBounds(10, 10, 132, 24);
		personaldetailspanel.add(lblName);
		
		JLabel lblSurname = new JLabel("Surname:");
		lblSurname.setFont(new Font("Arial", Font.BOLD, 15));
		lblSurname.setBounds(10, 45, 92, 24);
		personaldetailspanel.add(lblSurname);
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth:");
		lblDateOfBirth.setFont(new Font("Arial", Font.BOLD, 15));
		lblDateOfBirth.setBounds(10, 65, 94, 24);
		personaldetailspanel.add(lblDateOfBirth);
		
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setFont(new Font("Arial", Font.BOLD, 15));
		lblGender.setBounds(10, 94, 132, 24);
		personaldetailspanel.add(lblGender);
		
		JLabel lblPhone = new JLabel("Phone:");
		lblPhone.setFont(new Font("Arial", Font.BOLD, 15));
		lblPhone.setBounds(10, 129, 132, 24);
		personaldetailspanel.add(lblPhone);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setFont(new Font("Arial", Font.BOLD, 15));
		lblAddress.setBounds(10, 196, 132, 24);
		personaldetailspanel.add(lblAddress);
		
		JLabel lblNationality = new JLabel("Nationality:");
		lblNationality.setBounds(10, 161, 132, 24);
		personaldetailspanel.add(lblNationality);
		lblNationality.setFont(new Font("Arial", Font.BOLD, 15));
		
		JLabel lblReference = new JLabel("Reference 1:");
		lblReference.setFont(new Font("Arial", Font.BOLD, 15));
		lblReference.setBounds(10, 231, 132, 24);
		personaldetailspanel.add(lblReference);
		
		JLabel lblReference_1 = new JLabel("Reference 2:");
		lblReference_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblReference_1.setBounds(10, 270, 132, 24);
		personaldetailspanel.add(lblReference_1);
		
		JLabel lblMaritalStatus = new JLabel("Marital Status:");
		lblMaritalStatus.setFont(new Font("Arial", Font.BOLD, 15));
		lblMaritalStatus.setBounds(10, 294, 132, 24);
		personaldetailspanel.add(lblMaritalStatus);
		
		nametxt = new JTextField();
		nametxt.setBounds(152, 11, 201, 24);
		personaldetailspanel.add(nametxt);
		nametxt.setColumns(10);
		
		reference1txt = new JTextField();
		reference1txt.setColumns(10);
		reference1txt.setBounds(152, 232, 201, 24);
		personaldetailspanel.add(reference1txt);
		
		phonetxt = new JTextField();
		phonetxt.setColumns(10);
		phonetxt.setBounds(152, 129, 201, 24);
		personaldetailspanel.add(phonetxt);
		
		Addresstxt = new JTextField();
		Addresstxt.setColumns(10);
		Addresstxt.setBounds(152, 197, 201, 24);
		personaldetailspanel.add(Addresstxt);
		
		nationalitytxt = new JTextField();
		nationalitytxt.setBounds(152, 162, 201, 24);
		personaldetailspanel.add(nationalitytxt);
		nationalitytxt.setColumns(10);
		
		surnametxt = new JTextField();
		surnametxt.setColumns(10);
		surnametxt.setBounds(152, 40, 201, 24);
		personaldetailspanel.add(surnametxt);
		
		reference2txt = new JTextField();
		reference2txt.setBounds(152, 271, 201, 24);
		personaldetailspanel.add(reference2txt);
		reference2txt.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 419, 288, 120);
		personaldetailspanel.add(panel);
		
		JComboBox maritalstatuscomboBox = new JComboBox();
		maritalstatuscomboBox.setModel(new DefaultComboBoxModel(new String[] {"Single", "Married"}));
		maritalstatuscomboBox.setFont(new Font("Tahoma", Font.BOLD, 12));
		maritalstatuscomboBox.setBounds(152, 300, 201, 24);
		personaldetailspanel.add(maritalstatuscomboBox);
		
		JComboBox gendercomboBox = new JComboBox();
		gendercomboBox.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		gendercomboBox.setFont(new Font("Tahoma", Font.BOLD, 12));
		gendercomboBox.setBounds(152, 95, 201, 22);
		personaldetailspanel.add(gendercomboBox);
		
		
		
		JLabel employeeidtxt = new JLabel("");
		//ytAutoID();
		employeeidtxt.setForeground(new Color(0, 0, 255));
		employeeidtxt.setFont(new Font("Arial", Font.BOLD, 15));
		employeeidtxt.setBounds(151, 369, 137, 24);
		personaldetailspanel.add(employeeidtxt);
		
		dobtxtt = new JTextField();
		dobtxtt.setFont(new Font("Tahoma", Font.BOLD, 12));
		dobtxtt.setBounds(184, 68, 169, 24);
		personaldetailspanel.add(dobtxtt);
		dobtxtt.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("yyyy-mm-dd");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(105, 71, 81, 18);
		personaldetailspanel.add(lblNewLabel);
		
		JLabel lblEmployeeID = new JLabel("Emloyee ID");
		lblEmployeeID.setFont(new Font("Arial", Font.BOLD, 15));
		lblEmployeeID.setBounds(10, 324, 92, 24);
		personaldetailspanel.add(lblEmployeeID);
	//SELECTING EMPLOYEE DETAILS	
		txtemployeeid = new JTextField();
		
		txtemployeeid.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String image = parthtxt.getText();
				image =image.replace("\\","\\\\");
			try {
				conn = DriverManager.getConnection("jdbc:mysql://localhost/humanresoursemanagement","root","");
				String sql = "SELECT * FROM  employeedetailstable WHERE Employeeid =?";
				PreparedStatement pst =conn.prepareStatement(sql);
				pst.setString(1,txtemployeeid.getText());
				ResultSet rs=pst.executeQuery();
				while(rs.next()) {
					String setid =rs.getString("Employeeid");
					txtemployeeid.setText(setid);
					
					nametxt.setText(rs.getString("Name"));
					surnametxt.setText(rs.getString("Surname"));
					dobtxtt.setText(rs.getString("dob"));
					phonetxt.setText(rs.getString("Phone"));
					nationalitytxt.setText(rs.getString("Nationality"));
					Addresstxt.setText(rs.getString("Address"));
					reference1txt.setText(rs.getString("Reference1"));
					reference2txt.setText(rs.getString("Reference2"));
					banknametxtt.setText(rs.getString("bankname"));
					accountnumbertxt.setText(rs.getString("accountnumber"));
					jdatetxt.setText(rs.getString("JoiningDate"));
					parthtxt.setText(rs.getString("image"));
					//byte[] img =(userList().get(i).getImage());
					//Image image = icon.getImage().getScaledInstance(lblimage.getWidth(),lblimage.getHeight(),Image.SCALE_SMOOTH);
				//	lblimage.setIcon(icon);
					
					
				}
				pst.close();
				}catch( SQLException |HeadlessException ex){
					JOptionPane.showMessageDialog(null, "DATABASE ERROR !!");
				}
			}
		});
		txtemployeeid.setFont(new Font("Times New Roman", Font.BOLD, 14));
		txtemployeeid.setBounds(152, 329, 201, 24);
		personaldetailspanel.add(txtemployeeid);
		txtemployeeid.setColumns(10);
		
		JPanel companydetailspanel = new JPanel();
		companydetailspanel.setBorder(UIManager.getBorder("InternalFrame.border"));
		companydetailspanel.setBounds(392, 72, 288, 304);
		add(companydetailspanel);
		companydetailspanel.setLayout(null);
		
		JLabel lbldepartment = new JLabel("Department");
		lbldepartment.setFont(new Font("Arial", Font.BOLD, 15));
		lbldepartment.setBounds(10, 40, 102, 37);
		companydetailspanel.add(lbldepartment);
		
		JComboBox departmentcomboBox = new JComboBox();
		departmentcomboBox.setModel(new DefaultComboBoxModel(new String[] {"Infomation and Technology(IT)", "Human Resource(HR)", "Accounting", "Cleaners", "Mechanics", "Markerting", "Adminstration"}));
		departmentcomboBox.setFont(new Font("Tahoma", Font.BOLD, 12));
		departmentcomboBox.setBounds(122, 48, 156, 22);
		companydetailspanel.add(departmentcomboBox);
		
		
		
		JLabel lbldesignation = new JLabel("Designation:");
		lbldesignation.setBounds(10, 11, 97, 24);
		companydetailspanel.add(lbldesignation);
		lbldesignation.setFont(new Font("Arial", Font.BOLD, 15));
		
		JComboBox designationcomboBox = new JComboBox();
		designationcomboBox.setBounds(122, 12, 160, 22);
		companydetailspanel.add(designationcomboBox);
		designationcomboBox.setModel(new DefaultComboBoxModel(new String[] {"Admin", "Manager", "Director", "Senior", "Worker", "General Worker"}));
		designationcomboBox.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblimage = new JLabel("");
		lblimage.setForeground(new Color(0, 0, 0));
		lblimage.setBackground(new Color(0, 0, 0));
		lblimage.setBounds(41, 71, 215, 123);
		companydetailspanel.add(lblimage);
		
		parthtxt = new JTextField();
		parthtxt.setFont(new Font("Tahoma", Font.BOLD, 12));
		parthtxt.setBounds(10, 205, 156, 22);
		companydetailspanel.add(parthtxt);
		parthtxt.setColumns(10);
		//ADDING IMAGE
		JButton btnimage = new JButton("Attach Image");
		btnimage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				chooser.showOpenDialog(null);
				File f = chooser.getSelectedFile();
				String fileName = f.getAbsolutePath();
				parthtxt.setText(fileName);
				Image getAbsolutePath=null;
				ImageIcon icon = new ImageIcon(fileName);
				Image image = icon.getImage().getScaledInstance(lblimage.getWidth(),lblimage.getHeight(),Image.SCALE_SMOOTH);
				lblimage.setIcon(icon);
			}
		});
		btnimage.setFont(new Font("Arial", Font.BOLD, 11));
		btnimage.setBounds(176, 205, 106, 23);
		companydetailspanel.add(btnimage);
		
		JLabel lblJoiningdate = new JLabel("JoiningDate");
		lblJoiningdate.setFont(new Font("Arial", Font.BOLD, 15));
		lblJoiningdate.setBounds(10, 251, 102, 24);
		companydetailspanel.add(lblJoiningdate);
		
		jdatetxt = new JTextField();
		jdatetxt.setFont(new Font("Tahoma", Font.BOLD, 12));
		jdatetxt.setColumns(10);
		jdatetxt.setBounds(122, 252, 156, 24);
		companydetailspanel.add(jdatetxt);
		
		JLabel lblPesonalDetails = new JLabel("Pesonal Details");
		lblPesonalDetails.setBounds(122, 48, 152, 29);
		add(lblPesonalDetails);
		lblPesonalDetails.setFont(new Font("Arial", Font.BOLD, 15));
		
		JPanel bankaccountdetailspanel = new JPanel();
		bankaccountdetailspanel.setBounds(316, 432, 364, 84);
		add(bankaccountdetailspanel);
		bankaccountdetailspanel.setBorder(UIManager.getBorder("InternalFrame.border"));
		bankaccountdetailspanel.setLayout(null);
		
		JLabel lblBankName = new JLabel("Bank Name");
		lblBankName.setBounds(10, 11, 119, 28);
		bankaccountdetailspanel.add(lblBankName);
		lblBankName.setFont(new Font("Arial", Font.BOLD, 15));
		
		JLabel lblaccountnumber = new JLabel("Account Number:");
		lblaccountnumber.setBounds(10, 50, 131, 28);
		bankaccountdetailspanel.add(lblaccountnumber);
		lblaccountnumber.setFont(new Font("Arial", Font.BOLD, 15));
		
		JLabel lblbankname = new JLabel("Bank Name:");
		lblbankname.setBounds(20, 122, 109, 28);
		bankaccountdetailspanel.add(lblbankname);
		lblbankname.setFont(new Font("Arial", Font.BOLD, 15));
		
		accountnumbertxt = new JTextField();
		accountnumbertxt.setBounds(172, 51, 182, 28);
		bankaccountdetailspanel.add(accountnumbertxt);
		accountnumbertxt.setColumns(10);
		
		banknametxt = new JTextField();
		banknametxt.setBounds(144, 122, 202, 27);
		bankaccountdetailspanel.add(banknametxt);
		banknametxt.setColumns(10);
		
		banknametxtt = new JTextField();
		banknametxtt.setBounds(172, 12, 182, 28);
		bankaccountdetailspanel.add(banknametxtt);
		banknametxtt.setColumns(10);
		
		JLabel lblbankaccountdetails = new JLabel("Bank Account Details");
		lblbankaccountdetails.setBounds(436, 387, 202, 28);
		add(lblbankaccountdetails);
		lblbankaccountdetails.setFont(new Font("Arial", Font.BOLD, 15));
		
		JLabel lblcompanydetails = new JLabel("Company Details");
		lblcompanydetails.setBounds(460, 44, 153, 37);
		add(lblcompanydetails);
		lblcompanydetails.setFont(new Font("Arial", Font.BOLD, 15));
		
		JButton btnAddEmployee = new JButton("Add Employee");
		btnAddEmployee.setForeground(new Color(165, 42, 42));
		btnAddEmployee.setBackground(new Color(0, 0, 255));
		btnAddEmployee.setFont(new Font("Arial", Font.BOLD, 15));
		btnAddEmployee.setBounds(10, 11, 149, 37);
		add(btnAddEmployee);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBounds(10, 438, 296, 78);
		add(panel_1);
		panel_1.setLayout(null);
		//UPDATING EMPLOYESS DETAILS
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Gender=String.valueOf(gendercomboBox.getSelectedItem());
				String Maritalstatus = String.valueOf(maritalstatuscomboBox.getSelectedItem());
				String designation = String.valueOf(designationcomboBox.getSelectedItem());
				String department = String.valueOf(departmentcomboBox.getSelectedItem());
				String image = parthtxt.getText();
				image =image.replace("\\","\\\\");
             try {
					
					String sql ="UPDATE `employeedetailstable` SET  Name=?, Surname=?, dob=?, Gender=?, Phone=?, Nationality=?, Address=?, reference1=?, reference2=?, maritalstatus=?, Designation=?,  department=?, bankname=?, accountnumber=?,image=? WHERE Employeeid= ?";			
					conn = DriverManager.getConnection("jdbc:mysql://localhost/humanresoursemanagement","root","");
					pst=conn.prepareStatement(sql);
					pst.setString(1, nametxt.getText());
					pst.setString(2, surnametxt.getText());
					pst.setString(3, dobtxtt.getText());
					pst.setString(4, Gender);
					pst.setString(5,phonetxt.getText());
					pst.setString(6, nationalitytxt.getText());
					pst.setString(7, Addresstxt.getText());
					pst.setString(8, reference1txt.getText());
					pst.setString(9, reference2txt.getText());
					pst.setString(10, Maritalstatus);
					pst.setString(11, designation);
					pst.setString(12,department);
					pst.setString(13, banknametxtt.getText());
					pst.setString(14,accountnumbertxt.getText());
					pst.setString(15,image);
					pst.setInt(16, Integer.parseInt(txtemployeeid.getText()));
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null,"Employee Updated Successfully");
					
				}
				catch( SQLException | HeadlessException ex){
					JOptionPane.showMessageDialog(null, "DATABASE ERROR !!");
				}
			
				
				
			}
		});
		btnUpdate.setForeground(new Color(128, 0, 0));
		btnUpdate.setBackground(new Color(0, 0, 139));
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnUpdate.setBounds(10, 21, 96, 30);
		panel_1.add(btnUpdate);
	//CLEAR BUTTON
		JButton btnSelect = new JButton("Clear");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nametxt.setText("");
				surnametxt.setText("");
				dobtxtt.setText("");
				phonetxt.setText("");
				nationalitytxt.setText("");
				Addresstxt.setText("");
				reference1txt.setText("");
				reference2txt.setText("");
				banknametxtt.setText("");
				accountnumbertxt.setText("");
				parthtxt.setText("");
				txtemployeeid.setText("");
				
			}
		});
		btnSelect.setForeground(new Color(128, 0, 0));
		btnSelect.setBackground(new Color(0, 0, 128));
		btnSelect.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSelect.setBounds(206, 21, 80, 29);
		panel_1.add(btnSelect);
		//DELETE BUTTON
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				String sql ="DELETE FROM `employeedetailstable` WHERE Employeeid= ?";
				
				conn = DriverManager.getConnection("jdbc:mysql://localhost/humanresoursemanagement","root","");
				pst=conn.prepareStatement(sql);
				pst.setString(1, txtemployeeid.getText());
				pst.executeUpdate();
				JOptionPane.showMessageDialog(null,"Employee Deleted Successfully !");
			}
			catch( SQLException | HeadlessException ex){
				JOptionPane.showMessageDialog(null, "DATABASE ERROR !!");
			}
			}
		});
		btnDelete.setForeground(new Color(128, 0, 0));
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDelete.setBackground(new Color(0, 0, 139));
		btnDelete.setBounds(116, 21, 86, 30);
		panel_1.add(btnDelete);
		btnAddEmployee.addActionListener(new ActionListener() {
			//ADDING EMPLOYEES
			public void actionPerformed(ActionEvent e) {
				String Gender=String.valueOf(gendercomboBox.getSelectedItem());
				String Maritalstatus = String.valueOf(maritalstatuscomboBox.getSelectedItem());
				String designation = String.valueOf(designationcomboBox.getSelectedItem());
				String department = String.valueOf(departmentcomboBox.getSelectedItem());
				String image = parthtxt.getText();
				image =image.replace("\\","\\\\");
				
				try {
					
					String sql ="INSERT INTO `employeedetailstable`(Name, Surname, dob, Gender, Phone, Nationality, Address, reference1, reference2, maritalstatus, Designation,  department, bankname, accountnumber,image) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
					
					conn = DriverManager.getConnection("jdbc:mysql://localhost/humanresoursemanagement","root","");
					pst=conn.prepareStatement(sql);
					pst.setString(1, nametxt.getText());
					pst.setString(2, surnametxt.getText());
					pst.setString(3, dobtxtt.getText());
					pst.setString(4, Gender);
					pst.setString(5,phonetxt.getText());
					pst.setString(6, nationalitytxt.getText());
					pst.setString(7, Addresstxt.getText());
					pst.setString(8, reference1txt.getText());
					pst.setString(9, reference2txt.getText());
					pst.setString(10, Maritalstatus);
					pst.setString(11, designation);
					pst.setString(12,department);
					pst.setString(13, banknametxt.getText());
					pst.setString(14,accountnumbertxt.getText());
					pst.setString(15,image);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null,"Employee Added Successfully");
					
				}
				catch( SQLException | HeadlessException ex){
					JOptionPane.showMessageDialog(null, "DATABASE ERROR !!");
				}
			
				
				
			}
		});
	}
}
