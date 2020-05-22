// read the file
ByteArrayOutputStream out = new ByteArrayOutputStream(10000);
InputStream in = new BufferedInputStream(new FileInputStream(filepath));
int c;
while ((c = in.read()) != -1)
    out.write(c);
in.close();

// debug as string
if (debug) {
   System.out.writeln(new String(out.toBytes(), Charset.forName("utf-8"));
}


// forward to client through response
response.setContentType("text/xml");
response.setCharacterEncoding("UTF-8");
response.getOutputStream().write(out.toBytes());