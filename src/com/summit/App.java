package com.summit;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class App {

	private JFrame frmByZs;
	private JTextField textField_ip;
	private JTextField textField_username;
	private JTextField textField_password;
	private JTextField textField_dbname;
	private JTextField textField_port;

	String ip = "";
	String port = "";
	String dbname = "";
	String username = "";
	String password = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App window = new App();
					window.frmByZs.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public App() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		System.out.println(System.getProperty("user.dir"));
		frmByZs = new JFrame();
		frmByZs.setResizable(false);
		frmByZs.setTitle("\u8FDE\u63A5\u6D4B\u8BD5 by zs");
		frmByZs.setBounds(100, 100, 378, 269);
		frmByZs.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmByZs.getContentPane().setLayout(null);

		int windowWidth = frmByZs.getWidth(); // 获得窗口宽
		int windowHeight = frmByZs.getHeight(); // 获得窗口高
		Toolkit kit = Toolkit.getDefaultToolkit(); // 定义工具包
		Dimension screenSize = kit.getScreenSize(); // 获取屏幕的尺寸
		int screenWidth = screenSize.width; // 获取屏幕的宽
		int screenHeight = screenSize.height; // 获取屏幕的高
		frmByZs.setLocation(screenWidth / 2 - windowWidth / 2, screenHeight / 2 - windowHeight / 2);// 设置窗口居中显示

		JLabel lblNewLabel = new JLabel("\u6570\u636E\u5E93\u7C7B\u578B:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(27, 16, 83, 18);
		frmByZs.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("ip/port:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(27, 47, 83, 18);
		frmByZs.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("\u7528\u6237\u540D:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(27, 109, 83, 18);
		frmByZs.getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("\u5BC6\u7801:");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setBounds(27, 140, 83, 18);
		frmByZs.getContentPane().add(lblNewLabel_3);

		textField_ip = new JTextField();
		textField_ip.setBounds(118, 44, 153, 24);
		frmByZs.getContentPane().add(textField_ip);
		textField_ip.setColumns(10);

		textField_username = new JTextField();
		textField_username.setBounds(118, 106, 214, 24);
		frmByZs.getContentPane().add(textField_username);
		textField_username.setColumns(10);

		textField_password = new JTextField();
		textField_password.setBounds(118, 137, 214, 24);
		frmByZs.getContentPane().add(textField_password);
		textField_password.setColumns(10);

		JButton btn_test = new JButton("\u8FDE\u63A5\u6D4B\u8BD5");
		btn_test.setBounds(118, 174, 140, 40);
		frmByZs.getContentPane().add(btn_test);

		final JLabel lblNewLabel_4 = new JLabel("\u6570\u636E\u5E93\u540D:");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4.setBounds(38, 78, 72, 18);
		frmByZs.getContentPane().add(lblNewLabel_4);

		textField_dbname = new JTextField();
		textField_dbname.setBounds(118, 75, 214, 24);
		frmByZs.getContentPane().add(textField_dbname);
		textField_dbname.setColumns(10);

		final JComboBox comboBox_type = new JComboBox();
		comboBox_type.setBounds(118, 13, 214, 24);
		comboBox_type.addItem("mysql");
		comboBox_type.addItem("oracle");
		comboBox_type.addItem("sqlserver");

		frmByZs.getContentPane().add(comboBox_type);

		textField_port = new JTextField();
		textField_port.setBounds(275, 44, 57, 24);
		frmByZs.getContentPane().add(textField_port);
		textField_port.setColumns(10);
		textField_port.setText("3306");

		comboBox_type.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String item = comboBox_type.getSelectedItem().toString();
				if ("mysql".equals(item)) {
					lblNewLabel_4.setText("数据库名:");
					textField_port.setText("3306");
				} else if ("oracle".equals(item)) {
					lblNewLabel_4.setText("服务名:");
					textField_port.setText("1521");
				} else if ("sqlserver".equals(item)) {
					lblNewLabel_4.setText("数据库名:");
					textField_port.setText("1433");
				}
			}
		});

		// 测试连接
		btn_test.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String type = comboBox_type.getSelectedItem().toString();
				ip = textField_ip.getText();
				port = textField_port.getText();
				dbname = textField_dbname.getText();
				username = textField_username.getText();
				password = textField_password.getText();
				String url = "";

				if ("".equals(ip) || "".equals(port) || "".equals(dbname) || "".equals(username)
						|| "".equals(password)) {
					JOptionPane.showConfirmDialog(null, "请检查输入项是否为空", "提示", JOptionPane.CLOSED_OPTION,
							JOptionPane.WARNING_MESSAGE);
					return;
				}

				String driver = "";
				if ("mysql".equals(type)) {
					driver = "com.mysql.jdbc.Driver";
					url = "jdbc:mysql://" + ip + ":" + port + "/" + dbname;
				} else if ("oracle".equals(type)) {
					driver = "oracle.jdbc.OracleDriver";
					url = "jdbc:oracle:thin:@//" + ip + ":" + port + "/" + dbname;
				} else if ("sqlserver".equals(type)) {
					driver = "net.sourceforge.jtds.jdbc.Driver";
					url = "jdbc:jtds:sqlserver://" + ip + ":" + port + ";DatabaseName=" + dbname + ";useLOBs=false";
					// url = " jdbc:sqlserver://" + ip + ":" + port +
					// ";DatabaseName=" + dbname + "";
				}
				String rstMsg = "ip: [" + ip + "]\n";
				rstMsg += "port: [" + port + "]\n";
				rstMsg += "dbname: [" + dbname + "]\n";
				rstMsg += "username: [" + username + "]\n";
				rstMsg += "password: [" + password + "]\n\n";
				rstMsg += LinkTest.LinkDb(driver, url, username, password);

				JOptionPane.showConfirmDialog(null, rstMsg, "测试结果", JOptionPane.CLOSED_OPTION,
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
	}
}
