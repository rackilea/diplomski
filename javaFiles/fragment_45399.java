OutputStream output = con.getOutputStream();
BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
String fileName = readHeader(in);
String baseDir = System.getProperty("my.base.dir", "/home/myname/httpserver");
boolean exist = true;
InputStream fileIn = null;
try {
   File requestedFile = new File(baseDir, fileName);
   fileIn = new FileInputStream(requestedFile);
} catch(Exception e){
    exist = false;
}

String server = "Java Http Server";
String statusLine = null;
String typeLine = null;
String body = null;
String lengthLine = "error";

if (exist) {
   statusLine = "HTTP/1.0 200 OK" + "\r\n";
   //get content type by extension
   typeLine = "Content-type: html/text  \r\n";
   lengthLine = "Content-Length: " + (new Integer(fileIn.available())).toString() + "\r\n";
} else {
  statusLine = "HTTP/1.0 404 Not Found" + CRLF;
  typeLine = "text/html";
  body = "<HTML>" + "<HEAD><TITLE>404</TITLE></HEAD>" + "<BODY>404 Not Found"+"</BODY></HTML>";
}

output.write(statusLine.getBytes());
output.write(server.getBytes());
output.write(typeLine.getBytes());
output.write(lengthLine.getBytes());

output.write("\r\n".getBytes());

if (exist) {
   byte[] buffer = new byte[1024];
   int bytes = 0;

   while ((bytes = fileIn.read(buffer)) != -1) {
     output.write(buffer, 0, bytes);
   }
} else {
   output.write(body.getBytes());
}
//close sreams