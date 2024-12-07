package com.klu.jfsd.dao;



import org.hibernate.Session;
import org.hibernate.Transaction;

import com.klu.jfsd.entity.Student;
import com.klu.jfsd.util.HibernateUtil;

import java.util.Scanner;

public class StudentDAO {
	public void insertStudent(Student student) {
	    Transaction transaction = null;
	    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	        transaction = session.beginTransaction();
	        session.save(student);  // Save student data
	        transaction.commit();  // Commit transaction
	    } catch (Exception e) {
	        if (transaction != null && transaction.getStatus().canRollback()) {
	            transaction.rollback();  // Rollback safely
	        }
	        e.printStackTrace();  // Log detailed exception
	    }
	}


    public Student getStudentById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Student.class, id);
        }
    }

    public void updateStudent(int id, Student updatedDetails) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Student existingStudent = session.get(Student.class, id);
            if (existingStudent != null) {
                existingStudent.setName(updatedDetails.getName());
                existingStudent.setGender(updatedDetails.getGender());
                existingStudent.setDepartment(updatedDetails.getDepartment());
                existingStudent.setProgram(updatedDetails.getProgram());
                existingStudent.setDob(updatedDetails.getDob());
                existingStudent.setContactNumber(updatedDetails.getContactNumber());
                existingStudent.setGraduationStatus(updatedDetails.getGraduationStatus());
                existingStudent.setCgpa(updatedDetails.getCgpa());
                existingStudent.setBacklogs(updatedDetails.getBacklogs());
                session.update(existingStudent);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public void deleteStudent(int id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Student student = session.get(Student.class, id);
            if (student != null) {
                session.delete(student);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }
}