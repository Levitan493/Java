<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - RadioButtons</title>
</head>
<body>
<form action="SubmitServlet" method="post">
  <h2>Яку технологію ви вивчаєте</h2>
  <label><input type="radio" name="technology" value="option1"> Front</label><br>
  <label><input type="radio" name="technology" value="option2">Back</label><br>
  <input type="submit" value="Submit">
  <br>
  <hr>
  <h2>Яку ви хочете отримувати зарплату</h2>
  <label><input type="radio" name="salary" value="option3">6000$</label><br>
  <label><input type="radio" name="salary" value="option4">6001$</label><br>
  <input type="submit" value="Submit">
</form>




</body>
</html>