package com.rays.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RechargeModel {
	public void Add(RechargeBean bean) throws SQLException {

		Connection conn = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "vinu1997");
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement("insert into recharge values(?,?,?,?)");
			pstmt.setInt(1, bean.getRechargeId());
			pstmt.setString(2, bean.getMobileNumber());
			pstmt.setDouble(3, bean.getAmount());
			pstmt.setDate(4, new java.sql.Date(bean.getRechargeDate().getTime()));
			
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

public void Update(RechargeBean bean) throws SQLException {

	Connection conn = null;

	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "vinu1997");
		conn.setAutoCommit(false);
		PreparedStatement pstmt = conn.prepareStatement(
				"update recharge set mobile_number= ?,amount= ?,recharge_date=? where recharge_id= ?");
		pstmt.setString(1, bean.getMobileNumber());
		pstmt.setDouble(2, bean.getAmount());
		pstmt.setDate(3, new java.sql.Date(bean.getRechargeDate().getTime()));
		pstmt.setInt(4, bean.getRechargeId());
		
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

public void Delete(RechargeBean bean) throws SQLException {

	Connection conn = null;

	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "vinu1997");
		conn.setAutoCommit(false);
		PreparedStatement pstmt = conn.prepareStatement("delete from recharge where recharge_id =? ");

		pstmt.setDouble(1, bean.getRechargeId());

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

public RechargeBean FindByPk(int recharge_id) throws SQLException {

	Connection conn = null;
	RechargeBean bean = null;

	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "vinu1997");
		PreparedStatement pstmt = conn.prepareStatement("select * from recharge where recharge_id = ? ");

		pstmt.setInt(1, recharge_id);


		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			bean = new RechargeBean();
			bean.setRechargeId(rs.getInt(1));
			bean.setMobileNumber(rs.getString(2));
			bean.setAmount(rs.getDouble(3));
			bean.setRechargeDate(rs.getDate(4));
		}

		pstmt.close();

	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		conn.close();
	}
	return bean;

}
public List<RechargeBean> Search(RechargeBean bean) throws Exception {
	List<RechargeBean> list = new ArrayList<RechargeBean>();
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "vinu1997");
	StringBuffer sql = new StringBuffer("select * from recharge where 1 = 1");

	if (bean != null) {

		if (bean.getRechargeId() != 0 && bean.getRechargeId() > 0) {
			sql.append(" and recharge_id = " + bean.getRechargeId());
		}

		if (bean.getMobileNumber() != null && bean.getMobileNumber().length() > 0) {
			sql.append(" and mobile_number like '" + "= " + bean.getMobileNumber() + "%'");
		}
		if (bean.getAmount() != null && bean.getAmount() > 0) {
			sql.append(" and amount = " + bean.getAmount());
		}
		if ( (bean.getRechargeDate() != null)) {
			sql.append(" and recharge_date = '" + new java.sql.Date(bean.getRechargeDate().getTime()) + "'");
		   
		}
	}
	System.out.println("sql ==> " + sql.toString());
	PreparedStatement pstmt = conn.prepareStatement(sql.toString());
	ResultSet rs = pstmt.executeQuery();

	while (rs.next()) {
		bean = new RechargeBean();
		bean.setRechargeId(rs.getInt(1));
		bean.setMobileNumber(rs.getString(2));
		bean.setAmount(rs.getDouble(3));
		bean.setRechargeDate(rs.getDate(4));

		list.add(bean);

	}

	return list;
}

}
