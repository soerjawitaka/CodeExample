/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import business.EmpHourly;
import business.EmpSalary;
import business.EmployeeManager;
import business.Person;
import business.Validation;
import data.EmployeeManagerDA;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import util.TreeMapSortUtil;

/**
 *
 * @author js190325
 */
public class controllerServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        EmployeeManager eM;
        String url = "";
        if (session.getAttribute("employee_manager") == null) {
            eM = new EmployeeManager();
            session.setAttribute("employee_manager", eM);            
        }
        else {
            eM = (EmployeeManager) session.getAttribute("employee_manager");
        }
        
        String action; 
        if (request.getParameter("action") == null) {
            action = "display_employees";
        }
        else {
            action = (String) request.getParameter("action");
        }
        
        TreeMap<String, Person> employeeTree = eM.getEmployeeTree();
        TreeMap<String, Person> sortedEmployeeMap = null;
        String message = "";
        String errorMessage = "";
        String error = "";
        Person selectedEmployee = null;
        
        switch (action) {
            case "display_employees":
                eM = new EmployeeManager();
                employeeTree = eM.getEmployeeTree();
                url = "/index.jsp";
                sortedEmployeeMap = TreeMapSortUtil.sortByLastName(employeeTree);
                session.setAttribute("empTree", sortedEmployeeMap);
                session.setAttribute("error", "");
                session.setAttribute("message", "");
                session.setAttribute("errorMessage", "");
                sendPage(request, response, url);
                break;
            case "find_employee":
                final String selectedDate = request.getParameter("selectedDate");
                
                final String comparison = request.getParameter("comparison");
                
                if (selectedDate == null || selectedDate.isEmpty()) {
                    error = "You must select a date to conduct a search.";
                    if (comparison != null && !comparison.isEmpty()) {
                        switch (comparison) {
                            case "before":
                                final String before1 = "checked";
                                final String after1 = "";
                                final String[] compare1 = {before1, after1};
                                request.setAttribute("compare", compare1);
                                break;
                            case "after":
                                final String before2 = "";
                                final String after2 = "checked";
                                final String[] compare2 = {before2, after2};
                                request.setAttribute("compare", compare2);
                                break;
                        }
                    }
                }
                else if (comparison == null || comparison.isEmpty()) {
                    error = "You must select before or after selected date to conduct a search.";
                    if (selectedDate != null && !selectedDate.isEmpty()) {
                        request.setAttribute("selectedDate", selectedDate);
                    }
                    else {
                        final String noSelectedDate = "";
                        request.setAttribute("selectedDate", noSelectedDate);
                    }
                }
                else {
                    final LocalDate dateToCompare = LocalDate.parse(selectedDate);
                    SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
                    Date parsedDateToCompare = java.sql.Date.valueOf(dateToCompare);
                    if (comparison.equals("before")) {
                        final EmployeeManager emBefore = new EmployeeManager();
                        emBefore.setEmployees(EmployeeManagerDA.findHireDateBefore(dateToCompare));
                        if (emBefore.getEmployees().size() == 0) {
                            error = "There are no employees hired before " + sdf.format(parsedDateToCompare);
                        }
                        else {
                            error = "Here are employees hired before " + sdf.format(parsedDateToCompare);
                        }
                        employeeTree = emBefore.getEmployeeTree();
                    }
                    else if (comparison.equals("after")) {
                        final EmployeeManager emAfter = new EmployeeManager();
                        emAfter.setEmployees(EmployeeManagerDA.findHireDateAfter(dateToCompare));
                        if (emAfter.getEmployees().size() == 0) {
                            error = "There are no employees hired after " + sdf.format(parsedDateToCompare);
                        }
                        else {
                            error = "Here are employees hired after " + sdf.format(parsedDateToCompare);
                        }
                        employeeTree = emAfter.getEmployeeTree();
                    }
                }
                url = "/index.jsp";
                sortedEmployeeMap = TreeMapSortUtil.sortByLastName(employeeTree);
                session.setAttribute("empTree", sortedEmployeeMap);
                session.setAttribute("error", error);
                sendPage(request, response, url);
                break;
            case "find_employee_by_yearly_cost":
                final String annualCost = request.getParameter("annualCost");
                final String comparisonYearlyCost = request.getParameter("comparisonYearlyCost");
                double annualCostTemp = 0.0;
                /*  input validation    */
                if (Validation.isPresent(annualCost)) {
                    if (Validation.isDouble(annualCost)) {
                        annualCostTemp = Double.parseDouble(annualCost);
                        if (comparisonYearlyCost != null) {
                            if (!(annualCostTemp == 0 && comparisonYearlyCost.equals("less"))) {
                                if (annualCostTemp >= 0) {
                                    error = "";
                                } else {
                                    error = "Annual Cost must be a numeric input of 0 or greater.";
                                }
                            } else {
                                error = "Not able to search employee with yearly cost less than 0.";
                            }
                        } else {
                            error = "You must select more, less, or equal to the value to conduct this search.";
                        }
                    } else {
                        error = "Annual Cost must be a numeric input.";
                    }
                } else {
                    error = "Annual Cost is a required field for the search.";
                }
                
                /*  search process  */
                if (error.equals("")){
                    final EmployeeManager queriedEmployees = new EmployeeManager();
                    queriedEmployees.setEmployees(EmployeeManagerDA.findYearlyCost(annualCostTemp, comparisonYearlyCost));
                    
                    NumberFormat formatter = NumberFormat.getCurrencyInstance();
                    String annualCostMoney = formatter.format(annualCostTemp);
                    String modifier = "";
                    if (!comparisonYearlyCost.equals("equal")) {
                        modifier = "than ";
                    }
                    if (queriedEmployees.getEmployees().size() == 0) {
                        error = "There are no employees with annual cost " + comparisonYearlyCost + " " + modifier + annualCostMoney;
                    }
                    else {
                        
                        error = "Here are employees with annual cost " + comparisonYearlyCost + " " + modifier + annualCostMoney;
                    }
                    employeeTree = queriedEmployees.getEmployeeTree();
                }
                
                url = "/index.jsp";
                sortedEmployeeMap = TreeMapSortUtil.sortByLastName(employeeTree);
                session.setAttribute("empTree", sortedEmployeeMap);
                session.setAttribute("error", error);
                sendPage(request, response, url);
                break;
            case "edit_employee":
                String employeeID = (String) request.getParameter("employeeID");
                selectedEmployee = employeeTree.get(employeeID);
                url = "/edit.jsp";
                session.setAttribute("selectedEmployee", selectedEmployee);
                sendPage(request, response, url);
                break;
            case "new_employee":
                selectedEmployee = null;
                url = "/edit.jsp";
                session.setAttribute("selectedEmployee", selectedEmployee);
                sendPage(request, response, url);
                break;
            case "save_employee":
                Person emp = (Person) session.getAttribute("selectedEmployee");
                String FName = request.getParameter("firstName");
                String MName = request.getParameter("middleName");
                String LName = request.getParameter("lastName");
                String bDateString = request.getParameter("birthDate");
                String hDateString = request.getParameter("hireDate");
                String wageMode = request.getParameter("wageMode");
                LocalDate bDate = null;
                LocalDate hDate = null;
                
                message = "";
                if (FName == null || FName.equals("")) {
                    message = "First Name is a required field.";
                }
                else if (LName == null || LName.equals("")) {
                    message = "Last Name is a required field.";
                }
                else if (bDateString == null || bDateString.equals("")) {
                    message = "Birth Date is a required field.";
                }
                
                if (message.equals("")) {
                    try {
                        bDate = LocalDate.parse(bDateString);
                    }
                    catch (DateTimeParseException e) {
                        message = "The Birth Date entered is not in the correct format. Please use yyyy-mm-dd if you are not using the DatePicker widget.";
                    }
                    if (message.equals("")) {
                        if (hDateString == null || hDateString.equals("")) {
                            message = "Hire Date is a required field.";
                        }
                        else {
                            try {
                                hDate = LocalDate.parse(hDateString);
                            }
                            catch (DateTimeParseException e) {
                                message = "The Hire Date entered is not in the correct format. Please use yyyy-mm-dd if you are not using the DatePicker widget.";
                            }
                        }
                    }
                }
                
                if (wageMode == null || wageMode.equals("")) {
                    errorMessage = "Employe Type is a required field. Please choose from the selections.";
                }
                
                Person empToSave = new Person(FName, MName, LName, bDate, hDate);
                if (emp != null) {
                    empToSave.setEmployeeID(emp.getEmployeeID());
                }

                if (!message.equals("") || !errorMessage.equals("")) {
                    selectedEmployee = new Person(FName, MName, LName, bDate, hDate);
                    session.setAttribute("message", message);
                    session.setAttribute("errorMessage", errorMessage);
                    session.setAttribute("selectedEmployee", selectedEmployee);
                    url = "/edit.jsp";
                    sendPage(request, response, url);
                }
                else {
                    session.setAttribute("message", "");
                    session.setAttribute("errorMessage", "");
                    saveEmployee(request, response, employeeTree, empToSave, wageMode);
                }
                break;
            case "delete_employee":
                String empIDToDelete = (String) request.getParameter("employeeID");
                selectedEmployee = employeeTree.get(empIDToDelete);
                int result = EmployeeManagerDA.deleteEmployee(selectedEmployee);
                String confirm = "";
                if (result > 0) {
                    employeeTree.remove(Integer.toString(selectedEmployee.getEmployeeID()));
                }
                else {
                    confirm = "SQL Error! Employee not found. Please contact your administrator.";
                }
                sortedEmployeeMap = TreeMapSortUtil.sortByLastName(employeeTree);
                session.setAttribute("empTree", sortedEmployeeMap);
                session.setAttribute("confirm", confirm);
                session.setAttribute("selectedEmployee", selectedEmployee);
                url = "/index.jsp";
                sendPage(request, response, url);
                break;
            default:
                url = "/index.jsp";
                sendPage(request, response, url);
                break;
        }
    }
    
    private void saveEmployee(HttpServletRequest request, HttpServletResponse response, TreeMap<String, Person> employees, Person np, String wageMode) {
        String url = "";
        String errorMessage = "";
        Person selectedEmployee = null;

        HttpSession session = request.getSession();

        switch (wageMode) {
            case "person":
                if (np.getEmployeeID() == 0) { // new employee
                    int lastID = EmployeeManagerDA.addEmployee(np);
                    np.setEmployeeID(lastID);
                    employees.put(Integer.toString(lastID), np);
                    url = "/index.jsp";
                }
                else { // existing employee
                    int resultCount = EmployeeManagerDA.updateEmployee(np);
                    if (resultCount > 0) {
                    employees.replace(Integer.toString(np.getEmployeeID()), np);
                        url = "/index.jsp";
                    }
                    else {
                        errorMessage = "Unable to update employee. Please try again.";
                        url = "/edit.jsp";
                    } 
                }
                break;
            case "hourly":
                String rate = request.getParameter("rate");
                String avgWeeklyHours = request.getParameter("avgWeeklyHours");
                Double rateTemp = 0.0;
                Double avgWeeklyHoursTemp = 0.0;
                
                /* entry validation *******************************/
                if(Validation.isPresent(rate)) {
                    if(Validation.isDouble(rate)) {
                        rateTemp = Double.parseDouble(rate);
                        if (rateTemp > 0) {
                            if(Validation.isPresent(avgWeeklyHours)) {
                                if (Validation.isDouble(avgWeeklyHours)) {
                                    avgWeeklyHoursTemp = Double.parseDouble(avgWeeklyHours);
                                    if (avgWeeklyHoursTemp > 0) {
                                        errorMessage = "";
                                    } else {
                                        errorMessage = "Average Weekly Hours must be greater than 0.";
                                    }
                                } else {
                                    errorMessage = "Average Weekly Hours must be a numeric input.";
                                }
                            } else {
                                errorMessage = "Average Weekly Hours is a required field.";
                            }
                        } else {
                            errorMessage = "Rate must be greater than 0.";
                        }
                    } else {
                        errorMessage = "Rate must be a numeric input.";
                    }
                } else {
                    errorMessage = "Rate is a required field.";
                }
                
                /* no error ******************************/
                if (errorMessage.equals("")) {
                    if (np.getEmployeeID() == 0) {
                        EmpHourly eh = new EmpHourly(np.getFirstName(), np.getMiddleName(), np.getLastName(), np.getBirthDate(), np.getHireDate(), rateTemp, avgWeeklyHoursTemp);
                        int lastIDHourly = EmployeeManagerDA.addEmployee(eh);
                        eh.setEmployeeID(lastIDHourly);
                        employees.put(Integer.toString(lastIDHourly), eh);
                        url = "/index.jsp";
                    }
                    else {
                        EmpHourly eh = new EmpHourly(np.getFirstName(), np.getMiddleName(), np.getLastName(), np.getBirthDate(), np.getHireDate(), rateTemp, avgWeeklyHoursTemp);
                        eh.setEmployeeID(np.getEmployeeID());
                        int resultCountHourly = EmployeeManagerDA.updateEmployee(eh);
                        if (resultCountHourly > 0) {
                            employees.replace(Integer.toString(eh.getEmployeeID()), eh);
                            url = "/index.jsp";
                        }
                        else {
                            errorMessage = "Unable to update employee. Please try again.";
                            url = "/edit.jsp";
                        }
                    }
                }
                else { // have some error
                    selectedEmployee = new EmpHourly(np.getFirstName(), np.getMiddleName(), np.getLastName(), np.getBirthDate(), np.getHireDate(), rateTemp, avgWeeklyHoursTemp);
                    url = "/edit.jsp";
                }
                break;
            case "salary":
                String salary = request.getParameter("salary");
                Double salaryTemp = 0.0;
                
                // entry validation
                if (Validation.isPresent(salary)) {
                    if (Validation.isDouble(salary)) {
                        salaryTemp = Double.parseDouble(salary);
                        if (salaryTemp > 0) {
                            errorMessage = "";
                        } else {
                            errorMessage = "Salary must be greater than 0.";
                        }
                    } else {
                        errorMessage = "Salary must be a numeric input";
                    }
                } else {
                    errorMessage = "Salary is a required field.";
                }

                if (errorMessage.equals("")) { // no error
                    if (np.getEmployeeID() == 0) {
                        EmpSalary es = new EmpSalary(np.getFirstName(), np.getMiddleName(), np.getLastName(), np.getBirthDate(), np.getHireDate(), Double.parseDouble(salary));
                        int lastIDSalary = EmployeeManagerDA.addEmployee(es);
                        es.setEmployeeID(lastIDSalary);
                        employees.put(Integer.toString(lastIDSalary), es);
                        url = "/index.jsp";
                    }
                    else {
                        EmpSalary es = new EmpSalary(np.getFirstName(), np.getMiddleName(), np.getLastName(), np.getBirthDate(), np.getHireDate(), Double.parseDouble(salary));
                        es.setEmployeeID(np.getEmployeeID());
                        int resultCountSalary = EmployeeManagerDA.updateEmployee(es);
                        if (resultCountSalary > 0) {
                            employees.replace(Integer.toString(es.getEmployeeID()), es);
                            url = "/index.jsp";
                        }
                        else {
                            errorMessage = "Unable to update employee. Please try again.";
                            url = "/edit.jsp";
                        }
                    }
                }
                else { // some error
                    selectedEmployee = new EmpSalary(np.getFirstName(), np.getMiddleName(), np.getLastName(), np.getBirthDate(), np.getHireDate(), salaryTemp);
                    url = "/edit.jsp";
                }
                break;
            default:
                errorMessage = "Please select Employee Type.";
                url = "/edit.jsp";
                break;
        }

        TreeMap<String, Person> sortedEmployeeMap = TreeMapSortUtil.sortByLastName(employees);
        session.setAttribute("empTree", sortedEmployeeMap);
        session.setAttribute("errorMessage", errorMessage);
        session.setAttribute("selectedEmployee", selectedEmployee);
        
        sendPage(request, response, url);

    }
    
    private void sendPage(HttpServletRequest request, HttpServletResponse response, String url) {
        try {
            getServletContext()
                .getRequestDispatcher(url)
                    .forward(request, response);
            
        } catch (ServletException ex) {
            Logger.getLogger(controllerServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(controllerServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
