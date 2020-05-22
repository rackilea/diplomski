* Hostname was NOT found in DNS cache
*   Trying 52.6.188.250...
* Connected to dribbble.com (52.6.188.250) port 443 (#0)
* successfully set certificate verify locations:
*   CAfile: none
  CApath: /etc/ssl/certs
* SSLv3, TLS handshake, Client hello (1):
* SSLv3, TLS handshake, Server hello (2):
* SSLv3, TLS handshake, CERT (11):
* SSLv3, TLS handshake, Server key exchange (12):
* SSLv3, TLS handshake, Server finished (14):
* SSLv3, TLS handshake, Client key exchange (16):
* SSLv3, TLS change cipher, Client hello (1):
* SSLv3, TLS handshake, Finished (20):
* SSLv3, TLS change cipher, Client hello (1):
* SSLv3, TLS handshake, Finished (20):
* SSL connection using TLSv1.2 / ECDHE-RSA-AES128-GCM-SHA256
* Server certificate:
*    subject: businessCategory=Private Organization; 1.3.6.1.4.1.311.60.2.1.3=US; 1.3.6.1.4.1.311.60.2.1.2=Massachusetts; serialNumber=001031096; street=Ste. 202; street=16 Front St.; postalCode=01970; C=US; ST=Massachusetts; L=Salem; O=Dribbble LLC; CN=dribbble.com
*    start date: 2014-12-31 00:00:00 GMT
*    expire date: 2016-04-29 12:00:00 GMT
*    subjectAltName: dribbble.com matched
*    issuer: C=US; O=DigiCert Inc; OU=www.digicert.com; CN=DigiCert SHA2 Extended Validation Server CA
*    SSL certificate verify ok.
> GET /shots/qkHY HTTP/1.1
> User-Agent: curl/7.38.0
> Host: dribbble.com
> Accept: */*
> 
< HTTP/1.1 301 Moved Permanently
* Server nginx/1.4.6 (Ubuntu) is not blacklisted
< Server: nginx/1.4.6 (Ubuntu)
< Date: Mon, 12 Oct 2015 13:16:25 GMT
< Content-Type: text/html; charset=utf-8
< Transfer-Encoding: chunked
< Status: 301 Moved Permanently
< X-Frame-Options: SAMEORIGIN
< X-XSS-Protection: 1; mode=block
< X-Content-Type-Options: nosniff
< Location: https://dribbble.com/shots/2278534-Google-Now-Animation
< Cache-Control: no-cache
< Set-Cookie: _dribbble_session=eGhSVTlDV1NEMzBiTUlLMTA0YWlkQ0YzWUJiYUM2cGVGQ1J1cFZYTE9xL3R3UEsvb0VWS1paU1U3bkNRdlh1V3JJZ2JqdW1veTM0azMrTVFRUUlMYUE9PS0tdC9uQTlNR0xvKy9GQmx0R3BkTUtWQT09--9873ba3016e4ab9a99f6a237a975610c01c1eb15; path=/; secure; HttpOnly
< X-Request-Id: 5359c3d6-9d64-4637-8ff5-014e8e44d503
< X-Runtime: 0.006814
< Strict-Transport-Security: max-age=31536000
< X-Frame-Options: SAMEORIGIN
< 
* Connection #0 to host dribbble.com left intact
<html><body>You are being <a href="https://dribbble.com/shots/2278534-Google-Now-Animation">redirected</a>.</body></html>