Protocol:  request.getProtocol(); // Returns HTTP/1.1
Scheme: request.getScheme(); //returns http or https
Context: request.getContextPath(); // return webappname
Request URL: request.getRequestURL() //return http://my.machine.com:1234/webappName/servletpath
Request URI: request.getRequestUri() // returns /servletpath
Host: request.getLocalAddr(); // returns 0:0:0:0:0:0:0:1 (if server is running on localhost)
Port: request.getLocalPort(); // returns 1234
Hostname: request.getServerName(); // returns my.machine.com
Port: request.getServerPort(); // returns 8080