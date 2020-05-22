public static boolean deserializeBoolean(InputStream inputStream) {
        byte[] databytesArr = new byte[1];
        try {
            inputStream.read(databytesArr);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (ByteBuffer.wrap(databytesArr).get() == 1) {
            return true;
        } else {
            return false;
        }
    }