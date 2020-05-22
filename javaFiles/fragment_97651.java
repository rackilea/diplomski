System.out.println(
      ("HTTP/1.1 206 Partial Content\n"
      + "Last-Modified: Thu, 18 Sep 2014 03:04:38 GMT\n"
      + "Content-Type: video/mp4\n"
      + "Date: Sat, 14 Mar 2015 21:44:08 GMT\n"
      + "Expires: Sat, 14 Mar 2015 21:44:08 GMT\n"
      + "Cache-Control: private, max-age=21294\n"
      + "Content-Range: bytes 0-17016614/17016615\n"
      + "Accept-Ranges: bytes\n"
      + "Content-Length: 17016615\n"
      + "Connection: keep-alive").matches("^(HTTP|http)/(1|2)\\.\\d \\d{3}(.|\\s)+$"));