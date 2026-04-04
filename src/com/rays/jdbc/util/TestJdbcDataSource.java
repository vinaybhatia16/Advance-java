package com.rays.jdbc.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestJdbcDataSource {
	public static void main(String[] args) {
		for (int i = 1; i <= 100; i++) {
			testSearch();
			System.out.println("connection : ======" + i);
		}
	}

	public static void testSearch() {

		Connection conn = null;

		try {

			conn = JdbcDataSource.getConnection();
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery("select * from employee where staffid = 1");

			while (rs.next()) {
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
				System.out.println(rs.getInt(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// JdbcDataSource.closeConnection(conn);
		}
	}
}
