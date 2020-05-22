$key =  "-----BEGIN PUBLIC KEY-----\n".
        chunk_split($pubkey, 64,"\n").
       '-----END PUBLIC KEY-----';  
$key = openssl_get_publickey($key);
$signature = base64_decode($signature);
$validated = openssl_verify($data, $signature, $key);        
return $validated;