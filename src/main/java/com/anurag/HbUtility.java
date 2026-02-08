package com.anurag;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import com.anurag.entity.Book;
import com.anurag.entity.User;

public class HbUtility {
	public static SessionFactory getSessionFactory() {
		Configuration cfg = new Configuration();
		
		
		Properties p = new Properties();
		

		p.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
		p.put(Environment.URL, "jdbc:mysql://localhost:3306/bookdb?createDatabaseIfNotExist=true");
		p.put(Environment.USER, "root");
		p.put(Environment.PASS, "Anurag123#");
		p.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
		p.put(Environment.HBM2DDL_AUTO, "update");
		
		
		cfg.setProperties(p);
		cfg.addAnnotatedClass(Book.class);
		cfg.addAnnotatedClass(User.class);
		
		return cfg.buildSessionFactory();
	}
}
