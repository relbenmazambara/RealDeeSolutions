import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.*;
import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.awt.Toolkit;
import java.awt.Dialog.ModalExclusionType;

public class Login extends JFrame {
// GENERATING IMAGES ON A FORM
	private Image img_log =new ImageIcon(Login.class.getResource("resouces/LOG.jpg")).getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH);	
	private Image img_password =new ImageIcon(Login.class.getResource("resouces/OIP.jpg")).getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH);
	private Image img_login =new ImageIcon(Login.class.getResource("resouces/Loginimg.jpg")).getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH);
    private Image imgusername =new ImageIcon(Login.class.getResource("resouces/USERNAME.png")).getImage().getScaledInstance(40,35,Image.SCALE_SMOOTH);
    private Image loginbackimg =new ImageIcon(Login.class.getResource("resouces/EMPLOYEES.png")).getImage().getScaledInstance(559,378,Image.SCALE_SMOOTH);
    private Image cologimg =new ImageIcon(Login.class.getResource("resouces/companylog.png")).getImage().getScaledInstance(160,112,Image.SCALE_SMOOTH);
	private JPanel contentPane;
	private JTextField txtuser;
	Connection conn =null;
	PreparedStatement st =null;
	ResultSet rs =null;
	private JPasswordField txtPassword;
	private JLabel lblloginmsg = new JLabel("");
	
	/**
	 * Launch the application.
	 * 
	 */

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
		
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
	public Login() {
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/resouces/OIP.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(new Color(0, 139, 139));
		contentPane.setBorder(new LineBorder(Color.BLUE, 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JPanel panel = new JPanel();
		panel.setBounds(191, 141, 269, 45);
		contentPane.add(panel);
		panel.setLayout(null);
		
		txtuser = new JTextField();
		txtuser.setBorder(null);
		txtuser.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtuser.getText().equals("username")) {
					txtuser.setText("");
				}
			else {
						txtuser.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
                 if(txtuser.getText().equals(""));
			}
		});
		txtuser.setFont(new Font("Arial", Font.BOLD, 12));
		txtuser.setText("Username");
		txtuser.setBounds(10, 11, 196, 23);
		panel.add(txtuser);
		txtuser.setColumns(10);
		
		JLabel lblusername = new JLabel("");
		lblusername.setBounds(291, 11, -29, 28);
		panel.add(lblusername);
		//lblusername.setIcon(new ImageIcon(img_username));
		
		JLabel lblloginimg = new JLabel("");
		lblloginimg.setIcon(new ImageIcon(imgusername));
		lblloginimg.setBounds(213, 0, 49, 39);
		panel.add(lblloginimg);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(191, 208, 269, 45);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblpassword = new JLabel("");
		lblpassword.setBounds(223, 0, 46, 45);
		panel_1.add(lblpassword);
		lblpassword.setIcon(new ImageIcon(img_password));
		
		txtPassword = new JPasswordField();
		txtPassword.setBorder(null);
		txtPassword.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtPassword.getText().equals("Password")) {
					txtPassword.setEchoChar('*');
					txtPassword.setText("");
				}
			else {
						txtPassword.selectAll();
				}
				
			}
			@Override
			public void focusLost(FocusEvent e) {
				 if(txtPassword.getText().equals(""));
				 txtPassword.setText("Password");
				 txtPassword.setEchoChar((char)0);
			}

		});
		txtPassword.setToolTipText("");
		txtPassword.setFont(new Font("Arial", Font.BOLD, 12));
		txtPassword.setText("Password");
		txtPassword.setBounds(10, 11, 194, 23);
		panel_1.add(txtPassword);
		// lOGIN PROGRAM
		JPanel pnlBtnLogin = new JPanel();
		pnlBtnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String userName = txtuser.getText();
				String password =txtPassword.getText();
				try {
					String query =("SELECT * FROM logintable WHERE username=? and password =?");
					conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/humanresoursemanagement","root","");
					st = conn.prepareStatement(query);
					st.setString(1 ,txtuser.getText());
					st.setString(2,txtPassword.getText());
					rs=st.executeQuery();
					if(rs.next()) {
						lblloginmsg.setText("You Are Successfully Loged In");
						Dashboard dsh = new Dashboard();
						dsh.setVisible(true);
					dispose();
						}
					else {
						lblloginmsg.setText("Login Unsuccessfull; Correct credentials !");
					}
				}
                         catch (Exception ex) {
                        	 JOptionPane.showMessageDialog(panel_1,"Database Error");
                         }
													
					
			}

			private void setVisible(boolean b) {
				// TODO Auto-generated method stub
				
			}
		});
		pnlBtnLogin.setBackground(new Color(47, 79, 79));
		pnlBtnLogin.setBounds(191, 303, 269, 50);
		contentPane.add(pnlBtnLogin);
		pnlBtnLogin.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel.setBounds(95, 11, 88, 28);
		pnlBtnLogin.add(lblNewLabel);
		
		JLabel lbllogin = new JLabel("");
		lbllogin.setForeground(Color.WHITE);
		lbllogin.setBackground(Color.WHITE);
		lbllogin.setBounds(37, 0, 48, 50);
		pnlBtnLogin.add(lbllogin);
		lbllogin.setIcon(new ImageIcon(img_login));
		 // CREATING AN EXIT BUTTON
		JLabel lblX = new JLabel("X");
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null,"Are you sure you want to close the Application","Confirmation",JOptionPane.YES_NO_OPTION)==0) {
					Login.this.dispose();
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblX.setForeground(Color.RED);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				lblX.setForeground(Color.WHITE);
			}
		});
		lblX.setFont(new Font("Comic Sans MS", Font.BOLD, 21));
		lblX.setHorizontalAlignment(SwingConstants.LEFT);
		lblX.setForeground(Color.WHITE);
		lblX.setVerticalAlignment(SwingConstants.TOP);
		lblX.setBounds(579, 0, 21, 25);
		contentPane.add(lblX);
		
		lblloginmsg.setForeground(Color.RED);
		//lbllogin.setIcon(new ImageIcon(loginimg));
		lblloginmsg.setFont(new Font("Arial", Font.BOLD, 14));
		lblloginmsg.setBounds(191, 264, 382, 39);
		contentPane.add(lblloginmsg);
		
		JLabel lblcolog = new JLabel("");
		lblcolog.setIcon(new ImageIcon(cologimg));
		lblcolog.setBounds(236, 13, 166, 112);
		contentPane.add(lblcolog);
		
		JLabel lblloginbackground = new JLabel("");
		lblloginbackground.setIcon(new ImageIcon(loginbackimg));
		lblloginbackground.setBounds(10, 11, 559, 378);
		contentPane.add(lblloginbackground);
		setUndecorated(true);
		setLocationRelativeTo(null);
	}
}
