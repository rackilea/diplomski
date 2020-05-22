$key  = 'ABC';
$data = '1234567';
$alg  = MCRYPT_BLOWFISH;
$mode = MCRYPT_MODE_ECB;

$blocksize = mcrypt_get_block_size('blowfish', 'ecb'); // get block size 
$pkcs = $blocksize - (strlen($data) % $blocksize); // get pkcs5 pad length 
$data.= str_repeat(chr($pkcs), $pkcs);

$encrypted_data = mcrypt_encrypt($alg, $key, $data, $mode);

$phpgeneratedtoken  = base64_encode($encrypted_data);

print "PHP generated token: " . $phpgeneratedtoken."   ";
// return
// Cg8qY4gRMaI=