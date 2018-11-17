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
            <form action="index.htm">

                <h3>You have successfully created an account!</h3>
                <button class="form-btn dx" type="submit" >Go to Log In</button>
            </form>

        </div>

    </body>
</html>
