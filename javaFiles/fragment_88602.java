<?php
 if($_SERVER['REQUEST_METHOD']=='POST'){
    $mysqli = new mysqli("localhost", "user", "password", "database");
    if ($mysqli->connect_errno) {
        echo "Failed to connect to MySQL: (" . $mysqli->connect_errno . ") " . $mysqli->connect_error;
    }

    $listItems = json_decode($_POST['listItems'], true); 
    $sql="INSERT INTO work_details 
    (project, work_description, percentage, timeIn, timeOut, twf) 
    VALUES 
    (?, ?, ?, ?, ?, ?)"; 

    if (!($stmt = $mysqli->prepare($sql))) {
         echo "Prepare failed: (" . $mysqli->errno . ") " . $mysqli->error;
         foreach($listItems as $item){ 
            $stmt->bind_param("ssssss", $item['project'], $item['work_description'], $item['percentage'], $item['timeIn'], $item['timeOut'], $item['twf']);
            if (!$stmt->execute()) {
                echo "Execute failed: (" . $stmt->errno . ") " . $stmt->error;
            }
        } 
    }
    $mysqli->close();
}
?>