<?php
//connect to database
include 'connect.php';
 //get the question number from POST encrypted argument
$num = $_POST['NUM'];
//Query the Database with the NUM argument to retrieve question
$result = mysqli_query($con,"SELECT QUESTION, A, B, C, D, ANSWER FROM trivia where num=        '$num' ");
$row = mysqli_fetch_array($result);
$i = '0';
$question = $row[0];
$A = $row[1];
$B = $row[2];
$C = $row[3];
$D = $row[4];
$answer = $row[5];

//returns question, multichice answers, and answer seperated by '#' and '*'
if($question){
echo "$question#$A#$B#$C#$D*$answer";
}
mysqli_close($con);
?>