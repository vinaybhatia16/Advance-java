package com.rays.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StaffModel {
	public void Add(StaffBean bean) throws SQLException {

		Connection conn = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "vinu1997");
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement("insert into employee values(?,?,?,?)");
			pstmt.setInt(1, bean.getStaffId());
			pstmt.setString(2, bean.getStaffName());
			pstmt.setString(3, bean.getShift());
			pstmt.setInt(4, bean.getSalary());
			
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


	
	

public void Update(StaffBean bean) throws SQLException {

	Connection conn = null;

	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "vinu1997");
		conn.setAutoCommit(false);
		PreparedStatement pstmt = conn.prepareStatement(
				"update employee set staffname = ?,shift= ?,salary= ? where staffid = ?");

		pstmt.setString(1, bean.getStaffName());
		pstmt.setString(2, bean.getShift());
		pstmt.setInt(3, bean.getSalary());
		pstmt.setInt(4, bean.getStaffId());
		
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

public void Delete(StaffBean bean) throws SQLException {

	Connection conn = null;

	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "vinu1997");
		conn.setAutoCommit(false);
		PreparedStatement pstmt = conn.prepareStatement("delete from employee where staffid =? ");

		pstmt.setInt(1, bean.getStaffId());

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

public StaffBean FindByPk(int staffid) throws SQLException {

	Connection conn = null;
	StaffBean bean = null;

	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "vinu1997");
		PreparedStatement pstmt = conn.prepareStatement("select * from employee where staffid = ? ");

		pstmt.setInt(1, staffid);

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			bean = new StaffBean();
			bean.setStaffId(rs.getInt(1));
			bean.setStaffName(rs.getString(2));
			bean.setShift(rs.getString(3));
			bean.setSalary(rs.getInt(4));
			

		}

		pstmt.close();

	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		conn.close();
	}
	return bean;

}

public List<StaffBean> Search(StaffBean bean ) throws Exception {
	List<StaffBean> list = new ArrayList<StaffBean>();
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "vinu1997");
	StringBuffer sql = new StringBuffer("select * from employee where 1 = 1");

	if (bean != null) {

		if (bean.getStaffId() != 0 && bean.getStaffId() > 0) {
			sql.append(" and staffid = " + bean.getStaffId());
		}

		if (bean.getStaffName() != null && bean.getStaffName().length()> 0) {
			sql.append(" and staffname like '" + "= " + bean.getStaffName() +"%'");
		}
		if (bean.getShift()!= null && bean.getShift().length()> 0) {
			sql.append(" and shift like '" + bean.getStaffName() +  "%'");
		}
		
		if (bean.getSalary()!= 0 && bean.getSalary() > 0) {

			sql.append(" and salary = " + bean.getSalary());

		}
		
		
		
	}
	System.out.println("sql ==> " + sql.toString());
	PreparedStatement pstmt = conn.prepareStatement(sql.toString());
	ResultSet rs = pstmt.executeQuery();

	while (rs.next()) {
		bean = new StaffBean();
		bean.setStaffId(rs.getInt(1));
		bean.setStaffName(rs.getString(2));
		bean.setShift(rs.getString(3));
		bean.setSalary(rs.getInt(4));
		
		list.add(bean);

	}

	return list;
}

}
