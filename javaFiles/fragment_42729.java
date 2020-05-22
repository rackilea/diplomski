$encKey = mb_convert_encoding("VEMwcCYfFpsrXQVIFTDrA/2zP/5PYOY6JC1XEkEcLGSk/klt+HqHzGSr781Yznku", "UTF-8");
$asp_secret = mb_convert_encoding("DTosv9G179D0cY1985Uh2eF6ND80C95L", "UTF-8");

atomAES = new AtomAES();
$enc_key = $atomAES->decrypt($encKey, $asp_secret);
$enc_asp_secret = $atomAES->encrypt($asp_secret, base64_decode(base64_encode($enc_key)));
//$enc_asp_secret = $atomAES->encrypt($asp_secret, $enc_key);

echo "asp secret encrypted:\n".mb_convert_encoding($enc_asp_secret, "UTF-8")."\n";