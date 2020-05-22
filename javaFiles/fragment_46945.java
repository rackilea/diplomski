*** ClientHello, TLSv1.2
--- 8<-- SNIP -----
main, WRITE: TLSv1.2 Handshake, length = 207
main, READ: TLSv1 Handshake, length = 604
*** ServerHello, TLSv1
--- 8<-- SNIP -----
Cipher Suite: TLS_RSA_WITH_AES_128_CBC_SHA
--- 8<-- SNIP -----
%% Initialized:  [Session-79, TLS_RSA_WITH_AES_128_CBC_SHA]
** TLS_RSA_WITH_AES_128_CBC_SHA
--- 8<-- SNIP -----
Algorithm: [SHA1withRSA]
--- 8<-- SNIP -----
***
*** ServerHelloDone
*** ClientKeyExchange, RSA PreMasterSecret, TLSv1
--- 8<-- SNIP -----
main, WRITE: TLSv1 Handshake, length = 134
main, WRITE: TLSv1 Change Cipher Spec, length = 1
*** Finished
verify_data:  { 26, 155, 166, 89, 229, 193, 126, 39, 103, 206, 126, 21 }
***
main, WRITE: TLSv1 Handshake, length = 48
main, READ: TLSv1 Change Cipher Spec, length = 1
main, READ: TLSv1 Handshake, length = 48
*** Finished