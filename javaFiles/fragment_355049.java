$response["android"] = array(); 
$i = 0;
while ($row = mysqli_fetch_array($result, MYSQL_ASSOC)) { 

    $row_array['post_id'] = $row['post_id'];  
    $row_array['user_id'] = $row['user_id']; 
    $row_array['post_inhalt'] = $row['post_inhalt']; 
    $row_array['likes'] = $row['likes']; 

    $response["android"][$i] = $row_array;  
}