package resouces;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;
/*mport net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
*/
import javax.swing.border.BevelBorder;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Leaves extends JPanel {
	private JTextField employeeidtxt;
	private JTextField reasontxt;
	private JTextField textField_2;
	private JTextField totxt;
	private JTextField fromtxt;
	Connection conn ;
	PreparedStatement pst;
	ResultSet rs ;
	private JTable table;
	private JTextField rowstxt;

	/**
	 * Create the panel.
	 */
	public Leaves() {
		setBounds(0,0,690,527);
		setLayout(null);
		
		JPanel addLeavePanel = new JPanel();
		addLeavePanel.setBackground(new Color(0, 128, 0));
		addLeavePanel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		addLeavePanel.setBounds(10, 43, 670, 204);
		add(addLeavePanel);
		addLeavePanel.setLayout(null);
		
		JLabel lblEmployeeId = new JLabel("Employee ID");
		lblEmployeeId.setFont(new Font("Arial", Font.BOLD, 12));
		lblEmployeeId.setBounds(10, 16, 77, 25);
		addLeavePanel.add(lblEmployeeId);
		
		JLabel lblNewLabel_1_1 = new JLabel("Leave Type");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_1_1.setBounds(10, 59, 77, 25);
		addLeavePanel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("From");
		lblNewLabel_1_2.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_1_2.setBounds(10, 115, 77, 25);
		addLeavePanel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("To");
		lblNewLabel_1_3.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_1_3.setBounds(10, 167, 77, 25);
		addLeavePanel.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Reasons");
		lblNewLabel_1_4.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_1_4.setBounds(409, 16, 77, 25);
		addLeavePanel.add(lblNewLabel_1_4);
		// ENTERING LEAVE DETAILS IN THE DATABASE
		employeeidtxt = new JTextField();
		employeeidtxt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {
					conn = DriverManager.getConnection("jdbc:mysql://localhost/humanresoursemanagement","root","");
					String sql = "SELECT * FROM  leavetable WHERE Employeeid =?";
					PreparedStatement pst =conn.prepareStatement(sql);
					pst.setString(1,employeeidtxt.getText());
					ResultSet rs=pst.executeQuery();
					while(rs.next()) {
						String setid =rs.getString("Employeeid");
						employeeidtxt.setText(setid);
						
						fromtxt.setText(rs.getString("From"));
						totxt.setText(rs.getString("To"));
						reasontxt.setText(rs.getString("Reason"));
						}
					pst.close();
					}catch( SQLException |HeadlessException ex){
						JOptionPane.showMessageDialog(null, "DATABASE ERROR !!");
					}
			}
		});
		employeeidtxt.setFont(new Font("Tahoma", Font.BOLD, 13));
		employeeidtxt.setBounds(108, 13, 145, 28);
		addLeavePanel.add(employeeidtxt);
		employeeidtxt.setColumns(10);
		
		JComboBox leavetypecomboBox = new JComboBox();
		leavetypecomboBox.setFont(new Font("Tahoma", Font.BOLD, 13));
		leavetypecomboBox.setModel(new DefaultComboBoxModel(new String[] {"Illness", "Death", "Accident"}));
		leavetypecomboBox.setBounds(108, 58, 145, 26);
		addLeavePanel.add(leavetypecomboBox);
		
		
		
		reasontxt = new JTextField();
		reasontxt.setFont(new Font("Tahoma", Font.BOLD, 13));
		reasontxt.setColumns(10);
		reasontxt.setBounds(419, 52, 241, 100);
		addLeavePanel.add(reasontxt);
		
		JButton btnSave = new JButton("Clear");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				employeeidtxt.setText("");
				totxt.setText("");
				fromtxt.setText("");
				reasontxt.setText("");
				rowstxt.setText("");
			}
		});
		btnSave.setBackground(new Color(0, 0, 0));
		btnSave.setForeground(new Color(0, 100, 0));
		btnSave.setFont(new Font("Arial", Font.BOLD, 15));
		btnSave.setBounds(558, 163, 102, 30);
		addLeavePanel.add(btnSave);
		
		totxt = new JTextField();
		totxt.setFont(new Font("Tahoma", Font.BOLD, 13));
		totxt.setBounds(111, 163, 145, 26);
		addLeavePanel.add(totxt);
		totxt.setColumns(10);
		
		fromtxt = new JTextField();
		fromtxt.setFont(new Font("Tahoma", Font.BOLD, 13));
		fromtxt.setBounds(109, 115, 144, 25);
		addLeavePanel.add(fromtxt);
		fromtxt.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("yyyy-mm-dd");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel.setBounds(118, 95, 115, 14);
		addLeavePanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("yyyy-mm-dd");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_1.setBounds(119, 142, 115, 14);
		addLeavePanel.add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(10, 295, 670, 221);
		add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 650, 199);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"EmployeeID", "LeaveType", "From", "To", "Reason"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(90);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(110);
		table.getColumnModel().getColumn(3).setPreferredWidth(115);
		table.getColumnModel().getColumn(4).setPreferredWidth(219);
		table.getColumnModel().getColumn(4).setMinWidth(87);
		
		JLabel lblShows = new JLabel("Entries");
		lblShows.setFont(new Font("Arial", Font.BOLD, 13));
		lblShows.setBounds(149, 259, 43, 25);
		add(lblShows);
		
		JLabel lblShows_1_1 = new JLabel("Search");
		lblShows_1_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblShows_1_1.setBounds(477, 259, 60, 25);
		add(lblShows_1_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(544, 258, 136, 26);
		add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnExportReport = new JButton("Export Report");
		btnExportReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{
					String sql ="SELECT * FROM leavetable";
					conn = DriverManager.getConnection("jdbc:mysql://localhost/humanresoursemanagement","root","");
					JasperDesign jdesign = JRXmlLoader.load("C:\\Users\\real de\\Desktop\\ECLIPSE PROJECTS\\HUMAN RESOUCE MANAGEMENT SYSTEM\\LeaveReport.jrxml");
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
		btnExportReport.setForeground(new Color(0, 100, 0));
		btnExportReport.setFont(new Font("Arial", Font.BOLD, 15));
		btnExportReport.setBackground(Color.BLACK);
		btnExportReport.setBounds(544, 0, 136, 32);
		add(btnExportReport);
		
		JButton btnNewButton = new JButton("Add Leave");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String leavetype = String.valueOf(leavetypecomboBox.getSelectedItem());
				
				try {
					
					String sql ="INSERT INTO `leavetable`(`Employeeid`, `Leavetype`, `From`, `To`, `Reason`) VALUES (?,?,?,?,?)";
					conn = DriverManager.getConnection("jdbc:mysql://localhost/humanresoursemanagement","root","");
					pst=conn.prepareStatement(sql);
					pst.setString(1, employeeidtxt.getText());
					pst.setString(2, leavetype);
					pst.setString(3, fromtxt.getText());
					pst.setString(4,totxt.getText());
					pst.setString(5, reasontxt.getText());
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null,"Employee Leave Added Successfully");
					}
				catch( SQLException | HeadlessException ex){
					JOptionPane.showMessageDialog(null, "DATABASE ERROR !!");
				}
				
			}
		});
		btnNewButton.setForeground(new Color(0, 128, 0));
		btnNewButton.setBackground(new Color(0, 0, 255));
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 15));
		btnNewButton.setBounds(10, 6, 120, 26);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Manage Leaves");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String sql ="SELECT * FROM leavetable";
					conn = DriverManager.getConnection("jdbc:mysql://localhost/humanresoursemanagement","root","");
					PreparedStatement pst = conn.prepareStatement(sql);
					ResultSet rs = pst.executeQuery();
					DefaultTableModel model =(DefaultTableModel) table.getModel();
					while(rs.next()) {
						model.addRow(new String[] {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)});
					}
					
				}
				catch( SQLException | HeadlessException ex){
					JOptionPane.showMessageDialog(null, ex);
				}
			}
		});
		btnNewButton_1.setForeground(new Color(0, 128, 0));
		btnNewButton_1.setBackground(new Color(0, 0, 255));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBounds(217, 258, 168, 26);
		add(btnNewButton_1);
		//GENERATING ROW COUNT
		JButton btnshows = new JButton("Shows");
		btnshows.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String sql ="SELECT count(Employeeid) from leavetable";
					conn = DriverManager.getConnection("jdbc:mysql://localhost/humanresoursemanagement","root","");
					pst=conn.prepareStatement(sql);
					rs=pst.executeQuery();
					if(rs.next()) {
						String sum= rs.getString("count(Employeeid)");
						rowstxt.setText(sum);
					}
					
					}
					catch( SQLException | HeadlessException ex){
						JOptionPane.showMessageDialog(null, "DATABASE ERROR !!");
					}
			}
		});
		btnshows.setBackground(new Color(0, 0, 255));
		btnshows.setForeground(new Color(0, 128, 0));
		btnshows.setFont(new Font("Arial", Font.BOLD, 15));
		btnshows.setBounds(10, 258, 88, 26);
		add(btnshows);
		
		rowstxt = new JTextField();
		rowstxt.setForeground(new Color(128, 0, 0));
		rowstxt.setFont(new Font("Tahoma", Font.BOLD, 18));
		rowstxt.setBounds(99, 258, 49, 26);
		add(rowstxt);
		rowstxt.setColumns(10);
	}
}
