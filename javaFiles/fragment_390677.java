private static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");

public static List<byte[]> splitMessageSept19(byte[] rawByte, String tokenDelimiter) {
    Pattern pattern = Pattern.compile(tokenDelimiter, Pattern.LITERAL);
    String[] parts = pattern.split(new String(rawByte, ISO_8859_1), -1);
    List<byte[]> ret = new ArrayList<byte[]>();
    for (String part : parts) 
        ret.add(part.getBytes(ISO_8859_1));
    return ret;
}

public static void main(String... args) {
    StringBuilder sb = new StringBuilder();
    for(int i=0;i<256;i++)
        sb.append((char) i);
    byte[] bytes = sb.toString().getBytes(ISO_8859_1);
    List<byte[]> list = splitMessageSept19(bytes, ",");
    for (byte[] b : list) 
        System.out.println(Arrays.toString(b));
}