p = pb.start();
InputStream opt = p.getInputStream();
ByteArrayOutputStream boas = new ByteArrayOutputStream();
byte[] buffer = new byte[2048];
int bytesRead;
while (!p.waitFor(50, TimeUnit.MILLISECONDS)) {
    while ((bytesRead = opt.read(buffer)) > 0) {
        boas.write(buffer, 0, bytesRead);
    }
}
// Reading the final part of the output 
while ((bytesRead = opt.read(buffer)) > 0) {
    boas.write(buffer, 0, bytesRead);
}
s = new String(boas.toByteArray());
System.out.println(s);