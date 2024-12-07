package com.klu.jfsd.HibernateStudentApp;




import java.util.Scanner;

import com.klu.jfsd.dao.StudentDAO;
import com.klu.jfsd.entity.Student;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentDAO studentDAO = new StudentDAO();

        while (true) {
            System.out.println("1. Insert Student");
            System.out.println("2. Fetch Student by ID");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter name: ");
                    String name = scanner.next();
                    System.out.print("Enter gender: ");
                    String gender = scanner.next();
                    System.out.print("Enter department: ");
                    String department = scanner.next();
                    System.out.print("Enter program: ");
                    String program = scanner.next();
                    System.out.print("Enter DOB (yyyy-mm-dd): ");
                    String dob = scanner.next();
                    System.out.print("Enter contact number: ");
                    String contactNumber = scanner.next();
                    System.out.print("Enter graduation status: ");
                    String graduationStatus = scanner.next();
                    System.out.print("Enter CGPA: ");
                    double cgpa = scanner.nextDouble();
                    System.out.print("Enter number of backlogs: ");
                    int backlogs = scanner.nextInt();

                    Student student = new Student();
                    student.setName(name);
                    student.setGender(gender);
                    student.setDepartment(department);
                    student.setProgram(program);
                    student.setDob(dob);
                    student.setContactNumber(contactNumber);
                    student.setGraduationStatus(graduationStatus);
                    student.setCgpa(cgpa);
                    student.setBacklogs(backlogs);

                    studentDAO.insertStudent(student);
                    System.out.println("Student inserted successfully.");
                }
                case 2 -> {
                    System.out.print("Enter Student ID: ");
                    int id = scanner.nextInt();
                    Student student = studentDAO.getStudentById(id);
                    System.out.println(student != null ? student : "Student not found.");
                }
                case 3 -> {
                    System.out.print("Enter Student ID: ");
                    int id = scanner.nextInt();
                    System.out.println("Enter new details:");
                    System.out.print("Name: ");
                    String name = scanner.next();
                    System.out.print("Gender: ");
                    String gender = scanner.next();
                    System.out.print("Department: ");
                    String department = scanner.next();
                    System.out.print("Program: ");
                    String program = scanner.next();
                    System.out.print("DOB (yyyy-mm-dd): ");
                    String dob = scanner.next();
                    System.out.print("Contact number: ");
                    String contactNumber = scanner.next();
                    System.out.print("Graduation status: ");
                    String graduationStatus = scanner.next();
                    System.out.print("CGPA: ");
                    double cgpa = scanner.nextDouble();
                    System.out.print("Number of backlogs: ");
                    int backlogs = scanner.nextInt();

                    Student updatedStudent = new Student();
                    updatedStudent.setName(name);
                    updatedStudent.setGender(gender);
                    updatedStudent.setDepartment(department);
                    updatedStudent.setProgram(program);
                    updatedStudent.setDob(dob);
                    updatedStudent.setContactNumber(contactNumber);
                    updatedStudent.setGraduationStatus(graduationStatus);
                    updatedStudent.setCgpa(cgpa);
                    updatedStudent.setBacklogs(backlogs);

                    studentDAO.updateStudent(id, updatedStudent);
                    System.out.println("Student updated successfully.");
                }
                case 4 -> {
                    System.out.print("Enter Student ID: ");
                    int id = scanner.nextInt();
                    studentDAO.deleteStudent(id);
                    System.out.println("Student deleted successfully.");
                }
                case 5 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }
}
