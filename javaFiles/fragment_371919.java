<?php 
     $file_path = "test/";
     $username= $_POST["username"];
     $password= $_POST["password"];
     $file_path = $file_path . basename( $_FILES['uploaded_file']['name']);
     if(move_uploaded_file($_FILES['uploaded_file']['tmp_name'], $file_path)) {
         echo "success";
     } else{
         echo "fail";
     }

?>