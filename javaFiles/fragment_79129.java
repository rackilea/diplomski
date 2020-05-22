ServletOutputStream out = response.getOutputStream();
InputStream in = [ code to get source input stream ];
String mimeType = [ code to get mimetype of data to be served ];
byte[] bytes = new byte[FILEBUFFERSIZE];
int bytesRead;

response.setContentType(mimeType);

while ((bytesRead = in.read(bytes)) != -1) {
    out.write(bytes, 0, bytesRead);
}

// do the following in a finally block:
in.close();
out.close();