$sql=mysql_query("SELECT user_id FROM users WHERE user_name='".$user_name."' AND user_pass='".$password."' "); 
if(mysql_num_rows($sql) == 0){
   echo "USERID CANNOT BE FOUND";
}
while($row=mysql_fetch_array($sql)) { 
  echo "USERID FOUND" .$row["user_id"] ;
  $user_id=$row["user_id"]; 
}