package com.rays.jdbc;

import java.util.Iterator;
import java.util.List;

public class TestMarksheet1Model {

	public static void main(String[] args) throws Exception {

		// testAdd();
		// testUpdate();
		// testDelete();
		// testFindByPk();
		// testFindByName();
		testSearch();
	}

	public static void testAdd() throws Exception {

		Marksheet1Bean bean = new Marksheet1Bean();
		Marksheet1Model model = new Marksheet1Model();

		bean.setId(5);
		bean.setRollno(5);
		bean.setName("rahul");
		bean.setPhy(44);
		bean.setChm(70);
		bean.setMaths(90);

		model.add(bean);

	}

	public static void testUpdate() throws Exception {

		Marksheet1Bean bean = new Marksheet1Bean();
		Marksheet1Model model = new Marksheet1Model();

		bean.setId(3);
		bean.setRollno(3);
		bean.setName("ram");
		bean.setPhy(33);
		bean.setChm(33);
		bean.setMaths(33);

		model.Update(bean);

	}

	public static void testDelete() throws Exception {

		Marksheet1Bean bean = new Marksheet1Bean();
		Marksheet1Model model = new Marksheet1Model();

		bean.setId(1);
		model.Delete(bean);

	}

	public static void testFindByPk() throws Exception {

		Marksheet1Bean bean = new Marksheet1Bean();
		Marksheet1Model model = new Marksheet1Model();
		bean = model.FindByPk(3);
		if (bean != null) {
			System.out.println(bean.getId());
			System.out.println(bean.getRollno());
			System.out.println(bean.getName());
			System.out.println(bean.getPhy());
			System.out.println(bean.getChm());
		} else {

			System.out.println("user not found");
		}
	}

	public static void testFindByName() throws Exception {

		Marksheet1Bean bean = new Marksheet1Bean();
		Marksheet1Model model = new Marksheet1Model();
		bean = model.FindByName("dhoni");
		if (bean != null) {
			System.out.println(bean.getId());
			System.out.println(bean.getRollno());
			System.out.println(bean.getName());
			System.out.println(bean.getPhy());
			System.out.println(bean.getChm());
		} else {

			System.out.println("user not found");
		}
	}

	private static void testSearch() throws Exception {

		Marksheet1Bean bean = new Marksheet1Bean();
		Marksheet1Model model = new Marksheet1Model();

		// bean.setId(2);
		// bean.setName("nushka");
		// bean.setMaths(65);
		//bean.setPhy(44);

		List<Marksheet1Bean> list = model.Search(bean ,2 ,2 );

		Iterator<Marksheet1Bean> it = list.iterator();

		while (it.hasNext()) {
			bean = it.next();

			System.out.println(bean.getId());
			System.out.println(bean.getRollno());
			System.out.println(bean.getName());
			System.out.println(bean.getMaths());
			System.out.println(bean.getChm());
			System.out.println(bean.getPhy());
			System.out.println("------");

		}
	}
}