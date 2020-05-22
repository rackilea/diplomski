public class MyClass {
    public static void main(String args[]) {
        System.out.println(nextLetter("abcz1a$bABlove"));
    }

    private static String nextLetter(String data) {
        String result = "";
        for (int i = 0; i < data.length(); i++) {
            char character = data.charAt(i);
            if (Character.isLowerCase(character)) {
                character++;
                // Account for rollover on 'z'
                if (character == '{') {
                    character = 'a';
                }
            } 

            result += character;
        }

        return result;
    }
}