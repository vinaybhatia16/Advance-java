package com.rays.jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Marksheet1Model {
	public void add(Marksheet1Bean bean) throws SQLException {

		Connection conn = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "vinu1997");
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement("insert into Marksheet1 values(?,?,?,?,?,?)");
			pstmt.setInt(1, bean.getId());
			pstmt.setInt(2, bean.getRollno());
			pstmt.setString(3, bean.getName());
			pstmt.setInt(4, bean.getPhy());
			pstmt.setInt(5, bean.getChm());
			pstmt.setInt(6, bean.getMaths());

			int i = pstmt.executeUpdate();

			System.out.println(i + " row affected(records inserted...)");

			conn.commit();

			conn.close();
			pstmt.close();

		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		}

	}

	public void Update(Marksheet1Bean bean) throws SQLException {

		Connection conn = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "vinu1997");
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement(
					"update marksheet1 set rollno = ?, name = ?, phy = ?, chm = ?, maths = ? where id = ? ");

			pstmt.setInt(1, bean.getRollno());
			pstmt.setString(2, bean.getName());
			pstmt.setInt(3, bean.getPhy());
			pstmt.setInt(4, bean.getChm());
			pstmt.setInt(5, bean.getMaths());
			pstmt.setInt(6, bean.getId());

			int i = pstmt.executeUpdate();

			System.out.println(i + " row updated(records updated...)");

			conn.commit();

			conn.close();
			pstmt.close();

		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		}

	}

	public void Delete(Marksheet1Bean bean) throws SQLException {

		Connection conn = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "vinu1997");
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement("delete from marksheet1 where id =? ");

			pstmt.setInt(1, bean.getId());

			int i = pstmt.executeUpdate();

			System.out.println(i + " record deleted");

			conn.commit();

			conn.close();
			pstmt.close();

		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		}
	}

	public Marksheet1Bean FindByPk(int id) throws SQLException {

		Connection conn = null;
		Marksheet1Bean bean = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "vinu1997");
			PreparedStatement pstmt = conn.prepareStatement("select * from marksheet1 where id = ? ");

			pstmt.setInt(1, id);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				bean = new Marksheet1Bean();
				bean.setId(rs.getInt(1));
				bean.setRollno(rs.getInt(2));
				bean.setName(rs.getString(3));
				bean.setPhy(rs.getInt(4));
				bean.setMaths(rs.getInt(5));
				bean.setChm(rs.getInt(6));

			}

			pstmt.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return bean;

	}

	public Marksheet1Bean FindByName(String name) throws SQLException {

		Connection conn = null;
		Marksheet1Bean bean = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "vinu1997");
			PreparedStatement pstmt = conn.prepareStatement("select * from marksheet1 where name = ? ");

			pstmt.setString(1, name);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				bean = new Marksheet1Bean();
				bean.setId(rs.getInt(1));
				bean.setRollno(rs.getInt(2));
				bean.setName(rs.getString(3));
				bean.setPhy(rs.getInt(4));
				bean.setMaths(rs.getInt(5));
				bean.setChm(rs.getInt(6));

			}

			pstmt.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return bean;
	}

	public List<Marksheet1Bean> Search(Marksheet1Bean bean ,int pageNo, int pageSize) throws Exception {
		List<Marksheet1Bean> list = new ArrayList<Marksheet1Bean>();
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "vinu1997");
		StringBuffer sql = new StringBuffer("select * from marksheet1 where 1 = 1");

		if (bean != null) {

			if (bean.getId() != 0 && bean.getId() > 0) {
				sql.append(" and id = " + bean.getId());
			}

			if (bean.getRollno() != 0 && bean.getRollno() > 0) {
				sql.append(" and rollno = " + bean.getRollno());
			}

			if (bean.getName() != null && bean.getName().length() > 0) {
				sql.append(" and name like '" + bean.getName() + "%'");
			}
			if (bean.getChm() != 0 && bean.getChm() > 0) {

				sql.append(" and chm = " + bean.getChm());

			}
			if (bean.getMaths() != 0 && bean.getMaths() > 0) {
				sql.append(" and maths = " + bean.getMaths());
				
			}
			if (bean.getPhy() != 0 && bean.getPhy() > 0) {
				
				sql.append(" and phy = " + bean.getPhy());
			}
			if( pageSize > 0) {
				pageNo = (pageNo - 1) * pageSize;
				sql.append(" limit " + pageNo + ", " + pageSize);
				
			}
		}
		System.out.println("sql ==> " + sql.toString());
		PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			bean = new Marksheet1Bean();
			bean.setId(rs.getInt(1));
			bean.setRollno(rs.getInt(2));
			bean.setName(rs.getString(3));
			bean.setMaths(rs.getInt(4));
			bean.setPhy(rs.getInt(5));
			bean.setChm(rs.getInt(6));

			list.add(bean);

		}

		return list;
	}



}
