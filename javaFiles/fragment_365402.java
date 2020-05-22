// assuming that checkhashSSHA is public method
$hashed_password = $db->checkhashSSHA($user[6], $password);

if($user[7] == $hashed_password){
    // password match
}