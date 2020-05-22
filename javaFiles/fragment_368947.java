public class Capitalize {
    public static String capitalize(String string) {
        StringBuilder builder = new StringBuilder(string.length());

        boolean capitalizeNext = true;
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);

            if (capitalizeNext && Character.isLetter(c)) {
                c = Character.toUpperCase(c);
                capitalizeNext = false;
            } else if (Character.isWhitespace(c)) {
                capitalizeNext = true;
            }

            builder.append(c);
        }
        return builder.toString();
    }

    //input words and print the result
    public static void main(String[] args){
        String str = "the simpson series";
        String total = capitalize(str);
        System.out.println(total);
    }   
}