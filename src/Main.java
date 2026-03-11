//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.ArrayList;

abstract class Employee{
    public String name;
    private int id;

    public  Employee(String name, int id){
        this.name = name;
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public int getId(){
        return id;
    }

    public abstract double calculateSalary();

    @Override
    public String toString(){
        return "Employee [Name : "+ name + ", Id : " + id + ", Salary : " + calculateSalary() + "]";
    }

}

class FullTimeEmployee extends Employee{

    private double monthlySalary;

    public FullTimeEmployee(String name, int id, double monthlySalary){
        super(name, id);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculateSalary(){
        return monthlySalary;
    }

}

class PartTimeEmployee extends Employee{

    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(String name, int id, int hoursWorked, double hourlyRate){
        super(name, id);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculateSalary(){
        return hoursWorked * hourlyRate;
    }

}

class PayrollSystem{

    private ArrayList<Employee> employeeList;

    public PayrollSystem(){
        employeeList = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }

    public void removeEmployee(int id){
        Employee employeeToRemove = null;
        for(Employee employee : employeeList){
            if(employee.getId() == id){
                employeeToRemove = employee;
                break;
            }
        }
        if(employeeToRemove != null){
            employeeList.remove(employeeToRemove);
        }
    }

    public void displayEmployees(){
        for(Employee employee : employeeList){
            System.out.println(employee);
        }
    }
}

public class Main{
    public static void main(String vars[]){
        PayrollSystem payrollSystem = new PayrollSystem();
        FullTimeEmployee ep1 = new FullTimeEmployee("Varshitha", 1, 1500000.0);
        PartTimeEmployee ep2 = new PartTimeEmployee("Sathwik", 2, 60, 200);

        payrollSystem.addEmployee(ep1);
        payrollSystem.addEmployee(ep2);

        System.out.println("Initial Employee Details : ");
        payrollSystem.displayEmployees();
        System.out.println("Removing Employees");
        payrollSystem.removeEmployee(2);
        System.out.println("Rmaining Employees");
        payrollSystem.displayEmployees();
    }
}