<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<% final String title = "Registration"; %>
<%@ include file="../main/header.jsp" %>
<body>
<table>
    <tr>
        <td style="border-right: 2px solid; width: 60%;">
            <header>
                <h3>Register</h3>
            </header>
            <form method="post">
                <input type="hidden" name="action" value="create">
                <div class="fields">
                    <div class="field">
                <label for="username">Username</label>
                <input type="text" name="username" id="username">
                    </div>
                    <div class="field">
                <label for="password">Password</label>
                <input type="password" name="password" id="password">
                    </div>
                    <div class="field">
                <label for="verifyPassword">Verify Password</label>
                <input type="password" name="verify" id="verifyPassword">
                    </div>
                    <div class="field">
                        <div class="container">
                            <div class="row">
                                <div class="col-sm-6">
                                    <label for="firstName">First Name</label>
                                    <input type="text" name="firstName" id="firstName"/>
                                </div>
                                <div class="col-sm-6">
                                    <label for="lastName">Last Name</label>
                                    <input type="text" name="lastName" id="lastName" />
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="field">
                        <label for="email">Email</label>
                        <input type="text" name="email" id="email" />
                    </div>
                </div>
                <ul class="actions">
                    <li><input type="submit" name="submit" value="Create Account" onclick=""/></li>
                </ul>
            </form>
        </td>
        <!-- Login -->
        <td style="border-left: 2px solid;">
            <header>
                <h3>Login</h3>
            </header>
            <form method="post">
                <input type="hidden" name="action" value="login">
                <div class="fields">
                    <div class="field">
                        <label for="loginUsername">Username</label>
                        <input type="text" name="username" id="loginUsername" placeholder="Email or Username">
                    </div>
                    <div class="field">
                        <label for="loginPassword">Password</label>
                        <input type="password" name="password" id="loginPassword">
                    </div>
                    <div class="field">
                        <a href="<%= request.getContextPath() %>">Forgot Password?</a>
                    </div>
                </div>
                <ul class="actions">
                    <li><input type="submit" name="submit" value="Login"/></li>
                </ul>
            </form>
        </td>
    </tr>
</table>
</body>
</html>
