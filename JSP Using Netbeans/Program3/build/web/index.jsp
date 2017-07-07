<%-- 
    Document   : index
    Created on : Apr 24, 2017, 6:26:29 PM
    Author     : js190325
--%>
<jsp:directive.include file="includes/header.html" />
    <main>
        <div id="main_container">
            <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
            <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
            <fmt:setLocale value="en_US"/>
            <%@page import="java.time.LocalDate"%>
            <%@page contentType="text/html" pageEncoding="UTF-8"%>
            
            <fieldset>
                
                <form action="controller" method="post" style="border-bottom: 3px solid #584F40;">
                    <input type="hidden" name="action" value="find_employee">

                    <input style="float: right;" type="submit" value="Find">
                    
                    <label style="width: 200px">Employee Search by Hire Date</label>
                    <% final String todaysDate = LocalDate.now().toString(); %>
                    <label for="selectedDate">Select a date</label>
                    <input type="date"  id="datepicker" name="selectedDate" value="<%= todaysDate %>">

                    <input type="radio" name="comparison" value="before">Before 
                    <input type="radio" name="comparison" value="after">After 
                </form>
                    
                    <div style="height: 10px;">&nbsp;</div>
                
                <form action="controller" method="post" style="border-bottom: 3px solid #584F40;">
                    <input type="hidden" name="action" value="find_employee_by_yearly_cost">
                    
                    <input style="float: right;" type="submit" value="Find">

                    <label style="width: 250px;text-align: left;">Employee Search by Annual Cost</label>
                    <input style="margin-left: 100px;" type="text" name="annualCost" placeholder="Annual Cost">
                    
                    <input type="radio" name="comparisonYearlyCost" value="more">More 
                    <input type="radio" name="comparisonYearlyCost" value="less">Less 
                    <input type="radio" name="comparisonYearlyCost" value="equal">Equal 
                </form>
                    
                <div class="error">${error}</div>
            
                <table>
                    <tr>
                        <th>&nbsp;</th>
                        <th>Employee ID</th>
                        <th>Name</th>
                        <th>Type</th>
                        <th>Hire Date</th>
                        <th>Yearly Cost</th>
                        <th>&nbsp;</th>
                        <!--<th>&nbsp;</th>-->                        
                    </tr>

                    <% int index = 1; %>

                    <c:forEach var="emp" items="${empTree}" varStatus="status">
                        <tr>
                            <td><%= index++ %></td>
                            <td><c:out value="${emp.value.employeeID}"/></td>
                            <td><c:out value="${emp.value.lastName}, ${emp.value.firstName} ${emp.value.middleName}"/></td>
                            
                            <c:if test="${emp.value.getClass() == 'class business.Person'}" >
                                <td>Pending</td>
                            </c:if>
                            <c:if test="${emp.value.getClass() == 'class business.EmpSalary'}" >
                                <td>Salary</td>
                            </c:if>
                            <c:if test="${emp.value.getClass() == 'class business.EmpHourly'}" >
                                <td>Hourly</td>
                            </c:if>
                            
                            
                            <fmt:parseDate value="${emp.value.hireDate}" pattern="yyyy-MM-dd" 
                                            var="parsedHire" type="date" />
                            <fmt:formatDate value="${parsedHire}" var="formattedHire" 
                                            type="date" pattern="MM-dd-yyyy" />
                            <td><c:out value="${formattedHire}"/></td>

                            <fmt:parseNumber var="yearlyCost" type="number" value="${emp.value.getYearlyCost()}" />
                            <td><fmt:formatNumber type="currency" value="${yearlyCost}" /></td>

                            <td>    
                                <form action="controller" method="post">
                                    <input type="hidden" name="action" value="edit_employee">
                                    <input type="hidden" name="employeeID" value="${emp.key}">
                                    <input type="submit" value="Edit">
                                </form>
                            </td>
                            
<!--                            <td>    
                                <form action="controller" method="post">
                                    <input type="hidden" name="action" value="delete_employee">
                                    <input type="hidden" name="employeeID" value="${emp.key}">
                                    <input type="submit" value="Delete">
                                </form>
                            </td>-->
                        </tr>

                    </c:forEach>
                </table>
                
                <div style="text-align: center">    
                    <form action="controller" method="post">
                        <input type="hidden" name="action" value="display_employees">
                        <input type="submit" value="Show All Employees">
                    </form>

                    <form action="controller" method="post">
                        <input type="hidden" name="action" value="new_employee">
                        <input type="submit" value="Add a New Employee">
                    </form>
                </div>
                    
                    <div>${confirm}</div>
            </fieldset>
            
        </div>
    </main>
<jsp:directive.include file="includes/footer.jsp" />