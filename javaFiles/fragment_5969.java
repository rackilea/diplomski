arturk:tmp artur$ curl -XPOST "localhost:9085/hello/world/v2/" --header "Content-Type: application/json" -d @user_json2 -v
*   Trying ::1...
* Connected to localhost (::1) port 9085 (#0)
> POST /hello/world/v2/ HTTP/1.1
> Host: localhost:9085
> User-Agent: curl/7.43.0
> Accept: */*
> Content-Type: application/json
> Content-Length: 19
>
* upload completely sent off: 19 out of 19 bytes
< HTTP/1.1 400 Bad Request
< Date: Fri, 27 May 2016 10:07:41 GMT
< Content-Type: text/html;charset=iso-8859-1
< Cache-Control: must-revalidate,no-cache,no-store
< Content-Length: 251
<
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
<title>Error 400 Bad Request</title>
</head>
<body><h2>HTTP ERROR 400</h2>
<p>Problem accessing /hello/world/v2/. Reason:
<pre>    Bad Request</pre></p>
</body>
</html>
* Connection #0 to host localhost left intact