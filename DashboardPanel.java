package resouces;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.UIManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;

public class DashboardPanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private Image te =new ImageIcon( DashboardPanel.class.getResource("EMPLOYEES.png")).getImage().getScaledInstance(74,46,Image.SCALE_SMOOTH);
	private Image imglv =new ImageIcon(DashboardPanel.class.getResource("leave.jpg")).getImage().getScaledInstance(79,47,Image.SCALE_SMOOTH);
	private Image ta =new ImageIcon(DashboardPanel.class.getResource("employee.jpg")).getImage().getScaledInstance(46,47,Image.SCALE_SMOOTH);
	private Image tp =new ImageIcon(DashboardPanel.class.getResource("ManageEmployee.png")).getImage().getScaledInstance(55,47,Image.SCALE_SMOOTH);
	
	/**
	 * Create the panel.
	 */
	public DashboardPanel() {
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
      setBounds(0,0,690,527);
      setLayout(null);
      
      JLabel lbldash = new JLabel("Dashboard");
      lbldash.setBounds(49, 11, 160, 36);
      lbldash.setFont(new Font("Arial", Font.BOLD, 15));
      add(lbldash);
      
      JPanel totalemployeepanel = new JPanel();
      totalemployeepanel.setBounds(10, 58, 160, 95);
      totalemployeepanel.setBorder(UIManager.getBorder("InternalFrame.border"));
      add(totalemployeepanel);
      totalemployeepanel.setLayout(null);
      
      JLabel lbltotalemployees = new JLabel("Total Employees");
      lbltotalemployees.setFont(new Font("Arial", Font.BOLD, 15));
      lbltotalemployees.setBounds(26, 56, 124, 28);
      totalemployeepanel.add(lbltotalemployees);
      
      textField = new JTextField();
      textField.setFont(new Font("Tahoma", Font.BOLD, 20));
      textField.setBounds(88, 11, 62, 34);
      totalemployeepanel.add(textField);
      textField.setColumns(10);
      
      JLabel TElbl = new JLabel("");
      TElbl.setIcon(new ImageIcon(te));
      TElbl.setBounds(10, 11, 74, 47);
      totalemployeepanel.add(TElbl);
      
      JPanel totalpresentpanel = new JPanel();
      totalpresentpanel.setBounds(180, 58, 144, 95);
      totalpresentpanel.setBorder(UIManager.getBorder("InternalFrame.border"));
      add(totalpresentpanel);
      totalpresentpanel.setLayout(null);
      
      JLabel lbltotalpresent = new JLabel("Total Present");
      lbltotalpresent.setFont(new Font("Arial", Font.BOLD, 15));
      lbltotalpresent.setBounds(10, 58, 105, 26);
      totalpresentpanel.add(lbltotalpresent);
      
      textField_1 = new JTextField();
      textField_1.setFont(new Font("Tahoma", Font.BOLD, 20));
      textField_1.setBounds(75, 11, 59, 36);
      totalpresentpanel.add(textField_1);
      textField_1.setColumns(10);
      
      JLabel TPlbl = new JLabel("");
      TPlbl.setIcon(new ImageIcon(tp));
      TPlbl.setBounds(10, 9, 55, 47);
      totalpresentpanel.add(TPlbl);
      
      JPanel totalabsentpanel = new JPanel();
      totalabsentpanel.setBounds(334, 58, 135, 95);
      totalabsentpanel.setBorder(UIManager.getBorder("InternalFrame.border"));
      add(totalabsentpanel);
      totalabsentpanel.setLayout(null);
      
      JLabel lblTotalAbsent = new JLabel("Total Absent");
      lblTotalAbsent.setBounds(10, 57, 119, 27);
      totalabsentpanel.add(lblTotalAbsent);
      lblTotalAbsent.setFont(new Font("Arial", Font.BOLD, 15));
      
      textField_2 = new JTextField();
      textField_2.setFont(new Font("Tahoma", Font.BOLD, 20));
      textField_2.setBounds(61, 11, 64, 35);
      totalabsentpanel.add(textField_2);
      textField_2.setColumns(10);
      
      JLabel TAlbl = new JLabel("");
      TAlbl.setIcon(new ImageIcon(ta));
      TAlbl.setBounds(10, 11, 46, 47);
      totalabsentpanel.add(TAlbl);
      
      JPanel onleavepanel = new JPanel();
      onleavepanel.setBounds(479, 58, 176, 95);
      onleavepanel.setBorder(UIManager.getBorder("InternalFrame.border"));
      add(onleavepanel);
      onleavepanel.setLayout(null);
      
      JLabel lblonleave = new JLabel("On Leave Employees");
      lblonleave.setFont(new Font("Arial", Font.BOLD, 15));
      lblonleave.setBounds(10, 57, 156, 27);
      onleavepanel.add(lblonleave);
      
      textField_3 = new JTextField();
      textField_3.setFont(new Font("Tahoma", Font.BOLD, 20));
      textField_3.setBounds(97, 11, 69, 35);
      onleavepanel.add(textField_3);
      textField_3.setColumns(10);
      
      JLabel OLElbl = new JLabel("");
      OLElbl.setIcon(new ImageIcon(imglv));
      OLElbl.setBounds(10, 11, 79, 47);
      onleavepanel.add(OLElbl);
	}
}
