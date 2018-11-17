<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <link type="text/css" rel="stylesheet" href="<c:url value="/resources/style.css" />" />
    </head>

    <body>
        <div class="container">
            <spring:form cssClass="signUp"  modelAttribute="userLogin" action="adduser.htm" method="GET">

                <h3>Create An Account</h3>
                <p>Please enter your user name</br>
                    and your password to join.
                </p>
                <spring:input  cssClass="w100" path="name"/>
                <spring:input  cssClass="w100" path="password" type="password" id="password1"/>
                <input  Class="w100" value="password" type="password" id="password2" />
                <spring:errors path="name"/>


                <button class="form-btn sx log-in" type="button">Log In</button>
                <button class="form-btn dx" type="submit">Register</button>
            </spring:form> 

            <form Class="signIn"  action="checkuser.htm" method="POST">

                <h3>Welcome</br>Back !</h3>

         
                <input  name="name" value="Username"/>
                <input type="password" value="password" name="password3"/>

                <p>Enable</p>
                <input type="checkbox"  value="Enable" onchange="document.getElementById('activator').disabled = !this.checked;" />


                <button class="form-btn sx back" type="button">Back</button>
                <button class="form-btn dx" type="submit" name="activator"id="activator" disabled>Log In</button>


            </form> 

        </div>

        <script src="<c:url value="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js" />"></script>
        <script src="<c:url value="/resources/index.js" />"></script>

    </body>
</html>
