public class StringUtils {
    private static final ThreadLocal<ByteBuffer> BUFFER = ThreadLocal.withInitial(() -> ByteBuffer.allocateDirect(4094));

    public static long crc32(String input) {
        CharBuffer inputBuffer = CharBuffer.wrap(input);
        ByteBuffer buffer = BUFFER.get();
        CRC32 crc32 = new CRC32();
        CharsetEncoder encoder = Charset.defaultCharset().newEncoder();

        CoderResult coderResult;
        do {
            try {
                coderResult = encoder.encode(inputBuffer, buffer, true);
                buffer.flip();
                crc32.update(buffer);
            } finally {
                buffer.reset();
            }
        } while (coderResult.isOverflow());

        return crc32.getValue();
    }
}