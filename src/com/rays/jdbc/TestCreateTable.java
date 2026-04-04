package com.rays.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.Statement;

public class TestCreateTable {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "vinu1997");

		System.out.println("connection established successfully:" + conn.getCatalog());
		Statement stmt = conn.createStatement();

		boolean pass = stmt.execute(
				"create table marksheet1(id int primary key, rollno int, name varchar(45), phy int, chm int, maths int)");
		System.out.println("table created");
		conn.close();
		stmt.close();

	}

}
