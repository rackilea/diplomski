import java.nio.ByteBuffer;

/**
 * Created by peter on 09/08/2015.
 */
public enum ByteBuffers {
    ;
    /**
     * Writes in ISO-8859-1 encoding. This assumes string up to 127 bytes long.
     *
     * @param bb to write to
     * @param cs to write from
     */
    public static void writeText(ByteBuffer bb, CharSequence cs) {
        // change to stop bit encoding to have lengths > 127
        assert cs.length() < 128;
        bb.put((byte) cs.length());
        for (int i = 0, len = cs.length(); i < len; i++)
            bb.put((byte) cs.charAt(i));
    }

    public static StringBuilder readText(ByteBuffer bb, StringBuilder sb) {
        int len = bb.get();
        assert len >= 0;
        sb.setLength(0);
        for (int i = 0; i < len; i++)
            sb.append((char) (bb.get() & 0xFF));
        return sb;
    }

    private static final ThreadLocal<StringBuilder> SB = new ThreadLocal<>() {
        @Override
        protected Object initialValue() {
            return new StringBuilder();
        }
    };

    public static String readText(ByteBuffer bb) {
        // TODO use a string pool to reduce String garbage.
        return readText(bb, SB.get()).toString();
    }
}