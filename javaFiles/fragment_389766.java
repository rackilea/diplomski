public static String toHexString(byte[] bytes) {  
    StringBuilder out = new StringBuilder();
    for (byte b: bytes) {
        out.append(String.format("%02X", b) + " ");
    }
    return out.toString();
}