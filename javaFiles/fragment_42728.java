$key = random_bytes(32);
echo bin2hex($key);
$atomAES = new AtomAES();
$encrypt = $atomAES->encrypt("The quick brown fox jumps over the lazy dog", $key);
echo $encrypt; 
$decrypt = $atomAES->decrypt($encrypt, $key);
echo $decrypt;