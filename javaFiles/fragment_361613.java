static byte[] convert(List<Byte> list) {
        final byte[] bytes = new byte[list.size()];
        int idx = 0;
        for (byte b : list) {
            bytes[idx] = b;
            idx++;
        }
        return bytes;
    }