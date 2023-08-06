import java.util.*;

class Student {
    private String name;
    private String rollNumber;
    private String grade;
    // You can add any other relevant details to the student as instance variables.

    public Student(String name, String rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }

    // Getters and setters for the instance variables.

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Roll Number: " + rollNumber + ", Grade: " + grade;
    }
}

class StudentManagementSystem {
    private List<Student> students;

    public StudentManagementSystem() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public boolean removeStudent(String rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber().equals(rollNumber)) {
                students.remove(student);
                return true;
            }
        }
        return false;
    }

    public void searchStudent(String rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber().equals(rollNumber)) {
                System.out.println("Student found!");
                return;
            }
        }
        System.out.println("Student not found!");
    }

    public void displayAllStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }
}

// Example usage:
public class ThirdTask {
    public static void main(String[] args) {
        // Creating the student management system
        Scanner sc = new Scanner(System.in);
        StudentManagementSystem sms = new StudentManagementSystem();
        while(true){
            System.out.println("Please select an option: ");

            System.out.println("1. Add a Student\n2. Delete a Student\n3. Search a Student\n4. Display all Students");

            int n = sc.nextInt();
            switch(n){
                case 1:
                    System.out.println("Enter the rollnumber, name and grade of student: ");
                    String roll = sc.next();
                    String name1 = sc.nextLine();
                    String name = sc.nextLine();
                    String grade = sc.next();
                    Student st = new Student(name, roll, grade);
                    sms.addStudent(st);
                    System.out.println("Student added successfully!");
                    break;
                case 2:
                    System.out.println("Enter the roll number of the student to delete: ");
                    roll = sc.next();
                    sms.removeStudent(roll);
                    System.out.println("Student removed successfully!");
                    break;
                case 3:
                    System.out.println("Enter the roll number of the stuedent to search: ");
                    roll = sc.next();
                    sms.searchStudent(roll);
                    break;
                case 4:
                    System.out.println("All the students are: ");
                    sms.displayAllStudents();
                    break;
            }

            System.out.println("Do you want to perform another operation (y/n): ");
            char ch = sc.next().charAt(0);
            if(ch == 'n') break;
        }
    }
}
