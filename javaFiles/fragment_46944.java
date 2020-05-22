*** ClientHello, TLSv1.2
--- 8<-- SNIP -----
main, WRITE: TLSv1.2 Handshake, length = 195
main, READ: TLSv1.2 Handshake, length = 1130
*** ServerHello, TLSv1.2
--- 8<-- SNIP -----
%% Initialized:  [Session-79, TLS_DHE_RSA_WITH_AES_128_GCM_SHA256]
** TLS_DHE_RSA_WITH_AES_128_GCM_SHA256
--- 8<-- SNIP -----
Algorithm: [SHA1withRSA]
--- 8<-- SNIP -----
*** Diffie-Hellman ServerKeyExchange
--- 8<-- SNIP -----
*** ServerHelloDone
*** ClientKeyExchange, DH
--- 8<-- SNIP -----
main, WRITE: TLSv1.2 Handshake, length = 133
--- 8<-- SNIP -----
main, WRITE: TLSv1.2 Change Cipher Spec, length = 1
*** Finished
verify_data:  { 108, 116, 29, 115, 13, 26, 154, 198, 17, 125, 114, 166 }
***
main, WRITE: TLSv1.2 Handshake, length = 40
main, called close()
main, called closeInternal(true)
main, SEND TLSv1.2 ALERT:  warning, description = close_notify
main, WRITE: TLSv1.2 Alert, length = 26
main, called closeSocket(true)
main, waiting for close_notify or alert: state 5
main, received EOFException: ignored
main, called closeInternal(false)
main, close invoked again; state = 5
main, handling exception: java.io.IOException: SQL Server returned an incomplete response. The connection has been closed. ClientConnectionId:12a722b3-d61d-4ce4-8319-af049a0a4415