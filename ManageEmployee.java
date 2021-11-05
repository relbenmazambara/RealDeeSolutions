package resouces;

import javax.swing.JPanel;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JSlider;

public class ManageEmployee extends JPanel {
	private JTextField searchtxt;
	Connection conn ;
	PreparedStatement pst;
	ResultSet rs ;
	DefaultTableModel model = new DefaultTableModel();
	private JTable table;
	private JTextField rowstxt;
	/**
	 * Create the panel.
	 */
	
	
	
	public ManageEmployee() {
		setBounds(0,0,690,527);
		setLayout(null);
		
		JPanel lblPanel = new JPanel();
		lblPanel.setBackground(new Color(47, 79, 79));
		lblPanel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lblPanel.setBounds(10, 65, 670, 76);
		add(lblPanel);
		lblPanel.setLayout(null);
		
		JLabel lblEntries = new JLabel("Entries");
		lblEntries.setFont(new Font("Arial", Font.BOLD, 12));
		lblEntries.setBounds(156, 31, 46, 14);
		lblPanel.add(lblEntries);
		
		JLabel lblSearch = new JLabel("Search");
		lblSearch.setFont(new Font("Arial", Font.BOLD, 12));
		lblSearch.setBounds(463, 11, 70, 23);
		lblPanel.add(lblSearch);
		
		searchtxt = new JTextField();
		searchtxt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String str = null;
					DefaultTableModel model =(DefaultTableModel) table.getModel();
					TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
					table.setRowSorter(trs);
					trs.setRowFilter(RowFilter.regexFilter(str));
					String searchString =searchtxt.getText();
			}
		});
		searchtxt.setFont(new Font("Tahoma", Font.BOLD, 11));
		searchtxt.setBounds(473, 38, 187, 27);
		lblPanel.add(searchtxt);
		searchtxt.setColumns(10);
		
		JButton btnrows = new JButton("Shows");
		btnrows.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				String sql ="SELECT count(Name) from employeedetailstable";
				conn = DriverManager.getConnection("jdbc:mysql://localhost/humanresoursemanagement","root","");
				pst=conn.prepareStatement(sql);
				rs=pst.executeQuery();
				if(rs.next()) {
					String sum= rs.getString("count(Name)");
					rowstxt.setText(sum);
				}
				
				}
				catch( SQLException | HeadlessException ex){
					JOptionPane.showMessageDialog(null, "DATABASE ERROR !!");
				}
			}
		});
		btnrows.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnrows.setBounds(10, 25, 82, 25);
		lblPanel.add(btnrows);
		
		rowstxt = new JTextField();
		rowstxt.setForeground(new Color(255, 0, 0));
		rowstxt.setFont(new Font("Tahoma", Font.BOLD, 16));
		rowstxt.setBounds(95, 27, 53, 23);
		lblPanel.add(rowstxt);
		rowstxt.setColumns(10);
		//CREATING REPORT BUTTON
		  	JButton btnNewButton = new JButton("Create Report");
		btnNewButton.addActionListener(new ActionListener() {
			private JasperPrint jprint;
			public void actionPerformed(ActionEvent e) {
				try{
					String sql ="SELECT `Employeeid`, `Name`, `Surname`,  `Gender`, `Phone`, `Address`, `Designation`,  `department` FROM `employeedetailstable` ";
					conn = DriverManager.getConnection("jdbc:mysql://localhost/humanresoursemanagement","root","");
					JasperDesign jdesign = JRXmlLoader.load("C:\\Users\\real de\\Desktop\\ECLIPSE PROJECTS\\HUMAN RESOUCE MANAGEMENT SYSTEM\\manageemployee.jrxml");
					JRDesignQuery updateQuery =new JRDesignQuery();
					updateQuery.setText(sql);
					jdesign.setQuery(updateQuery);
					JasperReport Jreport = JasperCompileManager.compileReport(jdesign);
					JasperPrint JasperPrint = JasperFillManager.fillReport(Jreport, null,conn);
					JasperViewer.viewReport(JasperPrint, false);
				
					}

				catch( Exception e2){
					JOptionPane.showMessageDialog(null, e2);
				}
				
		}
			
		});
		btnNewButton.setForeground(new Color(0, 0, 128));
		btnNewButton.setBackground(new Color(0, 0, 205));
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 13));
		btnNewButton.setBounds(552, 25, 128, 38);
		add(btnNewButton);
		//SELECTING EMPLOYEE DETAILS FROM THE DATABSE
		JButton btnNewButton_1 = new JButton("ManageEmployees");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{
					String sql ="SELECT * FROM employeedetailstable";
					conn = DriverManager.getConnection("jdbc:mysql://localhost/humanresoursemanagement","root","");
					PreparedStatement pst = conn.prepareStatement(sql);
					ResultSet rs = pst.executeQuery();
					DefaultTableModel model =(DefaultTableModel) table.getModel();
					while(rs.next()) {
						model.addRow(new String[] {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),rs.getString(14),rs.getString(15),rs.getString(16)});
					}
					
				}
				catch( SQLException | HeadlessException ex){
					JOptionPane.showMessageDialog(null, ex);
				}
				
		
				
				
			}
		});
			
		
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 19));
		btnNewButton_1.setBounds(10, 11, 209, 43);
		add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 152, 670, 364);
		add(scrollPane);
		//CREATING A TABLE
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Employeeid", "Name", "Surname", "dob", "Gender", "Phone", "Nationality", "Address", "Reference1", "Reference2", "maritalstatus", "Desigination", "JoiningDate", "department", "bankname", "accountnumber"
			}
		));
		table.getColumnModel().getColumn(0).setMinWidth(86);
		table.getColumnModel().getColumn(1).setPreferredWidth(118);
		table.getColumnModel().getColumn(1).setMinWidth(107);
		table.getColumnModel().getColumn(2).setPreferredWidth(125);
		table.getColumnModel().getColumn(2).setMinWidth(122);
		table.getColumnModel().getColumn(3).setPreferredWidth(118);
		table.getColumnModel().getColumn(3).setMinWidth(108);
		table.getColumnModel().getColumn(4).setMinWidth(43);
		table.getColumnModel().getColumn(5).setPreferredWidth(115);
		table.getColumnModel().getColumn(5).setMinWidth(88);
		table.getColumnModel().getColumn(6).setPreferredWidth(126);
		table.getColumnModel().getColumn(6).setMinWidth(95);
		table.getColumnModel().getColumn(7).setPreferredWidth(129);
		table.getColumnModel().getColumn(7).setMinWidth(104);
		table.getColumnModel().getColumn(8).setPreferredWidth(115);
		table.getColumnModel().getColumn(8).setMinWidth(109);
		table.getColumnModel().getColumn(9).setPreferredWidth(129);
		table.getColumnModel().getColumn(9).setMinWidth(105);
		table.getColumnModel().getColumn(10).setMinWidth(60);
		table.getColumnModel().getColumn(10).setMaxWidth(324555566);
		table.getColumnModel().getColumn(11).setPreferredWidth(106);
		table.getColumnModel().getColumn(11).setMinWidth(105);
		table.getColumnModel().getColumn(12).setPreferredWidth(104);
		table.getColumnModel().getColumn(12).setMinWidth(87);
		table.getColumnModel().getColumn(13).setPreferredWidth(122);
		table.getColumnModel().getColumn(13).setMinWidth(107);
		table.getColumnModel().getColumn(14).setPreferredWidth(94);
		table.getColumnModel().getColumn(14).setMinWidth(93);
		table.getColumnModel().getColumn(15).setPreferredWidth(123);
		table.getColumnModel().getColumn(15).setMinWidth(112);
		table.getColumnModel().getColumn(15).setMaxWidth(288678769);
		table.setFont(new Font("Tahoma", Font.BOLD, 11));

	}
}
