<?php

$out="POST = " . var_export($_POST, true) . "\n";
$out.="GET = " . var_export($_GET, true) . "\n";
$out.="request = " . var_export(getallheaders(), true) . "\n";
print $out;

?>