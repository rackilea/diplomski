<?php
$con = mysqli_connect("your_mysql_hostname" , "your_username" , "your_password" , "your_database_name");

$username = $_POST["Username"];
$score= $_POST["Score"];


$query = mysqli_prepare($con , "UPDATE contacts SET score=? WHERE username=?");
mysqli_stmt_bind_param($query, $score, $username);
mysqli_stmt_execute($query);


mysqli_stmt_close($query);

mysqli_close($con);