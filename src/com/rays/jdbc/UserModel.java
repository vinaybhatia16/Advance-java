package com.rays.jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserModel {

	public void Registration(UserBean bean) throws Exception {

		Connection conn = null;

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "vinu1997");

			PreparedStatement pstmt = conn.prepareStatement("insert into user  values (?,?,?,?,?)");
			pstmt.setInt(1, bean.getId());
			pstmt.setString(2, bean.getUsername());
			pstmt.setString(3, bean.getPassword());
			pstmt.setString(4, bean.getEmail());
			pstmt.setString(5, bean.getMobile());

			int i = pstmt.executeUpdate();
			System.out.println(i + " row affected(records inserted...)");
			conn.close();
			pstmt.close();

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	public UserBean Authentication(String username, String password) throws SQLException {

		Connection conn = null;
		UserBean bean = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "vinu1997");
			PreparedStatement pstmt = conn.prepareStatement("select * from user where username  = ?  and password =?");

			pstmt.setString(1, username);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				bean = new UserBean();
				bean.setId(rs.getInt(1));
				bean.setUsername(rs.getString(2));
				bean.setPassword(rs.getString(3));
				bean.setEmail(rs.getString(4));
				bean.setMobile(rs.getString(5));
				
	
			}

			pstmt.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return bean;

	}

}
