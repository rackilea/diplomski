<?php
$url="your_url_here";
$fileContents= file_get_contents($url);
$fileContents = str_replace(array("\n", "\r", "\t"), '', $fileContents);
$fileContents = trim(str_replace('"', "'", $fileContents));
$simpleXml = simplexml_load_string($fileContents);
$json = json_encode($simpleXml);
echo $json;
?>