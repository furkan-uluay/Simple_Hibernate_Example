package com.furkanuluay.javasrc;

import java.util.Iterator;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateTest {

	
	Configuration configuration = new Configuration().configure();
	StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
	SessionFactory factory = configuration.buildSessionFactory(builder.build());
	
	Session session;
	
	
	public static void main(String[] args) {
		Student student =new Student();
		HibernateTest test =new HibernateTest();
		
		
		//Testing
		test.insertHibernateData("Furkan","Uluay");
		test.selectHibernateData();
		test.updateHibernate(1, "Updated Name", "Updated Surname");
		test.deleteHibernateData(1);

	}

	//insert
	private void insertHibernateData(String stdName, String stdSurname){
		Student student =new Student();
		student.setStdName(stdName);
		student.setStdSurname(stdSurname);
		
		session = factory.openSession();
		session.beginTransaction();
		session.save(student);
		session.getTransaction().commit();
		session.close();
	}
	
	
	//get all data 
	private void selectHibernateData(){
		
		session =factory.openSession();
		session.beginTransaction();
		
		Criteria crit = session.createCriteria(Student.class);
		List results = crit.list();
		Iterator iter = results.iterator();
       
       while (iter.hasNext()) {
    	   Student student = (Student) iter.next();
    	   String msg =student.getStdId()+"\t"+student.getStdName()+"\t"+student.getStdSurname();
           System.out.println(msg);
       }
	}
	
	
	//get specific data using id
	private void selectHibernateData(int id){
		  session =factory.openSession();
		  session.beginTransaction();
		  Student student=(Student)session.get(Student.class, id);
		  session.close();
		  
		  System.out.println("Studen Id:"+student.getStdId());
		  System.out.println("Studen Name:"+student.getStdName());
		  System.out.println("Studen Surname:"+student.getStdSurname());
	}
	
	//update
	private void updateHibernate(int id,String stdName,String stdSurname){
		
		 session =factory.openSession();
		  session.beginTransaction();
		  Student student=(Student)session.get(Student.class, id);
		  student.setStdName(stdName);
		  student.setStdSurname(stdSurname);
		  session.update(student);
		  session.getTransaction().commit();
		  session.close();
	}
	
	//delete
	private void deleteHibernateData(int id){
		  session =factory.openSession();
		  session.beginTransaction();
		  Student student=(Student)session.get(Student.class, id);
		  session.delete(student);
		  session.getTransaction().commit();
		  session.close();
	}
	
}
