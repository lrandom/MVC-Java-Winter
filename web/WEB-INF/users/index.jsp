<%-- 
    Document   : index.jsp
    Created on : Oct 7, 2020, 7:03:18 PM
    Author     : Lrandom
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <table>
            <tr>
                <td>Id</td>
                <td>Username</td>
                <td>Password</td>
            </tr>
            
            <c:forEach items="${users}" var="user">
                <tr>
                    <td>
                    <c:out value="${user.getId()}"></c:out>
                    </td>
                    <td>${user.getUsername()}</td>
                    <td>${user.getPass()}</td>
                </tr>
            </c:forEach>
            
        </table>
    </body>
</html>
