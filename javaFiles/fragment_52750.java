$str = file_get_contents($url);
list($x, $y, $z) = explode("setCookie(", $str);
list($y) = explode(")", $y);
list($z) = explode(")", $z);
list($a[0], $a[1]) = explode(', ', $y);
list($a[2], $a[3]) = explode(', ', $z);
foreach ($a as &$b) {
    $b = trim ($b, "'");
}
$cookie_str = "$a[0]=$a[1]; $a[2]=$a[3]";
$path = "data1/20130812.lis.Z";
$fp = fopen($path, 'w');
$ch = curl_init ($url);
curl_setopt ($ch, CURLOPT_COOKIE, $cookie_str);
curl_setopt ($ch, CURLOPT_FILE, $fp);
curl_setopt ($ch, CURLOPT_REFERER, $url);
curl_exec($ch);
curl_close($ch);
fclose($fp);