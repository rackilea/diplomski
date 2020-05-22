InputStream is = getClass().getResourceAsStream("/res/foo");
StringBuffer sb = new StringBuffer();
int chars;
while ((chars = is.read()) != -1)
    sb.append((char) chars);
String str = new String(String.valueOf(sb).getBytes("UTF-8"));