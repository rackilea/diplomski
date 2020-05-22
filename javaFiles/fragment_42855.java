FileInputStream fis = openFileInput("My Books");
Reader reader = new InputStreamReader(fis, "UTF-8");
char[] buf = new char[1024];
int red = -1;
StringBuffer sb = new StringBuffer();
while ((red = reader.read(buf)) != -1) {
    sb.append(buf, 0, red);
}
fis.close();