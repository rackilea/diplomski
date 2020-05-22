public static void main(String[] args) throws Exception {
    try (ByteArrayOutputStream byteStream = new ByteArrayOutputStream()) {

        try (DataOutputStream outStream = new DataOutputStream(byteStream)) {
            // floats
            writeFloat(-456.678f, outStream);
            writeFloat(0f, outStream);
            writeFloat(Float.MAX_VALUE, outStream);

            // bytes
            outStream.writeByte(0);
            outStream.writeByte(120);
            outStream.writeByte(255);

            // longs (uints)
            writeUint(0L, outStream);
            writeUint(65000L, outStream);
            writeUint(4294967295L, outStream);
        }

        String base64String = Base64.getEncoder().encodeToString(byteStream.toByteArray());
        System.out.println(base64String);
    }
}

private static void writeFloat(float f, DataOutputStream stream) throws Exception {
    int val = Float.floatToIntBits(f);
    stream.writeByte(val & 0xFF);
    stream.writeByte((val >>> 8) & 0xFF);
    stream.writeByte((val >>> 16) & 0xFF);
    stream.writeByte((val >>> 24) & 0xFF);
}

private static void writeUint(long val, DataOutputStream stream) throws Exception {
    stream.writeByte((int) (val & 0xFF));
    stream.writeByte((int) ((val >>> 8) & 0xFF));
    stream.writeByte((int) ((val >>> 16) & 0xFF));
    stream.writeByte((int) ((val >>> 24) & 0xFF));
}