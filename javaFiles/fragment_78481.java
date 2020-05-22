public class FindRanges {

    public static void main(String[] args) {
        char last0 = '\0';
        char last1 = '\0';
        for (int x = 0x1F300; x <= 0x1F5FF; ++x) {
            char[] chars = new StringBuilder().appendCodePoint(x).toString().toCharArray();
            if (chars[0] != last0) {
                if (last0 != '\0') {
                    System.out.println("-\\u" + Integer.toHexString((int)last1).toUpperCase());
                }
                System.out.print("\\u" + Integer.toHexString((int)chars[0]).toUpperCase() + " \\u" + Integer.toHexString((int)chars[1]).toUpperCase());
                last0 = chars[0];
            }
            last1 = chars[1];
        }
        if (last0 != '\0') {
            System.out.println("-\\u" + Integer.toHexString((int)last1).toUpperCase());
        }
    }
}