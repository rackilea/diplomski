InputStream in = conn.getInputStream();
OutputStream out = new FileOutputStream("C:/temp/test.pdf");
byte[] buffer = new byte[1024];
int len;
while ((len = in.read(buffer)) != -1) {
    out.write(buffer, 0, len);
}