URL url = new URL("http://207.200.96.231:8008");
URLConnection con = url.openConnection();
InputStream is = con.getInputStream();
BufferedInputStream in = new BufferedInputStream(is);
int c;
while ((c = in.read()) != -1) {
    System.out.write(c);
}