public static byte[] getBytes(int length) {
        byte[] bytes = new byte[4];
        bytes[0] = (byte) ( length      & 0xFF);
        bytes[1] = (byte) ((length>>8)  & 0xFF);
        bytes[2] = (byte) ((length>>16) & 0xFF);
        bytes[3] = (byte) ((length>>24) & 0xFF);
        return bytes;
    }