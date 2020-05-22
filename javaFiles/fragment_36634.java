$enc_data = 'iufp4Rl+x/yTO7hSQBH7uU63sXAyzxgLequ3+JkFYZFz3PWwhxDC87TEC+bZ4rirgZVasrkLE1ehWWRGFV42Z29vAok+TMdwOvOettELUD3g8W2F40OyjMg4ItYkiZM+2W6Q2zf6t4sLzM6/AYqmAy1dKjPJcCQaFcnqK6mUFcM=';
$key = 'e510a13edeea112b57683d724d5d70a6';
$key16 = substr($key, 0, 16);
$key16Hex = unpack('H*', $key16);

print openssl_decrypt($enc_data, "AES-128-CBC", $key16, 0, hex2bin($key16Hex[1]));