<%--
  Created by IntelliJ IDEA.
  User: Dawson
  Date: 7/18/2022
  Time: 8:05 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../globals.jsp"%>
<html>
<%! private final String title = "Account"; %>
<%@include file="../header.jsp"%>
<body>

<h3>CREATE NEW THREAD!</h3>
<form action="${pageContext.request.contextPath}/thread/create-thread" method="post" onsubmit="return validate()">

    <label for="title">Title</label>
    <input id="Post" name="title" type="text"/>

    <label for="Post">Post</label>
    <input id="Post" name="post_content" type="text" />

    <button type="submit">Create Post</button>



</form>

</body>
</html>
