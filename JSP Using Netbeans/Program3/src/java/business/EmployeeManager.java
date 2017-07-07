/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import data.EmployeeManagerDA;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

/**
 *
 * @author fssco
 */
public class EmployeeManager {

    private ArrayList<Person> employees;
    private TreeMap<String, Person> employeeTree;

    public EmployeeManager() {
        employees = EmployeeManagerDA.getAllEmployees();
        
        employeeTree = new TreeMap<String, Person>();
        for (Person employee : employees) {
            employeeTree.put(Integer.toString(employee.getEmployeeID()), employee);
        }
    }

    /**
     * @return the employees
     */
    public ArrayList<Person> getEmployees() {
        return employees;
    }

    /**
     * @param employees the employees to set
     */
    public void setEmployees(ArrayList<Person> employees) {
        this.employees = employees;
        employeeTree = new TreeMap<String, Person>();
        for (Person employee : employees) {
            employeeTree.put(Integer.toString(employee.getEmployeeID()), employee);
        }
    }

    public ArrayList<Person> search(LocalDate searchDate) {
        ArrayList<Person> temp = new ArrayList<>();

        //
        temp.add(employees.get(0));

        return temp;
    }

    /**
     * @return the employeeTree
     */
    public TreeMap<String, Person> getEmployeeTree() {
        return employeeTree;
    }

    /**
     * @param employeeTree the employeeTree to set
     */
    public void setEmployeeTree(TreeMap<String, Person> employeeTree) {
        this.employeeTree = employeeTree;
    }
    
    public void putEmployeeTree(Person p) {
        this.employeeTree.put(Integer.toString(p.getEmployeeID()), p);
    }



}
