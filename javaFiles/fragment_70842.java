function encrypt($data, $secret)  {
    $key = sha1(mb_convert_encoding($secret, "UTF-8"), true);                   // Create SHA-1 hash (20 byte) 
    $key = str_pad($key, 24, "\0");                                             // Extend to 24 byte by appending 0-values (would also happen automatically on openssl_encrypt-call)
    $encrypted = openssl_encrypt($data, 'DES-EDE3', $key, OPENSSL_RAW_DATA);    // Encryption: DESede (24 byte key), ECB-mode, PKCS5-Padding
    return base64_encode($encrypted);                                           // Base64-encoding
}