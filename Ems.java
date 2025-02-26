import java.util.Scanner;

class Person {
    private String name;
    private String dateOfJoining;

    Person (String name , String dateofJoining){
        this.name = name ;
        this.dateOfJoining= dateofJoining;
    }
    
    void setname(String name ){
        this.name = name ;
    }
    void setdateofJoining (String dateofJoining){
        this.dateOfJoining =dateofJoining ;
    }
   void getname(){
        System.out.println("Name of Employee : " + name);
   }
    void getdateofJoining(){
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
        this.salary += (this.salary * percentage)/100 ;
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
    double performanceBonus ;

    Director(String name, String dateOfJoining, int employeeId, Double salary, String department, Double bonus , double performanceBonus) {
        super(name, dateOfJoining, employeeId, salary, department);
        this.bonus = bonus;
        this.performanceBonus = performanceBonus ;
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

        System.out.println("Enter the employee name : ");
        String name = sc.nextLine();

        System.out.println("Enter the employee date of joining : ");
        String dateOfJoining = sc.nextLine();
        
        System.out.println("Enter your employee ID : ");
        int employeeId = sc.nextInt();
        
        System.out.println("Enter your salary (in lakhs per year ) : ");
        Double salary = sc.nextDouble();
      
        System.out.println("Enter the department of employee : ");
        sc.nextLine(); 
        String department = sc.nextLine();

        System.out.println("Enter the bonus of director (in lakhs per year): ");
        Double bonus = sc.nextDouble();

        System.out.println("Enter the performance bonus of director (in lakhs per year): ");
        double performanceBonus = sc.nextDouble();
        
        Director e1 = new Director(name, dateOfJoining, employeeId, salary, department, bonus, performanceBonus);

        e1.setname(name);
        e1.setdateofJoining(dateOfJoining);
        
        System.out.println();
        e1.getname();
        e1.getdateofJoining();
        
        System.out.println(" Employee full Details ...");
        e1.pdetails();

        System.out.println();  
        e1.salaryIncrement(10.0);
        e1.calculateTotalCompensation();
        
        sc.close();
    }
}