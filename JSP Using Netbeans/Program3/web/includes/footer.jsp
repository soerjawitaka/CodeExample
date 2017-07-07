<%-- 
    Document   : footer
    Created on : Apr 15, 2017, 2:19:06 AM
    Author     : johns
--%>

<%@page import="java.util.Calendar"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <footer>
            <div id="overline">&nbsp;</div>

            <% Calendar today = Calendar.getInstance(); %>
            <p id="copyright"><i>Copyright</i> &copy; <c:out value="<%= today.get(Calendar.YEAR) %>"/> ABC Company, Inc.</p>
            <p>&nbsp;</p>
        </footer>
    </body>
</html>
