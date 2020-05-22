public class MyClass {

    private static final Map<String, Character> MAP = new HashMap<>();

    static {
        MAP.put("AAAAA", 'a');
        MAP.put("BAABA", 's');
    }

    public String decode(String msg) {
        if (msg == null || msg.length() % 5 != 0)
            throw new IllegalArgumentException("Message length should be a multiple of 5");

        StringBuilder buf = new StringBuilder();

        for (int i = 0; i < msg.length(); i += 5) {
            String letters = msg.substring(i, i + 5);
            Character ch = MAP.get(letters);

            if (ch == null)
                throw new IllegalArgumentException("Letters '" + letters + "' not found in local map");

            buf.append(ch);
        }

        return buf.toString();
    }
}