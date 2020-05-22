<?php
    $filepath = "[your path]"; 
    $fileContents = file_get_contents("$filepath");

    $result = parse_preperties($fileContents);

    //Fetch the contents from the result array and add them to the database

    function parse_properties($txtProperties) {
     ...
     ...
     ...
     }
?>