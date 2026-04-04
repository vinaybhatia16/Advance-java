package com.rays.jdbc;

import java.util.Iterator;
import java.util.List;

public class TestStaff {
	public static void main(String[] args) throws Exception {
		 // testAdd();
		 // testUpdate();
		 //testDelete();
		 //testFindByPk();
		 testSearch();
	}

	public static void testAdd() throws Exception {

		StaffBean bean = new StaffBean();
		StaffModel model = new StaffModel();

		bean.setStaffId(7);
		bean.setStaffName("axxul");
		bean.setShift("evening");
		bean.setSalary(65000);

		model.Add(bean);

	}

	public static void testUpdate() throws Exception {

		StaffBean bean = new StaffBean();
		StaffModel model = new StaffModel();

		bean.setStaffName("vinay");
		bean.setShift("night");
		bean.setSalary(33000);
		bean.setStaffId(2);

		model.Update(bean);

	}

	public static void testDelete() throws Exception {

		StaffBean bean = new StaffBean();
		StaffModel model = new StaffModel();

		bean.setStaffId(7);
		model.Delete(bean);

	}

	public static void testFindByPk() throws Exception {

		StaffBean bean = new StaffBean();
		StaffModel model = new StaffModel();
		bean = model.FindByPk(3);
		if (bean != null) {
			System.out.println(bean.getStaffId());
			System.out.println(bean.getStaffName());
			System.out.println(bean.getShift());
			System.out.println(bean.getSalary());

		} else {

			System.out.println("user not found");
		}
	}

private static void testSearch() throws Exception {
	StaffBean bean = new StaffBean();
	StaffModel model = new StaffModel();

  //	
 //	bean.setStaffId(2);
  //	bean.setShift("morning");


	List<StaffBean> list = model.Search(bean);

	Iterator<StaffBean> it = list.iterator();

	while (it.hasNext()) {
		bean = it.next();

		System.out.println(bean.getStaffId());
		System.out.println(bean.getStaffName());
		System.out.println(bean.getShift());
		System.out.println(bean.getSalary());
		
		System.out.println("------");

	}
}
}
