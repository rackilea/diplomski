public class PrintB {

    public static void main(String[] args) {
        Map<Character, Integer> map = new HashMap<>();

        String s = "abcdabcdabcdacd";
        char[] chars = s.toCharArray();

        for (Character ch: chars) {
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }

        Set<Character> keys = map.keySet();
        boolean broken = false;
        for ( int i = 0; i < s.length(); i++ ) { // the max will be s.length()

            for (Character ch : keys) {
                if (map.get(ch) == i) { // this amount is checked for each char
                    System.out.println(ch + " ");
                    broken = true;
                }
            }
            if ( broken ) {
                i = s.length(); // sure, there are other ways to break out of the loop
            }
        }
    }
}