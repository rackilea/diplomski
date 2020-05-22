$ curl -D- http://localhost:9000/analyze -d '{"text":"bla"}'
HTTP/1.1 200 OK
Content-Type: application/json
Content-Length: 67
Set-Cookie: vertx-web.session=21ff020c9afa5ec9fd5948acf64c5a85; Path=/

You POSTed JSON which contains a text attribute with the value: bla