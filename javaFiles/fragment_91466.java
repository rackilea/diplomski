mysql_connect("my_domain","my_user","my_password");
    mysql_select_db("GCM_ID");

    $id=$_REQUEST['GCM_ID'];

    $flag['code']=0;

    if($r=mysql_query("insert into GCM_ID(GCM_ID) VALUES('$id')"))
    {
        $flag['code']=1;
        echo"hi";
    }

    echo json_encode($flag);
    mysql_close();