package com.fis.hibernate.helloworld;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.Test;

public class HibernateTest {

	@Test
	public void test() {
		System.out.println("test ...");
		//1.创建SessionFactory
		SessionFactory sessionFactory = null;
		
		Configuration configuration = new Configuration().configure();
		
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties())
																	  .buildServiceRegistry();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		//2.创建Session
		Session session = sessionFactory.openSession();
		//3.开启事务
		Transaction transaction = session.beginTransaction();
		//4.执行保存操作
		News news = new News("ABC", "Tiny", new Date(new java.util.Date().getTime()));
		session.save(news);
		//5.提交事务
		transaction.commit();
		//6.关闭session
		session.close();
		//7.关闭SessionFactory
		sessionFactory.close();
		
		
	}

}
