<%@ page import="models.Users" %>
<%
    System.out.println(request.getRequestURL());
    // if user is signed in
    if(request.getAttribute("current_user") != null) {
        Users currentUser = (Users) request.getAttribute("current_user");
        request.getSession().setAttribute("current_user", currentUser);
    }
    Users currentUser = (Users) request.getSession().getAttribute("current_user");
%>

