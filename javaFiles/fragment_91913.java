<?php

require "conn.php";

$user = $_POST["username"];
$password = $_POST["password"];


$response["user_data"] = array();

//Use mysqli_prepare to secure yourself from sql injection.

$query = $conn->prepare("Select * from user_data where username = ? and password = ?");
$query->bind_param("ss", $user, $password);
$query->execute();

$result = $query->get_result();

// check if the query returned a row (which means success)
if(mysqli_num_rows($result) > 0){

    $response["message"] = "Log in success";

    $getUserData = $conn->prepare(// your query here where username = ?);
    $getUserData->bind_param("s", $user);
    $getUserData->execute();

    $getResult = $getUserData->get_result();

    while($row_data = $getResult->fetch_assoc()){

        array_push($response["user_data"] = $row_data);

    }

    echo json_encode($response);


}
else{

    // your else statement.

}

?>