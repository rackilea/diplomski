$SuccessUrl = FileName . "?javaOK=1&" . $_SERVER['QUERY_STRING'];   
    (...)
    $java_detect=EOQ (heredoc shoud be here, some tags don't work)
        
        var version = '1.7'; //required version

        var check = deployJava.versionCheck(version+"+"); //1.7 and higher
        if(!check){ 
          $("#sign_dialog").html("$java_err"); //wrong java or no java at all
        }else{
          $("#sign_dialog").load("$SuccessUrl");
        }
      
    EOQ;
    (...)
        if(isset($_GET['javaOK']) && $_GET['javaOK']=='1'){
          echo $applet;
        }else{
          echo $java_detect;
        }