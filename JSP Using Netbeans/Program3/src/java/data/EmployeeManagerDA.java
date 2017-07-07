 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import business.EmpHourly;
import business.EmpSalary;
import business.Person;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.util.ArrayList;

/**
 *
 * @author fssco
 */
public class EmployeeManagerDA {
    
    public static ArrayList<Person> getAllEmployees(){
        ArrayList<Person> all = new ArrayList<Person>();
        
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String query = "SELECT * FROM Employee";
        PreparedStatement ps = null;
        try {
            
            ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery(query);
            
            while (rs.next()) {
                if (rs.getDouble("Salary") == 0 && rs.getDouble("Rate") == 0) {
                    Person p = new Person();
                    p.setEmployeeID(rs.getInt("EmployeeID"));
                    p.setFirstName(rs.getString("FirstName"));
                    p.setMiddleName(rs.getString("MiddleName"));
                    p.setLastName(rs.getString("LastName"));
                    p.setBirthDate(rs.getDate("BirthDate").toLocalDate());
                    p.setHireDate(rs.getDate("HireDate").toLocalDate());
                    all.add(p);
                }
                else if (rs.getDouble("Rate") == 0 && rs.getDouble("AvgWeeklyHours") == 0) {
                    EmpSalary sp = new EmpSalary();
                    sp.setEmployeeID(rs.getInt("EmployeeID"));
                    sp.setFirstName(rs.getString("FirstName"));
                    sp.setMiddleName(rs.getString("MiddleName"));
                    sp.setLastName(rs.getString("LastName"));
                    sp.setBirthDate(rs.getDate("BirthDate").toLocalDate());
                    sp.setHireDate(rs.getDate("HireDate").toLocalDate());
                    sp.setSalary(rs.getDouble("Salary"));
                    all.add(sp);
                }
                else {
                    EmpHourly hp = new EmpHourly();
                    hp.setEmployeeID(rs.getInt("EmployeeID"));
                    hp.setFirstName(rs.getString("FirstName"));
                    hp.setMiddleName(rs.getString("MiddleName"));
                    hp.setLastName(rs.getString("LastName"));
                    hp.setBirthDate(rs.getDate("BirthDate").toLocalDate());
                    hp.setHireDate(rs.getDate("HireDate").toLocalDate());
                    hp.setRate(rs.getDouble("Rate"));
                    hp.setAvgWeeklyHours(rs.getDouble("AvgWeeklyHours"));
                    all.add(hp);
                }
            }
            rs.close();
        } catch (SQLException e) {
            
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
        
        
        return all;
    }
    
    public static Person getEmployeeByID(int id) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String query = "SELECT * FROM Employee "
                     + "WHERE EmployeeID = ?";
        PreparedStatement ps = null;
        Person employee = new Person();
        try {
            ps.setInt(1, id);
            ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery(query);
            
            if (rs.next()) {
                if (rs.getDouble("Salary") == 0 && rs.getDouble("Rate") == 0) {
                    Person p = new Person();
                    p.setEmployeeID(rs.getInt("EmployeeID"));
                    p.setFirstName(rs.getString("FirstName"));
                    p.setMiddleName(rs.getString("MiddleName"));
                    p.setLastName(rs.getString("LastName"));
                    p.setBirthDate(rs.getDate("BirthDate").toLocalDate());
                    p.setHireDate(rs.getDate("HireDate").toLocalDate());
                    employee = p;
                }
                else if (rs.getDouble("Rate") == 0 && rs.getDouble("AvgWeeklyHours") == 0) {
                    EmpSalary sp = new EmpSalary();
                    sp.setEmployeeID(rs.getInt("EmployeeID"));
                    sp.setFirstName(rs.getString("FirstName"));
                    sp.setMiddleName(rs.getString("MiddleName"));
                    sp.setLastName(rs.getString("LastName"));
                    sp.setBirthDate(rs.getDate("BirthDate").toLocalDate());
                    sp.setHireDate(rs.getDate("HireDate").toLocalDate());
                    sp.setSalary(rs.getDouble("Salary"));
                    employee = sp;
                }
                else {
                    EmpHourly hp = new EmpHourly();
                    hp.setEmployeeID(rs.getInt("EmployeeID"));
                    hp.setFirstName(rs.getString("FirstName"));
                    hp.setMiddleName(rs.getString("MiddleName"));
                    hp.setLastName(rs.getString("LastName"));
                    hp.setBirthDate(rs.getDate("BirthDate").toLocalDate());
                    hp.setHireDate(rs.getDate("HireDate").toLocalDate());
                    hp.setRate(rs.getDouble("Rate"));
                    hp.setAvgWeeklyHours(rs.getDouble("AvgWeeklyHours"));
                    employee = hp;
                }
            }
            rs.close();
        } catch (SQLException e) {
            
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
        return employee;
    }
    
    public static ArrayList<Person> findHireDateBefore(LocalDate dateToCompare){
        ArrayList<Person> before = new ArrayList<Person>();
        
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String query = "SELECT * FROM Employee";
        PreparedStatement ps = null;
        try {
            
            ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery(query);
            
            while (rs.next()) {
                if (rs.getDouble("Salary") == 0 && rs.getDouble("Rate") == 0) {
                    Person p = new Person();
                    p.setEmployeeID(rs.getInt("EmployeeID"));
                    p.setFirstName(rs.getString("FirstName"));
                    p.setMiddleName(rs.getString("MiddleName"));
                    p.setLastName(rs.getString("LastName"));
                    p.setBirthDate(rs.getDate("BirthDate").toLocalDate());
                    p.setHireDate(rs.getDate("HireDate").toLocalDate());
                    if (p.getHireDate().isBefore(dateToCompare)) {
                        before.add(p);
                    }
                }
                else if (rs.getDouble("Rate") == 0 && rs.getDouble("AvgWeeklyHours") == 0) {
                    EmpSalary sp = new EmpSalary();
                    sp.setEmployeeID(rs.getInt("EmployeeID"));
                    sp.setFirstName(rs.getString("FirstName"));
                    sp.setMiddleName(rs.getString("MiddleName"));
                    sp.setLastName(rs.getString("LastName"));
                    sp.setBirthDate(rs.getDate("BirthDate").toLocalDate());
                    sp.setHireDate(rs.getDate("HireDate").toLocalDate());
                    sp.setSalary(rs.getDouble("Salary"));
                    if (sp.getHireDate().isBefore(dateToCompare)) {
                        before.add(sp);
                    }
                }
                else {
                    EmpHourly hp = new EmpHourly();
                    hp.setEmployeeID(rs.getInt("EmployeeID"));
                    hp.setFirstName(rs.getString("FirstName"));
                    hp.setMiddleName(rs.getString("MiddleName"));
                    hp.setLastName(rs.getString("LastName"));
                    hp.setBirthDate(rs.getDate("BirthDate").toLocalDate());
                    hp.setHireDate(rs.getDate("HireDate").toLocalDate());
                    hp.setRate(rs.getDouble("Rate"));
                    hp.setAvgWeeklyHours(rs.getDouble("AvgWeeklyHours"));
                    if (hp.getHireDate().isBefore(dateToCompare)) {
                        before.add(hp);
                    }
                }
            }
            rs.close();
        } catch (SQLException e) {
            
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
        return before;
    }
    
    public static ArrayList<Person> findHireDateAfter(LocalDate dateToCompare){
        ArrayList<Person> after = new ArrayList<Person>();
        
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String query = "SELECT * FROM Employee";
        PreparedStatement ps = null;
        try {
            
            ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery(query);
            
            while (rs.next()) {
                if (rs.getDouble("Salary") == 0 && rs.getDouble("Rate") == 0) {
                    Person p = new Person();
                    p.setEmployeeID(rs.getInt("EmployeeID"));
                    p.setFirstName(rs.getString("FirstName"));
                    p.setMiddleName(rs.getString("MiddleName"));
                    p.setLastName(rs.getString("LastName"));
                    p.setBirthDate(rs.getDate("BirthDate").toLocalDate());
                    p.setHireDate(rs.getDate("HireDate").toLocalDate());
                    if (p.getHireDate().isAfter(dateToCompare)) {
                        after.add(p);
                    }
                }
                else if (rs.getDouble("Rate") == 0 && rs.getDouble("AvgWeeklyHours") == 0) {
                    EmpSalary sp = new EmpSalary();
                    sp.setEmployeeID(rs.getInt("EmployeeID"));
                    sp.setFirstName(rs.getString("FirstName"));
                    sp.setMiddleName(rs.getString("MiddleName"));
                    sp.setLastName(rs.getString("LastName"));
                    sp.setBirthDate(rs.getDate("BirthDate").toLocalDate());
                    sp.setHireDate(rs.getDate("HireDate").toLocalDate());
                    sp.setSalary(rs.getDouble("Salary"));
                    if (sp.getHireDate().isAfter(dateToCompare)) {
                        after.add(sp);
                    }
                }
                else {
                    EmpHourly hp = new EmpHourly();
                    hp.setEmployeeID(rs.getInt("EmployeeID"));
                    hp.setFirstName(rs.getString("FirstName"));
                    hp.setMiddleName(rs.getString("MiddleName"));
                    hp.setLastName(rs.getString("LastName"));
                    hp.setBirthDate(rs.getDate("BirthDate").toLocalDate());
                    hp.setHireDate(rs.getDate("HireDate").toLocalDate());
                    hp.setRate(rs.getDouble("Rate"));
                    hp.setAvgWeeklyHours(rs.getDouble("AvgWeeklyHours"));
                    if (hp.getHireDate().isAfter(dateToCompare)) {
                        after.add(hp);
                    }
                }
            }
            rs.close();
        } catch (SQLException e) {
            
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
        return after;
    }
    
    public static ArrayList<Person> findYearlyCost(double yearlyCost, String comparison) {
        ArrayList<Person> queriedEmployees = new ArrayList<>();
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        String query = "";
        if (yearlyCost == 0) {
            if (comparison.equals("equal")) {
                query = "SELECT * FROM employee "
                      + "WHERE Salary IS NULL AND "
                      + "AvgWeeklyHours IS NULL AND "
                      + "Rate IS NULL"; 
            }
            else if (comparison.equals("more")) {
                query = "SELECT * FROM employee " 
                  + "WHERE Salary > ? OR "
                  + "(AvgWeeklyHours * Rate * 52) > ?";
            }
        } 
        else {
            if (comparison.equals("equal")) {
                query = "SELECT * FROM employee " 
                      + "WHERE Salary = ? OR "
                      + "(AvgWeeklyHours * Rate * 52) = ?";
            }
            else if (comparison.equals("more")) {
                query = "SELECT * FROM employee " 
                      + "WHERE Salary > ? OR "
                      + "(AvgWeeklyHours * Rate * 52) > ?";
            }
            else if (comparison.equals("less")) {
                query = "SELECT * FROM employee " 
                      + "WHERE Salary < ? OR "
                      + "(AvgWeeklyHours * Rate * 52) < ? OR "
                      + "(Salary IS NULL AND "
                      + "AvgWeeklyHours IS NULL AND "
                      + "Rate IS NULL)";
            }
        }
        
        try {
            ps = connection.prepareStatement(query);
            if (yearlyCost != 0 || (yearlyCost == 0 && comparison.equals("more"))) {
                ps.setDouble(1, yearlyCost);
                ps.setDouble(2, yearlyCost);
            }
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                if (rs.getDouble("Salary") == 0 && rs.getDouble("Rate") == 0) {
                    Person p = new Person();
                    p.setEmployeeID(rs.getInt("EmployeeID"));
                    p.setFirstName(rs.getString("FirstName"));
                    p.setMiddleName(rs.getString("MiddleName"));
                    p.setLastName(rs.getString("LastName"));
                    p.setBirthDate(rs.getDate("BirthDate").toLocalDate());
                    p.setHireDate(rs.getDate("HireDate").toLocalDate());
                    queriedEmployees.add(p);
                }
                else if (rs.getDouble("Rate") == 0 && rs.getDouble("AvgWeeklyHours") == 0) {
                    EmpSalary sp = new EmpSalary();
                    sp.setEmployeeID(rs.getInt("EmployeeID"));
                    sp.setFirstName(rs.getString("FirstName"));
                    sp.setMiddleName(rs.getString("MiddleName"));
                    sp.setLastName(rs.getString("LastName"));
                    sp.setBirthDate(rs.getDate("BirthDate").toLocalDate());
                    sp.setHireDate(rs.getDate("HireDate").toLocalDate());
                    sp.setSalary(rs.getDouble("Salary"));
                    queriedEmployees.add(sp);
                }
                else {
                    EmpHourly hp = new EmpHourly();
                    hp.setEmployeeID(rs.getInt("EmployeeID"));
                    hp.setFirstName(rs.getString("FirstName"));
                    hp.setMiddleName(rs.getString("MiddleName"));
                    hp.setLastName(rs.getString("LastName"));
                    hp.setBirthDate(rs.getDate("BirthDate").toLocalDate());
                    hp.setHireDate(rs.getDate("HireDate").toLocalDate());
                    hp.setRate(rs.getDouble("Rate"));
                    hp.setAvgWeeklyHours(rs.getDouble("AvgWeeklyHours"));
                    queriedEmployees.add(hp);
                }
            }
            rs.close();
            
        } catch (SQLException e) {
            queriedEmployees = null;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
        return queriedEmployees;
    }
    
    public static int addEmployee(Person employee) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        try {
            String query = "";
            if (employee.getClass().toString().equals("class business.Person")) {
                query = "INSERT INTO Employee (FirstName, MiddleName, LastName, BirthDate, HireDate) "
                        + "VALUES (?, ?, ?, ?, ?)";
                ps = connection.prepareStatement(query);
                ps.setString(1, employee.getFirstName());
                ps.setString(2, employee.getMiddleName());
                ps.setString(3, employee.getLastName());
                ps.setDate(4, Date.valueOf(employee.getBirthDate()));
                ps.setDate(5, Date.valueOf(employee.getHireDate()));
            }
            else if (employee.getClass().toString().equals("class business.EmpSalary")) {
                EmpSalary salary = (EmpSalary) employee;
                query = "INSERT INTO Employee (FirstName, MiddleName, LastName, BirthDate, HireDate, Salary) "
                        + "VALUES (?, ?, ?, ?, ?, ?)";
                ps = connection.prepareStatement(query);
                ps.setString(1, employee.getFirstName());
                ps.setString(2, employee.getMiddleName());
                ps.setString(3, employee.getLastName());
                ps.setDate(4, Date.valueOf(employee.getBirthDate()));
                ps.setDate(5, Date.valueOf(employee.getHireDate()));
                ps.setDouble(6, salary.getSalary());
            }
            else if (employee.getClass().toString().equals("class business.EmpHourly")) {
                EmpHourly hourly = (EmpHourly) employee;                
                query = "INSERT INTO Employee (FirstName, MiddleName, LastName, BirthDate, HireDate, Rate, AvgWeeklyhours) "
                        + "VALUES (?, ?, ?, ?, ?, ?, ?)";
                ps = connection.prepareStatement(query);
                ps.setString(1, employee.getFirstName());
                ps.setString(2, employee.getMiddleName());
                ps.setString(3, employee.getLastName());
                ps.setDate(4, Date.valueOf(employee.getBirthDate()));
                ps.setDate(5, Date.valueOf(employee.getHireDate()));
                ps.setDouble(6, hourly.getRate());
                ps.setDouble(7, hourly.getAvgWeeklyHours());
            }
            ps.executeUpdate();
            ps.close();
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
            
            pool = ConnectionPool.getInstance();
            connection = pool.getConnection();
            ps = connection.prepareStatement("SELECT last_insert_id() FROM Employee");
            ResultSet rs = ps.executeQuery("SELECT last_insert_id() FROM Employee");
            int lastid = -1;
            if (rs.next()) {
                lastid = rs.getInt("last_insert_id()");
            }
            return lastid;
        } catch (SQLException e) {
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
    public static int addAllEmployees(ArrayList<Person> employees) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        int result = 0;
        try {
            for (Person employee: employees) {
                ps.setString(1, employee.getFirstName());
                ps.setString(2, employee.getMiddleName());
                ps.setString(3, employee.getLastName());
                ps.setDate(4, Date.valueOf(employee.getBirthDate()));
                ps.setDate(5, Date.valueOf(employee.getHireDate()));
                String query = "";
                if (employee.getClass().equals("class business.Person")) {
                    query = "INSERT INTO Employee (FirstName, MiddleName, LastName, BirthDate, HireDate) "
                            + "VALUES (?, ?, ?, ?, ?)";
                }
                else if (employee.getClass().equals("class business.EmpSalary")) {
                    EmpSalary salary = (EmpSalary) employee;
                    ps.setDouble(6, salary.getSalary());
                    query = "INSERT INTO Employee (FirstName, MiddleName, LastName, BirthDate, HireDate, Salary) "
                            + "VALUES (?, ?, ?, ?, ?, ?)";
                }
                else if (employee.getClass().equals("class business.EmpHourly")) {
                    EmpHourly hourly = (EmpHourly) employee;
                    ps.setDouble(6, hourly.getRate());
                    ps.setDouble(7, hourly.getAvgWeeklyHours());
                    query = "INSERT INTO Employee (FirstName, MiddleName, LastName, BirthDate, HireDate, Rate, AvgWeeklyhours) "
                            + "VALUES (?, ?, ?, ?, ?, ?, ?)";
                }
                ps = connection.prepareStatement(query);
                result += ps.executeUpdate();
            }
        } catch (SQLException e) {
                
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
        return result;
    }
    
    public static int updateEmployee(Person employee) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        String updateQuery = "UPDATE Employee "
                           + "SET FirstName=?, MiddleName=?, LastName=?, Birthdate=?, HireDate=?, Salary=?, Rate=?, AvgWeeklyHours=? "
                           + "WHERE EmployeeID=? ";
        int result = 0;
        try {
            ps = connection.prepareStatement(updateQuery);
            ps.setString(1, employee.getFirstName());
            ps.setString(2, employee.getMiddleName());
            ps.setString(3, employee.getLastName());
            ps.setDate(4, Date.valueOf(employee.getBirthDate()));
            ps.setDate(5, Date.valueOf(employee.getHireDate()));
            switch (employee.getClass().toString()) {
                case "class business.Person":
                    ps.setNull(6, java.sql.Types.DOUBLE);
                    ps.setNull(7, java.sql.Types.DOUBLE);
                    ps.setNull(8, java.sql.Types.DOUBLE);
                    ps.setInt(9, employee.getEmployeeID());
                    break;
                case "class business.EmpSalary":
                    EmpSalary empSalary = (EmpSalary) employee;
                    ps.setDouble(6, empSalary.getSalary());
                    ps.setNull(7, java.sql.Types.DOUBLE);
                    ps.setNull(8, java.sql.Types.DOUBLE);
                    ps.setInt(9, employee.getEmployeeID());
                    break;
                case "class business.EmpHourly":
                    EmpHourly empHourly = (EmpHourly) employee;
                    ps.setNull(6, java.sql.Types.DOUBLE);
                    ps.setDouble(7, empHourly.getRate());
                    ps.setDouble(8, empHourly.getAvgWeeklyHours());
                    ps.setInt(9, employee.getEmployeeID());
                    break;
            }
            result = ps.executeUpdate();
        } catch (SQLException e) {
             result = -1;   
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
        return result;
    }
    public static int deleteEmployee(Person p) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String query = "DELETE FROM Employee "
                     + "WHERE EmployeeID=?";
        PreparedStatement ps = null;
        int result = 0;
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, p.getEmployeeID());
            result = ps.executeUpdate();
        }
        catch (SQLException e) {
            result = -1;
        }
        finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
        return result;
    }
}
