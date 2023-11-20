<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Welcome Page</title>
</head>
<body>
    <h1>Welcome</h1>
   
    <p>Welcome, <%= session.getAttribute("username") %>!</p>

    <table>
      <tbody>
        <tr>
          <th>ID</th>
          <td><%= session.getAttribute("id") %></td>
        </tr>
        <tr>
          <th>Username</th>
          <td><%= session.getAttribute("username") %></td>
        </tr>
        <tr>
          <th>Profile</th>
          <td><%= session.getAttribute("profile") %></td>
        </tr>
      </tbody>
    </table>
    
      <form method="get" action="list">
      <input type="submit" value="GO">
    </form>


    <form method="POST" action="logout">
      <input type="submit" value="Back">
    </form>
</body>
</html>