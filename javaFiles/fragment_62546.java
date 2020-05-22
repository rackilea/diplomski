<?php

    $inHandle= fopen("input.csv", "r");

    $text = "";
    $someVar = array(1, 2, 3, 4);           // for subtracting 1 from col1 2 from col2 ...

    while ( ( $data = fgetcsv($inHandle) ) !== FALSE) 
    {
    $text  = $text  . $data[0];

    for ($i= 1; $i < count($data);  $i++) 
    {

        if($i==0)
            $text =  $text .  $data[$i] . ", ";
        else
            $text =  $text .  ( $data[$i] - $someVar[$i -1] ) . " , ";
    }
       $text =  $text . " \n";
    }

    fclose($inHandle);

    $outHandle = fopen('output.csv', 'w');

    fwrite($outHandle , $text );

    fclose($outHandle );
    ?>