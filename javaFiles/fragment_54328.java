<?php
require 'vars.php';
$projid=$_POST['projId'];
$devid=$_POST['devId'];
$owner=$_POST['owner'];
$regid=$_POST['regId'];

//echo $owner;  echo $projid; echo $devid;
$mysqli = new mysqli("localhost", $user, $pwd, $database);

$regidIN = mb_convert_encoding($regid, "UTF-8");
$projectIN = mb_convert_encoding($projid, "UTF-8");
$deviceIN = mb_convert_encoding($devid, "UTF-8");
$ownerIN = mb_convert_encoding($owner, "UTF-8");

$queryone="replace into registrations (device, project, owner, regid)
           values ('$deviceIN', '$projectIN', '$ownerIN', '$regidIN')";

if (!($stmt = $mysqli->prepare( $queryone))) {
    echo "Prepare failed: (" . $mysqli->errno . ") " . $mysqli->error;
}
if (!$stmt->execute()) {
    echo "Execute failed: (" . $stmt->errno . ") " . $stmt->error;
}
$stmt->close();
$mysqli->close();
?>