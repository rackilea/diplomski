<?php
$string = "online1234";
$key = "haskingvista127$";

$iv  = base64_encode(openssl_random_pseudo_bytes(openssl_cipher_iv_length('aes-128-cbc')));

$encodedEncryptedData = base64_encode(openssl_encrypt($string, "AES-128-CBC", $key, OPENSSL_RAW_DATA, base64_decode($iv)));

$decryptedData = openssl_decrypt(base64_decode($encodedEncryptedData), "AES-128-CBC", $key, OPENSSL_RAW_DATA, base64_decode($iv));

?>