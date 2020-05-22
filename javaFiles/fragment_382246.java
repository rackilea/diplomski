private static final char HEX[] = "0123456789abcdef".toCharArray();


public static String hex(byte data[]) {
    char[] chars = new char[2*data.length];
    for (int i=0; i < data.length; i++) {
        int low = data[i] & 0x0f;
        int high = (data[i] & 0xf0) >> 4;
        chars[i*2] = HEX[high];
        chars[i*2 + 1] = HEX[low];
    }
    return new String(chars);
}

public static byte[] hash(byte data[]) {
    synchronized (DIGEST) {
        DIGEST.reset();
        return DIGEST.digest(data);
    }
}

public static String hash(String value) {
    try {
        byte data[] = hash(value.getBytes("UTF-8"));
        return hex(data);
    } catch (UnsupportedEncodingException e) {
        // Cannot happen: UTF-8 support is required by Java spec
        LOG.error("Failed to generate digest", e);
        throw new RuntimeException(e.getMessage());
    }
}