URL url = new URL(fileURL);
URLConnection conexion = url.openConnection();
conexion.connect();
int lenghtOfFile = conexion.getContentLength();
Log.d("ANDRO_ASYNC", "Lenght of file: " + lenghtOfFile);
InputStream input = new BufferedInputStream(url.openStream());
OutputStream output = new FileOutputStream("/sdcard/caldophilus.jpg");
byte data[] = new byte[1024];
long total = 0;
while ((count = input.read(data)) != -1) {
total += count;
output.write(data, 0, count);
}
output.flush();
output.close();
input.close();