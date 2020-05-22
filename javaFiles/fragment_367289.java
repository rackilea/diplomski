$length = 60;
$salt =  "MySalt";
$interation = 10;
$bytes = openssl_pbkdf2("mypasspharse", $salt, $length, $interation, "sha1");

for ($i = 0; $i < 60; $i++)
{
    echo dechex(ord($bytes[$i]));
    echo '<br>';
}