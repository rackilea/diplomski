public class Test {
    public static void main(String[] args) throws Exception {
        String[] strings = { "0b1111", "017", "15", "0xf" };
        for (String string : strings) {
            System.out.println(decode(string)); // 15 every time
        }
    }

    private static int decode(String text) {
        return text.toLowerCase().startsWith("0b") ? Integer.parseInt(text.substring(2), 2)
                                     : Integer.decode(text);
    }

}