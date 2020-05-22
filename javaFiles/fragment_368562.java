<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Test Page</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
    <h1>Test Page</h1>
    <form action="" method="post">
        <p>Choose some course</p>
        <select name="course">
            <option value="English" name="eng">English</option>
            <option value="Math" name="mat">Math</option>
            <option value="Computer Science" name="sci">Computer Science</option>
        </select>
        <p><input type="submit" value="Pass data" /></p>
    </form>
    <hr />
    <h2>Testing passed parameters</h2>
    <p>Passed "course" parameter = <span style="color: #FF0000">${param.course}</span></p>
</body>
</html>