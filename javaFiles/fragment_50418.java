$deg_coord = '5224.09960';

$lat = (int)(substr($deg_coord,0,2));
$lat2 = (float) (substr($deg_coord,2));

$lat2 = $lat2*10000;
$lat2 = $lat2/60*10000;
$lat2 = $lat2/100000000;
echo $lat += $lat2;
exit;