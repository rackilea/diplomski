<?php

// array for JSON response
$response = array();

// check for required fields
if (isset($_POST['driver'], $_POST['licencenum'], $_POST['officer'], $_POST['speed'] , $_POST['fine'],$_POST['category'])){

    $driver = $_POST['driver'];
    $licencenum = $_POST['licencenum'];
    $officer = $_POST['officer'];
    $speed = $_POST['speed'];
    $fine = $_POST['fine'];
    $category = $_POST['category'];


    // include db connect class
    require_once __DIR__ . '/db_connect.php';

    // connecting to db
    $db = new DB_CONNECT();

    // mysql inserting a new row
    $result = mysql_query("INSERT INTO fineregister(driver,licencenum,officer,speed,fine,category) VALUES   ('$driver','$licencenum','$officer','$speed','$fine','$category')");

    // check if row inserted or not
    if ($result) {
        // successfully inserted into database
        $response["success"] = true;
        $response["message"] = "Speed Ticket Successfully Registered.";
        // echoing JSON response
    } else {
        // failed to insert row
        $response["success"] = false;
        $response["message"] = "Oops! An error occurred.";
    }
} else {
    // required field is missing
    $response["success"] = false;
    $response["message"] = "Required field(s) is missing";
}
    // echoing JSON response
    echo json_encode($response);
?>