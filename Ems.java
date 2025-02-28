import java.util.ArrayList;
import java.util.Scanner;

class Person {
    private String name;
    private String dateOfJoining;

    Person(String name, String dateofJoining) {
        this.name = name;
        this.dateOfJoining = dateofJoining;
    }

    void setname(String name) {
        this.name = name;
    }

    void setdateofJoining(String dateofJoining) {
        this.dateOfJoining = dateofJoining;
    }

    void getname() {
        System.out.println("Name of Employee : " + name);
    }

    void getdateofJoining() {
        System.out.println("Date of Joining : " + dateOfJoining);
    }

    void pdetails() {
        getname();
        getdateofJoining();
    }
}

class Employee extends Person {
    int employeeId;
    Double salary;

    Employee(String name, String dateOfJoining, int employeeId, Double salary) {
        super(name, dateOfJoining);
        this.employeeId = employeeId;
        this.salary = salary;
    }

    @Override
    void pdetails() {
        super.pdetails();
        System.out.println("Employee ID : " + employeeId);
        System.out.printf("Employee Salary : RS.%.2f per year\n", salary * 100000);
    }

    void salaryIncrement(Double percentage) {
        this.salary += (this.salary * percentage) / 100;
        System.out.printf("Employee Salary after increment : RS.%.2f per year\n", salary * 100000);
    }
}

class Manager extends Employee {
    String department;

    Manager(String name, String dateOfJoining, int employeeId, Double salary, String department) {
        super(name, dateOfJoining, employeeId, salary);
        this.department = department;
    }

    @Override
    void pdetails() {
        super.pdetails();
        System.out.println("Department of employee  : " + department);
    }
}

class Director extends Manager {
    Double bonus;
    double performanceBonus;

    Director(String name, String dateOfJoining, int employeeId, Double salary, String department, Double bonus,
            double performanceBonus) {
        super(name, dateOfJoining, employeeId, salary, department);
        this.bonus = bonus;
        this.performanceBonus = performanceBonus;
    }

    @Override
    void pdetails() {
        super.pdetails();
        System.out.printf("Director Bonus : RS.%.2f per year\n", bonus * 100000);
        System.out.printf("Performance based Bonus  : RS.%.2f per year\n", performanceBonus * 100000);
    }

    void calculateTotalCompensation() {
        Double totalcompansation = (this.salary + this.bonus + this.performanceBonus) * 100000;
        System.out.printf("Total compansation : RS.%.2f per year\n", totalcompansation);
    }
}

public class Ems {
    
    public static void main(String[] args) {

        System.out.println();
        Scanner sc = new Scanner(System.in);
        ArrayList<Employee> employee = new ArrayList<>();
        
        while (true){
       
            System.out.println("What type of Employee you want to add\n " );
            System.out.println("1. Director\n2. Manager\n3. Employee\n4. Exit \n ");
            int choice = sc.nextInt();
            
            if( choice == 4) break;
            System.out.println("Enter the name of Employee : ");
            String name = sc.next();
            System.out.println("Enter the date of joining of Employee (DD-MM-YYYY): ");
            String dateofbirth = sc.next();
            System.out.println("Enter the Employee ID : ");
            int employeeId = sc.nextInt();
            System.out.println("Enter the salary of Employee (In lakhs per year ) : ");
            Double salary = sc.nextDouble();
            if (choice ==3){
                employee.add(new Employee(name, dateofbirth, employeeId, salary));
            }
                else{
                    System.out.println("Enter the department of Employee : ");
                    String department = sc.next();
                    if (choice == 2){
                        employee.add(new Manager(name, dateofbirth, employeeId, salary, department));
                    }
                    else{
                        System.out.println("Enter the bonus of Director (In lakks per year ): ");
                        Double bonus = sc.nextDouble();
                        System.out.println("Enter the performance bonus of Director (In lakhs per year ): ");
                        double performanceBonus = sc.nextDouble();
                        employee.add(new Director(name, dateofbirth, employeeId, salary, department, bonus, performanceBonus));
                    }
                }

                System.out.println("Do you want to add another employee (y/n): ");
                
                char ch = sc.next().charAt(0);
                if (ch == 'n' || ch == 'N') break;
            } 

            System.out.println("\n=== Employee Details ===");
            for (Employee emp : employee) {
                emp.pdetails();
                emp.salaryIncrement(10.0);
                if (emp instanceof Director) {
                    ((Director) emp).calculateTotalCompensation();
                }
                System.out.println();
            }
        
            sc.close();
        }
 }