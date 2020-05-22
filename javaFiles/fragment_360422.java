<?php
$con=mysqli_connect("localhost","root","") or  die(mysql_error());
mysqli_select_db($con,"something")or die("Unable to connect 1");
$response = array();
$response["success"] = 0;
$email = $_POST['email']; 
$passwd = $_POST['pass']; 
$query1 = mysqli_query($con,"SELECT pass FROM userinfo where email='$email'");

   $res= mysqli_fetch_assoc($query1);
        if($res)
        {
             if($passwd!=$res['pass'])
            {                    
                $response["success"]=1;
                print(json_encode($response));
            }
            else 
            {                    
                $response["success"]=0;
                print(json_encode($response));          
            }
        }
        else
        {
            $response["success"]=0;
            print(json_encode($res));   
        }
?>