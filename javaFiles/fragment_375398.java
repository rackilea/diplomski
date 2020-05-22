<?php
function Encrypt($data, $secret) {    
  // get the amount of bytes to pad
    $extra = 8 - (strlen($data) % 8);
    // add the zero padding
    if($extra > 0) {
        for($i = 0; $i < $extra; $i++) {
            $data .= "\0";
        }
    } 
  //Encrypt data
  $encData = mcrypt_encrypt('tripledes',$secret, $data, 'ecb');
  //return hex format
  return bin2hex($encData);
}

function Decrypt($data, $secret) {
    $data = hex2bin($data);
    $data = mcrypt_decrypt('tripledes', $secret, $data, 'ecb');
    return $data;
}

$secretKey = '1234567890qwertyuiopasdf'; //key must be 24 chars

$textToEncrypt = "Hello World";

$encrypted = Encrypt($textToEncrypt, $secretKey);
echo strtoupper($encrypted);

/*Line break*/
echo "<br />";
/*Decryption*/
$textToDecrypt = $encrypted;
$decrypted = Decrypt($textToDecrypt, $secretKey);
echo $decrypted;

?>