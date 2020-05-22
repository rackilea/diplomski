function bytesEnc($string){
  $string = str_replace(PHP_EOL, '', $string);

  $bytes = array();
  for($i = 0; $i < strlen($string) - 1; $i++){
    $bytes[] = ord($string[$i]);
  }
  return $bytes;
}

echo base64_encode(implode('',bytesEnc('users name')));