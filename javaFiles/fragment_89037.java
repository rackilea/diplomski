public static String ToHexString(byte[] bytes) {   
    StringBuilder sb = new StringBuilder();   
    Formatter formatter = new Formatter(sb);   
    for (byte b : bytes) {
        formatter.format("%02x", b);   
    }
    return sb.toString();   
}