<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<title>Login</title>
<style>
body {
    font-family: Arial;
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
    background: #e8eaf6;
    margin: 0;
}
.card {
    background: white;
    padding: 40px;
    border-radius: 12px;
    box-shadow: 0 6px 20px rgba(0,0,0,0.12);
    width: 320px;
}
h2 {
    text-align: center;
    color: #1a237e;
}
input[type="text"], input[type="password"] {
    width: 100%;
    padding: 10px;
    margin: 6px 0 16px 0;
    border: 1px solid #ccc;
    border-radius: 6px;
}
input[type="submit"] {
    width: 100%;
    padding: 11px;
    background: #1a237e;
    color: white;
    border: none;
    border-radius: 6px;
    cursor: pointer;
}
input[type="submit"]:hover {
    background: #3949ab;
}
.err {
    background: #ffebee;
    color: #c62828;
    padding: 10px;
    border-radius: 6px;
    text-align: center;
    margin-bottom: 14px;
}
.hint {
    text-align: center;
    font-size: 11px;
    color: #999;
}
</style>
</head>

<body>
<div class="card">
    <h2>Login</h2>

    <% if("1".equals(request.getParameter("error"))) { %>
        <div class="err">Invalid username or password!</div>
    <% } %>

    <!-- IMPORTANT: context path added -->
    <form action="<%=request.getContextPath()%>/LoginServlet" method="post">
        <label>Username</label>
        <input type="text" name="username" required>

        <label>Password</label>
        <input type="password" name="password" required>

        <input type="submit" value="Login">
    </form>

    <p class="hint">Use: admin / 1234</p>
</div>
</body>
</html>