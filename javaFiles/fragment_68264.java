System.out.println("opening connection");
URL url = new URL("https://upload.wikimedia.org/wikipedia/en/8/87/Example.JPG");
InputStream in = url.openStream();
FileOutputStream fos = new FileOutputStream(new File("yourFile.jpg"));

System.out.println("reading from resource and writing to file...");
int length = -1;
byte[] buffer = new byte[1024];// buffer for portion of data from connection
while ((length = in.read(buffer)) > -1) {
    fos.write(buffer, 0, length);
}
fos.close();
in.close();
System.out.println("File downloaded");