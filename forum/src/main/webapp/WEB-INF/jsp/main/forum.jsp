<%@ page import="java.util.Arrays"%> <%
    String name = request.getParameter("name");

    int e = 0;

    class name {
        private int getName() {
            return 0;
        }
    }

%>

<!DOCTYPE html>
<html lang="en">
<% String title = "forum"; %>
<%@include file="header.jsp" %>
<body>
<h2>My Playlists</h2>
<ul id="playlists">
</ul>
<%= new name().getName() %>
<h2>Create a Playlist</h2>

<table>
    <%
        for(int i = 0; i < 10; i++) {
    %>
    <tr><td></td></tr>
    <%
        }
    %>
</table>



<p><%= e %></p>
<form class="card-content" id="create-playlist-form">
    <label>Playlist Name
        <input type="text" required class="validated-field" id="playlist-name" placeholder="smooth-jamz" autofocus>
    </label>
    <label>Tags
        <input type="text" id="tags" class="tags" placeholder="tag1,tag2" data-tip="Must be a comma separated list of tags.">
    </label>
    <input type="submit" id="create" value="Create">
</form>
</body>
</html>
