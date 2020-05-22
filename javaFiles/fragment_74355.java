header("Content-Type: application/json"); //add this in your php code 

if ( mysqli_query($conn, $sql) ) {
    $result["success"] = "1";
    $result["message"] = "success";



} else {

    $result["success"] = "0";
    $result["message"] = "error";

}

   echo json_encode($result);
    mysqli_close($conn);