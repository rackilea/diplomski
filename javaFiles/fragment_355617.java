<?php
$host='localhost';
$uname='root';
$pwd='welcome';
$db='CoovaChilli';

$con=mysql_connect($host,$uname,$pwd) or die("Connection Failed");
mysql_select_db($db,$con) or die("database selection failed");

$mobile = mysql_real_escape_string($_POST['Mobile']); # Secure the input!
$password = mysql_real_escape_string($_POST['Password']);

$flag['code']=0;

$select="select * from Insert1 where Mobile = '$mobile' AND Password = '$password'";
$r=mysql_query($select,$con); # This will always return something "true"

if(mysql_num_rows($r) > 0) { # You want to count rows instead.
    $flag['code']=1;
}
print(json_encode($flag));