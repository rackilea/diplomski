<?php
require "connect.php";
$name = $_POST["name"];
$email =$_POST["email"];
$user_name =$_POST["user_name"];
$password =$_POST["password"];
$sql = "INSERT INTO `user_info`(`name`, `email`, `user_name`, `password`) VALUES ('$name','$email','$user_name','$password')";
$result = mysqli_query($con,$sql);
$myArray = array();
if($result){
$myArray = array("status" => "success", 'code' => "200")
} else{
$myArray = array("status" => "failure", 'code' => "400")
}
echo json_encode($myArray);
mysqli_close($con);
?>