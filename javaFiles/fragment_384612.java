import java.util.stream.Collectors;

class StringRepr {
    private static String escapeChar(int c) {
        if (c <= 0x7f) {
            return Character.toString((char) c);
        } else {
            return "\\u" + String.format("%04x", c);
        }
    }

    public static String escape(String s) {
        return s.chars().mapToObj(c -> escapeChar(c)).collect(Collectors.joining());
    }

    public static void main (String[] args) {
        System.out.println(escape(""));
    }
}