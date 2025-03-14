<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Home</title>
</head>
<body>
    <h2>WELCOME</h2>
    <% if (request.isUserInRole("ADMIN")) { %>
        <h2>Welcome, <%= request.getUserPrincipal().getName() %>!</h2>
        <p>You are logged in as <strong>ADMIN</strong>.</p>
    <% } else if (request.isUserInRole("GUEST")) { %>
        <h2>Welcome, <%= request.getUserPrincipal().getName() %>!</h2>
        <p>You are logged in as <strong>GUEST</strong>.</p>
    <% } %>
</body>
</html>
