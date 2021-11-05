package resouces;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;

public class Attendance extends JPanel {
	private JTextField searchtxt;

	/**
	 * Create the panel.
	 */
	public Attendance() {
		setBounds(0,0,690,527);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 0));
		panel.setForeground(new Color(0, 128, 128));
		panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(21, 71, 644, 148);
		add(panel);
		panel.setLayout(null);
		
		JComboBox dptCompoBox = new JComboBox();
		dptCompoBox.setBounds(27, 39, 191, 32);
		panel.add(dptCompoBox);
		
		JComboBox shiftCompoBox = new JComboBox();
		shiftCompoBox.setBounds(235, 39, 191, 32);
		panel.add(shiftCompoBox);
		
		
		
		JButton btnGetEmployees = new JButton("Get Employees");
		btnGetEmployees.setForeground(new Color(0, 0, 0));
		btnGetEmployees.setBackground(Color.GREEN);
		btnGetEmployees.setFont(new Font("Arial", Font.BOLD, 13));
		btnGetEmployees.setBounds(453, 99, 135, 38);
		panel.add(btnGetEmployees);
		
		JLabel lblDepartment = new JLabel("Department");
		lblDepartment.setFont(new Font("Arial", Font.BOLD, 14));
		lblDepartment.setBounds(27, 11, 191, 27);
		panel.add(lblDepartment);
		
		JLabel lblShift = new JLabel("Shift");
		lblShift.setFont(new Font("Arial", Font.BOLD, 14));
		lblShift.setBounds(236, 11, 191, 27);
		panel.add(lblShift);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Arial", Font.BOLD, 14));
		lblDate.setBounds(453, 11, 135, 27);
		panel.add(lblDate);
		
		JLabel lblAttendance = new JLabel("Daily Attendance");
		lblAttendance.setFont(new Font("Arial", Font.BOLD, 16));
		lblAttendance.setBounds(21, 23, 199, 27);
		add(lblAttendance);
		
		JPanel displayDailyAttendancePanel = new JPanel();
		displayDailyAttendancePanel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		displayDailyAttendancePanel.setBounds(25, 264, 640, 252);
		add(displayDailyAttendancePanel);
		
		JLabel lblNewLabel = new JLabel("Shows");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel.setBounds(31, 233, 56, 20);
		add(lblNewLabel);
		
		JPanel showsPanel = new JPanel();
		showsPanel.setForeground(new Color(255, 0, 0));
		showsPanel.setBounds(85, 230, 50, 27);
		add(showsPanel);
		showsPanel.setLayout(null);
		
		JLabel lblEntries = new JLabel("Entries");
		lblEntries.setFont(new Font("Arial", Font.BOLD, 12));
		lblEntries.setBounds(138, 233, 56, 20);
		add(lblEntries);
		
		JLabel lblSearch = new JLabel("Search");
		lblSearch.setFont(new Font("Arial", Font.BOLD, 12));
		lblSearch.setBounds(403, 233, 56, 20);
		add(lblSearch);
		
		searchtxt = new JTextField();
		searchtxt.setBounds(462, 233, 139, 20);
		add(searchtxt);
		searchtxt.setColumns(10);
		
		JButton btnExport = new JButton("Export Report");
		btnExport.setForeground(Color.BLACK);
		btnExport.setFont(new Font("Arial", Font.BOLD, 13));
		btnExport.setBackground(Color.GREEN);
		btnExport.setBounds(571, 11, 119, 38);
		add(btnExport);
	}
}
