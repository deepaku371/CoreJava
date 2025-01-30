import java.util.ArrayList;
import java.util.Scanner;

/**
 * A simple Student Management System demonstrating Java concepts
 * Author: Claude
 * Date: 2024-01-30
 */
public class StudentManagementSystem {
    private ArrayList<Student> students;
    private Scanner scanner;

    // Constructor
    public StudentManagementSystem() {
        students = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    // Student class (inner class)
    private static class Student {
        private int id;
        private String name;
        private int age;
        private String grade;

        public Student(int id, String name, int age, String grade) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.grade = grade;
        }

        @Override
        public String toString() {
            return String.format("ID: %d | Name: %s | Age: %d | Grade: %s",
                    id, name, age, grade);
        }
    }

    // Add a new student
    private void addStudent() {
        System.out.println("\n=== Add New Student ===");
        
        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter student age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        System.out.print("Enter student grade: ");
        String grade = scanner.nextLine();

        Student student = new Student(id, name, age, grade);
        students.add(student);
        
        System.out.println("Student added successfully!");
    }

    // Display all students
    private void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("\nNo students registered yet.");
            return;
        }

        System.out.println("\n=== Student List ===");
        for (Student student : students) {
            System.out.println(student);
        }
    }

    // Search for a student by ID
    private void searchStudent() {
        System.out.print("\nEnter student ID to search: ");
        int searchId = scanner.nextInt();
        
        boolean found = false;
        for (Student student : students) {
            if (student.id == searchId) {
                System.out.println("Student found:");
                System.out.println(student);
                found = true;
                break;
            }
        }
        
        if (!found) {
            System.out.println("Student not found.");
        }
    }

    // Delete a student
    private void deleteStudent() {
        System.out.print("\nEnter student ID to delete: ");
        int deleteId = scanner.nextInt();
        
        boolean removed = students.removeIf(student -> student.id == deleteId);
        
        if (removed) {
            System.out.println("Student deleted successfully!");
        } else {
            System.out.println("Student not found.");
        }
    }

    // Main menu
    private void showMenu() {
        System.out.println("\n=== Student Management System ===");
        System.out.println("1. Add Student");
        System.out.println("2. Display All Students");
        System.out.println("3. Search Student");
        System.out.println("4. Delete Student");
        System.out.println("5. Exit");
        System.out.print("Enter your choice (1-5): ");
    }

    // Run the program
    public void run() {
        while (true) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            try {
                switch (choice) {
                    case 1:
                        addStudent();
                        break;
                    case 2:
                        displayStudents();
                        break;
                    case 3:
                        searchStudent();
                        break;
                    case 4:
                        deleteStudent();
                        break;
                    case 5:
                        System.out.println("\nThank you for using Student Management System!");
                        scanner.close();
                        return;
                    default:
                        System.out.println("\nInvalid choice. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
                scanner.nextLine(); // Clear the scanner buffer
            }
        }
    }

    // Main method
    public static void main(String[] args) {
        StudentManagementSystem sms = new StudentManagementSystem();
        sms.run();
    }
}