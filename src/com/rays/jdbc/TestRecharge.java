package com.rays.jdbc;

import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

public class TestRecharge {
	public static void main(String[] args) throws Exception {
		// testAdd();
		// testUpdate();
		// testDelete();
		// testFindByPk();
		testSearch();

	}

	public static void testAdd() throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		RechargeBean bean = new RechargeBean();
		RechargeModel model = new RechargeModel();

		bean.setRechargeId(4);
		bean.setMobileNumber("8602532462");
		bean.setAmount(430.00);
		bean.setRechargeDate(sdf.parse("1965-12-13"));

		model.Add(bean);
	}

	public static void testUpdate() throws Exception {

		RechargeBean bean = new RechargeBean();
		RechargeModel model = new RechargeModel();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		bean.setMobileNumber("7389340573");
		bean.setAmount(499.00);
		bean.setRechargeDate(sdf.parse("1971-11-13"));
		bean.setRechargeId(4);
		model.Update(bean);

	}

	public static void testDelete() throws Exception {

		RechargeBean bean = new RechargeBean();
		RechargeModel model = new RechargeModel();

		bean.setRechargeId(4);
		;
		;
		model.Delete(bean);

	}

	public static void testFindByPk() throws Exception {

		RechargeBean bean = new RechargeBean();
		RechargeModel model = new RechargeModel();

		bean = model.FindByPk(1);
		if (bean != null) {
			System.out.println(bean.getRechargeId());
			System.out.println(bean.getMobileNumber());
			System.out.println(bean.getAmount());
			System.out.println(bean.getRechargeDate());

		} else {

			System.out.println("user not found");
		}
	}

	private static void testSearch() throws Exception {

		RechargeBean bean = new RechargeBean();
		RechargeModel model = new RechargeModel();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		bean.setRechargeId(2);
		bean.setRechargeDate(sdf.parse("1987-12-13"));

		List<RechargeBean> list = model.Search(bean);

		if (list.size() == 0) {
			System.out.println("record not found");
		}

		Iterator<RechargeBean> it = list.iterator();

		while (it.hasNext()) {
			bean = it.next();
			System.out.println(bean.getRechargeId());
			System.out.println(bean.getMobileNumber());
			System.out.println(bean.getAmount());
			System.out.println(bean.getRechargeDate());

			System.out.println("------");

		}
	}
}
