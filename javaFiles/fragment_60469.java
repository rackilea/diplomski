public class Main2 {

    static int counter = 0;

    public static void main(String[] args) {
        System.out.println(s("test", "now", "tesntow")); // true
        System.out.println(s("test", "here", "testhere")); // false
        System.out.println(s("test", "here", "tehstere")); // true
        System.out.println(s("test", "new", "tesntewword")); // false
    }

    public static boolean s(String one, String two, String three) {
        String combined = one + two; // combine the two words
        combined = combined.toLowerCase(); // convert to lowercase
        three = three.toLowerCase(); // convert to lowercase

        // check if it has the same length, if not then return false
        // check if it is the same, if it is then return false
        if (combined.length() != three.length() || combined.equals(three)) {
            return false;
        }

        // iterate through the combined words
        for (int i = 0; i < combined.length(); i++) {
            // declare and initialize a flag
            boolean flag = false;

            // check if the current letter of the combine word is in the third word
            flag = three.contains(combined.charAt(i) + ""); // just add empty string to make it a string (Brute force)
            if (!flag) {
                return false;
            }

            // remove the letter from the third word
            int j = three.indexOf(combined.charAt(i));
            three = three.substring(0, j) + three.substring(j);
        }
        return true;
    }
}