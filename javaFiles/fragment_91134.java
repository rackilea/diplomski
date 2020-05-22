<?php
$lng = "12849.52 W";

$brk = strpos($lng,".") - 2;
if($brk < 0){ $brk = 0; }

$minutes = substr($lng, $brk);
$degrees = substr($lng, 0,$brk);

$newLng = $degrees + $minutes/60;

if(stristr($lng,"W")){
    $newLng = -1 * $newLng;
}

?>