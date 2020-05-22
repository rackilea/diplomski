HttpWebRequest  request  = (HttpWebRequest)
WebRequest.Create("http://mymachine:8080/myapp/myservlet?parame1=value1&param2=value2");

// execute the request
HttpWebResponse response = (HttpWebResponse)
request.GetResponse();