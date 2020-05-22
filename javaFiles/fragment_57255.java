OutputStream os = urlc.getOutputStream();
FileInputStreamReader fis = new FileInputStream(file);
byte[] buffer = new byte[1000];
int count = 0;
while((count = fis.read(buffer)) > 0) {
    os.write(buffer, 0, count);
}