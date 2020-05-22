$response = array();
$arr = array();
$response["success"] = false;

while(mysqli_stmt_fetch($statement)){
    $response["success"] = true; 
    $response["name"] = $name;
    $response["family"] = $family;
    $response["date"] = $date;
    $response["time"] = $time;
    $arr[] = $response;
}
echo json_encode($arr);