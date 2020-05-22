<?php
    // to return plain text
    header("Content-Type: plain/text"); 
    $imei = $_GET["imei"];
    // make a DB call to check if IMEI exists
    // store "true" or "false" string in $retval
    echo($retval);
?>