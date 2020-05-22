static String hexEncode(byte [] data) {
    StringBuilder hex = new StringBuilder();
    for (byte b : data) hex.append(String.format("%02x", b));
    return hex.toString();
}

String hash = hexEncode(md.digest());