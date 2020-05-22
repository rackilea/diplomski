public class UpperAndLower {
    private static String convertString(String input) {
        String output = "";

        for (int i = 0; i < input.length(); i++) {
            if (i % 2 == 0)     // checks if the character is even
                output = output + input.substring(i, i+1).toUpperCase();
            else
                output = output + input.substring(i, i+1).toLowerCase();
        }

        return output;
    }

    public static void main(String[] args) {
        System.out.println(convertString("Hello World"));
    }
}