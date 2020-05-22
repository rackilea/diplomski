% Total    % Received % Xferd  Average Speed   Time    Time     Time  Current
                             Dload  Upload   Total   Spent    Left  Speed
  0     0    0     0    0     0      0      0 --:--:-- --:--:-- --:--:--     0*   
Trying ::1...
* TCP_NODELAY set
* Connected to localhost (::1) port 8080 (#0)
> GET / HTTP/1.1
> Host: localhost:8080
> User-Agent: curl/7.56.1
> Accept: */*
> Expect: 100-continue
>
< HTTP/1.1 100
< HTTP/1.1 200
< Set-Cookie: JSESSIONID=9355141A10CF546E9A9A43F5A5C0B1A4; Path=/; HttpOnly
< Content-Type: text/html;charset=ISO-8859-1
< Content-Length: 58
< Date: Tue, 31 Jul 2018 17:27:52 GMT
<
{ [58 bytes data]
100    58  100    58    0     0     58      0  0:00:01 --:--:--  0:00:01    82<html>
<body>
<h2>Hello Heroku!</h2>
</body>
</html>

* Connection #0 to host localhost left intact