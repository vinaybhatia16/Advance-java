package com.rays.jdbc.util;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public final class JdbcDataSource {

	private static JdbcDataSource jds = null;

	private ComboPooledDataSource ds = null;

	private JdbcDataSource() {

		try {
			ds = new ComboPooledDataSource();
			ds.setDriverClass("com.mysql.cj.jdbc.Driver");
			ds.setJdbcUrl("jdbc:mysql://localhost:3306/rays");
			ds.setUser("root");
			ds.setPassword("vinu1997");
			ds.setInitialPoolSize(2);
			ds.setAcquireIncrement(2);
			ds.setMaxPoolSize(50);
			ds.setMinPoolSize(2);
		} catch (PropertyVetoException e) {

			e.printStackTrace();

		}

	}

	public static JdbcDataSource getInstance() {

		if (jds == null) {

			jds = new JdbcDataSource();
		}
		return jds;
	}

	public static Connection getConnection() {
		try {
			return getInstance().ds.getConnection();
		} catch (SQLException e) {
			return null;
		}
	}

	public static void closeConnection(Connection conn, Statement stmt, ResultSet rs) {

		try {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public static void closeConnection(Connection conn, Statement stmt) {
		closeConnection(conn, stmt, null);
	}

	public static void closeConnection(Connection conn) {
		closeConnection(conn, null, null);
	}
}
