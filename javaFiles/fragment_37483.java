# we need an intermediate PEM file; for safety (PB)encrypt it
openssl pkey <p8unusable.der -inform d -aes256 >temp.pem

# to unencrypted PKCS8
openssl pkcs8 -topk8 <temp.pem -outform d -nocrypt >p8unenc.der

# to encrypted PKCS8 using single-level PKCS12 scheme
openssl pkcs8 -topk8 <temp.pem -outform d -v1 pbeWithSHA1And3-KeyTripleDES-CBC >p8encone.der
# note OpenSSL spells SHA1 where PKCS12 had SHA (which was technically wrong)
# OTOH OpenSSL implies this is PKCS5v1 which it isn't. Bleah.

rm temp.pem # or erase or whatever