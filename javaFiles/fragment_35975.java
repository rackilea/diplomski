URL url = new URL(myfile);
InputStream is = url.openStream();
byte[] buf = new byte[1024];
int read = -1;
StringBuilder bld = new StringBuilder();
while ((read = is.read(buf, 0, buf.length) != -1) {
  bld.append(new String(buf, 0, read, "utf-8"));
}

String s = bld.toString();