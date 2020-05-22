<?php
    $lines = file('ipaddresses.txt');
    $newtext = '';
    foreach ($lines as $line) 
    {
        $newtext.= "Ip Number {$line} Num {$line}}\n";
    }
    $handle = fopen('export.txt', 'w');
    fwrite($handle, $newtext);
    fclose($handle);
?>