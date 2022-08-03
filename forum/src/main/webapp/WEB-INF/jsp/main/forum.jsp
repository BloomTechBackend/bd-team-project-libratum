<%@ page import="models.PostThread" %>
<%@ page import="models.Post" %>
<%@ page import="daos.PostThreadDAO" %>
<%@ include file="../globals.jsp"%>
<%
    String indexParam = request.getParameter("the_page");

    int start = 0;
    if(indexParam != null) {
        int pageNum = Integer.parseInt(indexParam);
        if(pageNum > 1) {
            for(int i = 1; i < pageNum; i++) {
                start += 10;
            }
        }
    }

    PostThreadDAO dao = (PostThreadDAO) request.getAttribute("dao");
%>

<!DOCTYPE html>
<html lang="en">
<%! private final String title = "Forum"; %>
<%@include file="../header.jsp" %>
<body>

<script type="text/javascript">
    function validate() {
        let invalid = Boolean(<%= (currentUser == null) %>);
        if(invalid) {
            alert("You need to login to post!");
            return false;
        }
        return true;
    }
</script>



<h3>CREATE NEW THREAD!</h3>
<form action="${pageContext.request.contextPath}/thread/create-thread" method="post" onsubmit="return validate()">

    <label for="title">Title</label>
    <input id="title" name="title" type="text"/>

    <label for="Post">Post</label>
    <input id="Post" name="content" type="text" />

    <button type="submit">Create Post</button>
</form>

<table>
    <tbody>
    <%
        for(int i = start; i < start + 10; i++) {
            PostThread thread = PostThreadDAO.findById("" + i);
            if(thread == null) {
                continue;
            }

            Post post = new Post();
    %>
    <tr class="post" id="<%= request.getContextPath() + "/thread-" + i %>">
        <td>
            <table>
                <tbody>
                <tr><td>From: <%= post.getFromUser().getUsername() %></td></tr>
                <tr><td>Date: <%= post.getDate() %></td></tr>
                </tbody>
            </table>
        </td>
        <td>
            <table>
                <tbody>
                <tr>
                    <td><h3><%= thread.getTitle() %></h3></td>
                </tr>
                <tr>
                    <td>
                    <%
                        {
                            // for displaying some of the content

                            StringBuilder sb = new StringBuilder();
                            char[] content = post.getContent().toCharArray();

                            int end = content.length;
                            if(end > 35) {
                                end = 35;
                            }

                            for(int j = 0; j < end; j++) {
                                sb.append(content[j]);
                            }
                            sb.append("...");
                    %>
                    <%= sb.toString() %>
                    <%  }  %>
                    </td>
                </tr>
                </tbody>
            </table>
        </td>
    </tr>
    <script type="text/javascript">
        $("#<%= request.getContextPath() %>/thread-<%= i %>" ).click(function() {
            window.location.href = "<%= request.getContextPath() %>/thread-" + id;
        });
    </script>
    <% } %>
    </tbody>

</table>