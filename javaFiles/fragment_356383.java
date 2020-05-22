//conn.php for connection (file one)
<?php
$host = "localhost"; //update with yours
$user = "root"; //update the phpmyadmin username
$pass = ""; //update with your phpmyadmin password
$db_name = "hello"; //replace with your db name

$con = new mysqli($host,$user,$pass,$db_name);

if($con -> connect_error){
echo "Connection error";
}   


//save.php(file two)
<?php
$username = $_POST['username'];
$password = $_POST['password'];
require_once('conn.php');

//here user is one table with username and password field to save the data coming from user to server. Make sure you replace with your own needs.
$sql = "INSERT INTO user (username, password) VALUES ('$username','$password')";

if($con -> query($sql) === TRUE) {
echo "User added";
}
//$con -> close();
?>
?>

//login.php(file three)
<?php
require_once('conn.php');

$username = $_POST['username'];
$password = $_POST['password'];

$sql = "SELECT * FROM user WHERE username = '$username' AND password = '$password'";

$result = mysqli_query($con,$sql);

if(mysqli_fetch_array($result) == NULL){
echo "Invalid Cred.";
}else{
echo "Success";
}

$con->close();
?>