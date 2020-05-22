$string_letters = "c,o,d,e";
$array = explode(",",$string_letters);
shuffle($array); // <- i assume 'suffle' was a spelling mistake
$string_output = "";

foreach ($array as $char)
{
    $string_output .= $char;
}

echo $string_output;