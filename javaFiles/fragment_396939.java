<?
function pem2der($pem_data) {
  $begin = "KEY-----";
  $end   = "-----END";
  $pem_data = substr($pem_data, strpos($pem_data, $begin)+strlen($begin));
  $pem_data = substr($pem_data, 0, strpos($pem_data, $end));
  $der = base64_decode($pem_data);
  return $der;
}

function der2pem($der_data) {
  $pem = chunk_split(base64_encode($der_data), 64, "\n");
  $pem = "-----BEGIN PUBLIC KEY-----\n".$pem."-----END PUBLIC KEY-----\n";
  return $pem;
}

// load the public key from a DER-encoded file
$pubkey = der2pem(file_get_contents("pubkey"));
?>