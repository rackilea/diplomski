public static String byteToHexString(byte b) {
    String result = "";
    result += Integer.toHexString((int)(b >> 4) & 0xf);
    result += Integer.toHexString((int)(b) & 0xf);
    return result;
}

public static String bytesToHexString(final byte[] byteArray) {
    if (byteArray == null) {
        return null;
    }
    String result = "";
    for (int i = 0; i < byteArray.length; ++i) {
        result += byteToHexString(byteArray[i]);
    }
    return result;
}

public static byte[] hexStringToBytes(final String hexString) {
    if (hexString == null) {
        return null;
    }
    byte[] result = new byte[hexString.length() / 2];
    for (int idx = 0; idx < result.length; ++idx) {
        int strIdx = idx * 2;
        result[idx] = (byte) ((Character.digit(hexString.charAt(strIdx), 16) << 4)
                + Character.digit(hexString.charAt(strIdx + 1), 16));
    }
    return result;
}