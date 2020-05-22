<?php
 $response = array();
if (empty($_FILES) || $_FILES['file']['error']) {
 $response["code"] = 2;
        $response["message"] = "failed to move uploaded file";
        echo json_encode($response);
 }

$chunk = isset($_REQUEST["chunk"]) ? intval($_REQUEST["chunk"]) : 0;
$chunks = isset($_REQUEST["chunks"]) ? intval($_REQUEST["chunks"]) : 0;

$fileName = isset($_REQUEST["name"]) ? $_REQUEST["name"] : $_FILES["file"]["name"];
$filePath = "uploads/$fileName";


// Open temp file
$out = @fopen("{$filePath}.part", $chunk == 0 ? "wb" : "ab");

if ($out) {
  // Read binary input stream and append it to temp file
  $in = @fopen($_FILES['file']['tmp_name'], "rb");

  if ($in) {
    while ($buff = fread($in, 4096))
          fwrite($out, $buff);

  } else

 $response["code"] = 2;
 $response["message"] = "Oops!  Failed to open input Stream error occurred.";
 echo json_encode($response);
  @fclose($in);

  @fclose($out);

  @unlink($_FILES['file']['tmp_name']);
} else

   $response["code"] = 2;
        $response["message"] = "Oops! Failed to open output error occurred.";
        echo json_encode($response);


// Check if file has been uploaded
if (!$chunks || $chunk == $chunks - 1) {
  // Strip the temp .part suffix off
  rename("{$filePath}.part", $filePath);
}
  $response["code"] = 2;
        $response["message"] = "successfully uploaded";
        echo json_encode($response);

?>