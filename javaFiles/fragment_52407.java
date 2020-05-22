<?php

$publicKeyPEM = "-----BEGIN PUBLIC KEY-----
MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCD+EKq5ckOMhqZqWYvfro55Weh
ChoZ/e7UqwvtpG8W+l5PgiC8rr0YlAkunBnbOAKG4aM42U+9IYLzuIhzA8eIqnc5
kvr13G2Pu/Wvoi87+Xdsp+bJdbZ92f90jPfEx7KKLSZ41XvNmCrRZYhOCf6scda5
ZQPUxicyYFNaRylT8wIDAQAB
-----END PUBLIC KEY-----";

$privateKeyPEM = "-----BEGIN RSA PRIVATE KEY-----
MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAIP4QqrlyQ4yGpmp
Zi9+ujnlZ6EKGhn97tSrC+2kbxb6Xk+CILyuvRiUCS6cGds4AobhozjZT70hgvO4
iHMDx4iqdzmS+vXcbY+79a+iLzv5d2yn5sl1tn3Z/3SM98THsootJnjVe82YKtFl
iE4J/qxx1rllA9TGJzJgU1pHKVPzAgMBAAECgYAn2C3wwT4J7jC/0jiLAH0je9Lk
+VLWJCgWx6nrTylHS8JryQMvVKa9I/z9uJ3J5UhGBxwrztjXZqXOBhoUd8CnYGGb
Z9IiX6UTKwQ/hx5VC1YhOsKUSjhRhRj4efWJK5/OGMRI8Qape/B779k41GHH+BAJ
uEQ1AVde8MpzD95d6QJBAMV5+d526Bv3U4ONeLIhhrIHIRLUx6kyY5e8u650NYlx
KY1TQsn30fQxxg5EtGpfZqBaw9jv9lF0+oO83+7tK/UCQQCrFHZFbM1PwUbd8NFR
0DMkY0+yrKopMchlZLB5Nfue9zVuOsTZJ2TAlCTjgfOSeC7hsfbc5qKL+rR58e/h
XrdHAkB3ACMwCU2kFK3R973E8mkd/SfUFj9fWYsklEoxPbxJX9UfYg48cUenNRtZ
29Mwyt6oQSoGH8y6l5ijLH1xmKDFAkB65jAwn4C+krI+LgmxJEgZE97lFHUJMuIr
NLIx4T3pbN3NWhqfhVUzozj81xYLWpsTN62H84dB19Be6hbRaCFxAkEAv2WBihV6
ji9BoNuYZDQmrwn3eMjcpMwH0fibU+iur8RH0W/PAS4QzKmxFbwWEtvCIWYoz4ae
rQFeHatd8PnHdw==
-----END RSA PRIVATE KEY-----";

$message_plaintext = "Lorem ipsum dolor sit amet";

$signature = "-----BEGIN SIGNATURE-----
UxhWlr8Ks3PkfaKK8IGGolUs8qjvbE4dXs8ANUtJdw48g8nk6pOEuEscpSiszc1O
fBFEG6lexRFeW4+zpyWHN8oJpVaxz7sd2lstFqu/dUkU8HtPujKkwK6c/3pzsAt8
yHru/BPRwI8Wryqm2dfiHO4cXKq5rIXfj0sSXbwI1PE=
-----END SIGNATURE-----";

function verify_signature($message, $public_key, $signature) {
    $algorithm = OPENSSL_ALGO_SHA512;
    $hash_algorithm = 'sha512';

    $signature = str_replace('-----BEGIN SIGNATURE-----', '', $signature);
    $signature = str_replace('-----END SIGNATURE-----', '', $signature);
    $signature = base64_decode($signature);
    $success = openssl_verify($message, $signature, $public_key,    $algorithm);
    return $success;
}

var_dump(verify_signature($message_plaintext, $publicKeyPEM, $signature));

?>