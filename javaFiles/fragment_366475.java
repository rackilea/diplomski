public class Test {
    public static void main(String[] args) {
        combinations("bob");
    }

    private static void combinations(String name) {
        char[] chars  = name.toCharArray();

        for (int i = 0; i < Math.pow(2, chars.length); i++) {
            char[] result = new char[chars.length];

            for (int n = 0; n < chars.length; n++) {
                result[n] = isBitSet(i, n) ? Character.toUpperCase(chars[n])
                                           : Character.toLowerCase(chars[n]);
            }

            System.out.println(result);
        }
    }

    private static boolean isBitSet(int i, int n) {
        return ((i & (1 << n)) != 0);
    }
}