package com.rays.jdbc;

public class Marksheet1Bean {

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRollno() {
		return rollno;
	}

	public void setRollno(int rollno) {
		this.rollno = rollno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPhy() {
		return phy;
	}

	public void setPhy(int phy) {
		this.phy = phy;
	}

	public int getChm() {
		return chm;
	}

	public void setChm(int chm) {
		this.chm = chm;
	}

	public int getMaths() {
		return maths;
	}

	public void setMaths(int maths) {
		this.maths = maths;
	}

	private int id;
	private int rollno;
	private String name;
	private int phy;
	private int chm;
	private int maths;

}
