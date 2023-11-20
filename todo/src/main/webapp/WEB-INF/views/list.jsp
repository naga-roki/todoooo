<%@ page language="java"
contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html lang="ja">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Todoリスト</title>
</head>
<body>
   <h1>Todoリスト</h1>
    <% String message = (String)request.getAttribute("message"); %>
   
    <p><%= message%></p>
    
    <span><strong>ID</strong></span>
    <span><strong>タイトル</strong></span><br>
    <% 
      ArrayList<HashMap<String, String>> rows = (ArrayList<HashMap<String, String>>)request.getAttribute("rows"); 
    %>

    <% 
      for (HashMap<String, String> columes : rows) {
    %>
    <span><%= columes.get("id")%></span>
    <span><a href='show?id=<%= columes.get("id") %>'><%= columes.get("title")%></a></span>
     <span><a href='show?id='><%= columes.get("duedate")%></a></span>
     <span><%= columes.get("priority") %></span><br>
    <% } %> 
    <p><a href="new">新規作成</a></p>
    
      <label for="pet-select">昇降順を選択:</label>
    <form action="sort" method = "post">
	<select name="spriority" id="pet-select">
  	　<option value="">--選択--</option>
	  <option value="asc">昇降</option>
	  <option value="desc">降順</option>
	  </select>
	   <button type="submit">決定</button>
	 </form>
	   <label for="pet-select">日付け順を選択:</label>
    <form action="date" method = "post">
	<select name=sduedate id="pet-select">
  	　<option value="">--選択--</option>
	  <option value="asc">昇降</option>
	  <option value="desc">降順</option>
	  </select>
	   <button type="submit">決定</button>
	 </form>
	 <p><form method="POST" action="logout">
      <input type="submit" value="LOGOUT">
    </form></p>
    </table>
    <table>
   
      
</body>
</html>
