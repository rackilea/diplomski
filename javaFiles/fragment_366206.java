public static void writeLine(OutputStream w, etc...) throws IOException {

    :
    sb.append("\n");
    String str = sb.toString();
    byte[] bytes = str.getBytes(Charset.forName("UTF-8"));
    w.write(bytes);
}