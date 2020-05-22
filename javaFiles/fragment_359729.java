// convert from internal Java String format -> UTF-8
public static String convertToUTF8(String s) {
    String out = null;
    try {
        out = new String(s.getBytes("UTF-8"), "ISO-8859-1");
    } catch (java.io.UnsupportedEncodingException e) {
        return null;
    }
    return out;
}