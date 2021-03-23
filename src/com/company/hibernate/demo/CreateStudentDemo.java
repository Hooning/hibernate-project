package com.company.hibernate.demo;

import com.company.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentDemo {
  public static void main(String[] args) {
    // create session factory
    SessionFactory sessionFactory = new Configuration()
                                      .configure("hibernate.cfg.xml")
                                      .addAnnotatedClass(Student.class)
                                      .buildSessionFactory();
    // create session
    Session session = sessionFactory.getCurrentSession();

    // use the session object to save Java Object
    try {
      System.out.println("Creating new student object...");
      // create a student object
      Student tempStudent = new Student("David", "Cho", "david.hoontime@gmail.com");
      // start a transaction
      session.beginTransaction();
      // save the student object
      System.out.println("Saving the student...");
      session.save(tempStudent);
      // commit transaction
      session.getTransaction().commit();
      System.out.println("Everything Done!");
    } finally {
      sessionFactory.close();
    }

  }
}







