class OpensslAES
{
    const METHOD = 'aes-256-cbc';

    public static function encrypt($message, $key)
    {
        if (mb_strlen($key, '8bit') !== 32) {
            throw new Exception("Needs a 256-bit key!");
        }
        $ivsize = openssl_cipher_iv_length(self::METHOD);
        $iv = hex2bin('00000000000000000000000000000000');

        return openssl_encrypt(
            $message,
            self::METHOD,
            $key,
            OPENSSL_RAW_DATA,
            $iv
        );
    }

    public static function decrypt($message, $key)
    {
        if (mb_strlen($key, '8bit') !== 32) {
            throw new Exception("Needs a 256-bit key!");
        }
        $ivsize = openssl_cipher_iv_length(self::METHOD);
        $iv = hex2bin('00000000000000000000000000000000');

        return openssl_decrypt(
            $message,
            self::METHOD,
            $key,
            OPENSSL_RAW_DATA,
            $iv
        );
    }
}

$class = new OpensslAES();

var_dump($class->decrypt(base64_decode("cBVlMjBttr7DKW8fhHtqJOLyMBNrgxpIJsgFFPjkA/4MWxMIudOnYzS4WuxIhUjtgGgk4CzrkJ1G60R4OWBljNTMA9ATPKh9PXe7wXAwJfE9zc698bQv4lDkXRME+q4xCb3bK/UGQ/BPVIkmRYdHcBvIHXNzGd36Nn40giigY/g="), hex2bin("SECRET_KEY_GOES_HERE")));