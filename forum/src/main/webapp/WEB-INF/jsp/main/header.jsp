<%--
    This page cannot be used on its own and must be have a variable denoting the page title
    before the inclusion of the header file with,
    ```jsp
    final String title = "[page_title]";
    <%@include file="header.jsp" %>
    ```
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><%= title %></title>
</head>
<body>
<nav>
    <button><a href="/">Home</a></button>

    <button><a href="${pageContext.request.contextPath}/registration">Registration</a></button>
</nav>
</body>
</html>
