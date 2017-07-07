/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.time.LocalDate;
import util.iYearlyCost;

/**
 *
 * @author js190325
 */
public class EmpSalary extends Person {
    private double salary;
    
    public EmpSalary(String firstName, String middleName, String lastName, int employeeID, LocalDate birthDate, LocalDate hireDate) {
        super(firstName, middleName, lastName, employeeID, birthDate, hireDate);
    }
    
    public EmpSalary(String firstName, String middleName, String lastName, LocalDate birthDate, LocalDate hireDate, double salary) {
        super(firstName, middleName, lastName, birthDate, hireDate);
        this.salary = salary;
    }
    
    public EmpSalary(String firstName, String middleName, String lastName, int employeeID, LocalDate birthDate, LocalDate hireDate, double salary) {
        super(firstName, middleName, lastName, employeeID, birthDate, hireDate);
        this.salary = salary;
    }

    public EmpSalary() {
        super();
    }

    /**
     * @return the salary
     */
    public double getSalary() {
        return salary;
    }

    /**
     * @param salary the salary to set
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }
    
    // iYearlyCost implementation
    @Override
    public double getYearlyCost() {
        return this.salary;
    }
    
}
