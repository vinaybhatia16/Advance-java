package com.rays.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

public class UserTest {
	public static void main(String[] args) throws Exception {
		
		//testRegistration();
		 testAuthentication();
	
	
	}
	
	

	public static void testRegistration() throws Exception{
		
		UserBean bean = new UserBean();
		UserModel model = new UserModel();
		
		bean.setId(7);
		bean.setUsername("bhatia");
		bean.setPassword("bhatia123");
		
		bean.setEmail("bhatia123@gmail.com");
		bean.setMobile("9326278640");
		 model.Registration(bean);
		}

	public static void testAuthentication() throws Exception {

		UserBean bean = new UserBean();
         UserModel model = new UserModel();
		bean = model.Authentication("vinay" , "1234");
		if (bean != null) {
//			System.out.println(bean.getId());
//			System.out.println(bean.getUsername());
//			System.out.println(bean.getPassword());
//			System.out.println(bean.getEmail());
//			System.out.println(bean.getMobile());
			System.out.println("Authentication successfull");
		} else {

			System.out.println("user not found");
		}
	}
	
}
	
