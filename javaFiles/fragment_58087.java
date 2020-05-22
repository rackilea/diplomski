[DEBUG] RequestAddCookies - CookieSpec selected: best-match
[DEBUG] RequestAuthCache - Auth cache not set in the context
[DEBUG] PoolingHttpClientConnectionManager - Connection request: [route: {s}->https://www.ebs.tga.gov.au:443][total kept alive: 0; route allocated: 0 of 100; total allocated: 0 of 200]
[DEBUG] PoolingHttpClientConnectionManager - Connection leased: [id: 0][route: {s}->https://www.ebs.tga.gov.au:443][total kept alive: 0; route allocated: 1 of 100; total allocated: 1 of 200]
[DEBUG] MainClientExec - Opening connection {s}->https://www.ebs.tga.gov.au:443
[DEBUG] HttpClientConnectionOperator - Connecting to www.ebs.tga.gov.au/161.146.233.4:443
[DEBUG] HttpClientConnectionOperator - Connection established 192.168.42.63:40880<->161.146.233.4:443
[DEBUG] MainClientExec - Executing request HEAD / HTTP/1.1
[DEBUG] MainClientExec - Target auth state: UNCHALLENGED
[DEBUG] MainClientExec - Proxy auth state: UNCHALLENGED
[DEBUG] headers - http-outgoing-0 >> HEAD / HTTP/1.1
[DEBUG] headers - http-outgoing-0 >> Host: www.ebs.tga.gov.au
[DEBUG] headers - http-outgoing-0 >> Connection: Keep-Alive
[DEBUG] headers - http-outgoing-0 >> User-Agent: Apache-HttpClient/4.3.3-SNAPSHOT (java 1.5)
[DEBUG] headers - http-outgoing-0 << HTTP/1.1 200 OK
[DEBUG] headers - http-outgoing-0 << Server: Lotus-Domino
[DEBUG] headers - http-outgoing-0 << Date: Tue, 18 Feb 2014 15:25:32 GMT
[DEBUG] headers - http-outgoing-0 << Content-Type: text/html
[DEBUG] headers - http-outgoing-0 << Content-Length: 15765
[DEBUG] headers - http-outgoing-0 << Expires: Thu, 01 Jan 1970 23:59:59 GMT
[DEBUG] headers - http-outgoing-0 << Cache-control : no-cache, no-store, private Pragma: Value: no-cache
[DEBUG] MainClientExec - Connection can be kept alive indefinitely
[DEBUG] PoolingHttpClientConnectionManager - Connection [id: 0][route: {s}->https://www.ebs.tga.gov.au:443] can be kept alive indefinitely
[DEBUG] PoolingHttpClientConnectionManager - Connection released: [id: 0][route: {s}->https://www.ebs.tga.gov.au:443][total kept alive: 1; route allocated: 1 of 100; total allocated: 1 of 200]