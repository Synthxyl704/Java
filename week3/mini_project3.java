import java.io.*;
import java.util.*;

class Employee {
    int id;
    String name, department;
    double salary;

    Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String toString() {
        return id + "," + name + "," + department + "," + salary;
    }
}

public class EmployeeManagement {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter Employee ID: ");
            int id = sc.nextInt();
            sc.nextLine(); // consume newline

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Department: ");
            String dept = sc.nextLine();

            System.out.print("Enter Salary: ");
            double salary = sc.nextDouble();

            employees.add(new Employee(id, name, dept, salary));

            // Save to file
            FileWriter fw = new FileWriter("employees.txt");
            for (Employee e : employees) {
                fw.write(e + "\n");
            }
            fw.close();

            System.out.println("\nData saved successfully.\n");

            // Load from file
            BufferedReader br = new BufferedReader(new FileReader("employees.txt"));
            String line;
            System.out.println("Employee Records:");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();

        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Enter numbers for ID and Salary.");
        } catch (IOException e) {
            System.out.println("File Error: " + e.getMessage());
        }

        sc.close();
    }
}
