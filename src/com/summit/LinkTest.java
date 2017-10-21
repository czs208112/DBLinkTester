package com.summit;

import java.sql.Connection;
import java.sql.DriverManager;

public class LinkTest {
	public static String LinkDb(String driver, String url, String username, String password) {
		Connection connection = null;
		String msg = "";
		try {
			// 加 载驱动
			Class.forName(driver);
			// 通过驱动管理类获取数据库连接
			connection = DriverManager.getConnection(url, username, password);

			if (connection != null) {

				msg = "连接成功^_^";
			} else {
				msg = "连接失败!!!";
			}

			// 关闭连接
			connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			msg = "连接失败!!!\n"+e.getMessage();
		} catch (Exception e) {
			e.printStackTrace();
			msg = "连接失败!!!\n"+e.getMessage();
		}

		return msg;
	}
}
