<%-- 
    Document   : edit
    Created on : Apr 25, 2017, 12:52:40 AM
    Author     : johns
--%>

<jsp:directive.include file="includes/header.html" />
<script type="text/javascript">
    window.onload = function () {
        if (document.getElementById("hourlyRadio").checked === true) {
            document.getElementById("hourlyInfo").setAttribute("class", "show");
            document.getElementById("salaryInfo").setAttribute("class", "hide");
        }
        else if (document.getElementById("hourlyRadio").checked === true) {
            document.getElementById("hourlyInfo").setAttribute("class", "show");
            document.getElementById("salaryInfo").setAttribute("class", "hide");
        }
        else if (document.getElementById("salaryRadio").checked === true) {
            document.getElementById("hourlyInfo").setAttribute("class", "hide");
            document.getElementById("salaryInfo").setAttribute("class", "show");
        }
    }
    var show_hourly = function() {
        if (document.getElementById("hourlyRadio").checked === true) {
            document.getElementById("hourlyInfo").setAttribute("class", "show");
            document.getElementById("salaryInfo").setAttribute("class", "hide");
        }
    }
    
    var show_salary = function() {
        if (document.getElementById("salaryRadio").checked === true) {
            document.getElementById("hourlyInfo").setAttribute("class", "hide");
            document.getElementById("salaryInfo").setAttribute("class", "show");
        }
    }
    
    var show_person = function() {
        if (document.getElementById("personRadio").checked === true) {
            document.getElementById("hourlyInfo").setAttribute("class", "hide");
            document.getElementById("salaryInfo").setAttribute("class", "hide");
        }
    }
        
</script>

    <main>
        <div id="main_container">
            <fieldset>
                <form action="controller" method="post">
                    <input type="hidden" name="action" value="save_employee">
                    <fieldset>
                        <legend>Employee Information</legend>
                        <label for="firstName">First Name : </label>
                        <input type="text" name="firstName" value="${selectedEmployee.firstName}"><br>
                        <label for="middleName">Middle Name : </label>
                        <input type="text" name="middleName" value="${selectedEmployee.middleName}"><br>
                        <label for="lastName">Last Name : </label>
                        <input type="text" name="lastName" value="${selectedEmployee.lastName}"><br>
                        <label for="birthDate">Date of Birth : </label>
                        <input type="date" name="birthDate" value="${selectedEmployee.birthDate}"><br>
                        <label for="hireDate">Hire Date : </label>
                        <input type="date" name="hireDate" value="${selectedEmployee.hireDate}"><br>
                        
                        <div class="error">${message}</div>
                    </fieldset>

                    <br>
                    <fieldset>
                    <label for="wageMode">Mode of Wage : </label>
                        <input type="radio" name="wageMode" id="hourlyRadio" value="hourly" onchange="show_hourly()" ${selectedEmployee.getClass() == 'class business.EmpHourly'? 'checked':''} ${wageModeCheck.get("hourly")}>Hourly 
                        <input type="radio" name="wageMode" id="salaryRadio" value="salary" onchange="show_salary()" ${selectedEmployee.getClass() == 'class business.EmpSalary'? 'checked':''} ${wageModeCheck.get("hourly")}>Salary 
                        <input type="radio" name="wageMode" id="personRadio" value="person" onchange="show_person()" ${selectedEmployee.getClass() == 'class business.Person'? 'checked':''} ${wageModeCheck.get("hourly")}>Pending 
                    <br>
                    <div class="error">${errorMessage}</div>
                    </fieldset>
                    <br>

                    <fieldset id="hourlyInfo" class="hide">
                        <legend>Hourly</legend>
                        <label for="rate">Rate: </label>
                        <input type="text" name="rate" value="${selectedEmployee.getClass() == 'class business.EmpHourly'? selectedEmployee.rate:''}"><br>
                        <label for="avgWeeklyHours">Average Weekly Hours: </label>
                        <input type="text" name="avgWeeklyHours" value="${selectedEmployee.getClass() == 'class business.EmpHourly'? selectedEmployee.avgWeeklyHours:''}"><br>
                    </fieldset>
                    
                    <br>

                    <fieldset id="salaryInfo" class="hide">
                        <legend>Salary</legend>
                        <label for="salary">Salary: </label>
                        <input type="text" name="salary" value="${selectedEmployee.getClass() == 'class business.EmpSalary'? selectedEmployee.salary:''}"><br>
                    </fieldset>
                    
                    <br>

                    <input type="submit" value="Save Employee">
                </form>
            </fieldset>   
        </div>            
    </main>
<jsp:directive.include file="includes/footer.jsp" />
