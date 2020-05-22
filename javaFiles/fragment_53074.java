$res = mysqli_query($connectionLink, "SELECT Password FROM tbl_user WHERE Username='$uname'");
$row_cnt = mysqli_num_rows($res); // check the records

if($row_cnt){
    $row = mysqli_fetch_array($res); // fetch the data
    if($row['Password'] == $upass){ // check condition (bad practice)
        // your stuff
    }
}