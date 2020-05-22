// assuming that checkhashSSHA is public method
// no need to hash the password again
// $hashed_password = $db->checkhashSSHA($user[6], $password);

// $user[5] contains user's hashed password
// $user[7] contains the hashed password from user's input
if($user[5] == $user[7]){
    // password match
}