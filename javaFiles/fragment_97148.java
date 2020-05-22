public class StringSorter {

    private static final String vowels = "aeiou";

    public static void main(String[] args) {
        char[] string = "thisIsAString".toCharArray();
        char[] test2 = "thisIsAStringaAabBs".toCharArray();

        System.out.println("unsorted: " + new String(string));
        insertionSort(string);
        System.out.println("sorted:   " + new String(string));

        System.out.println();

        System.out.println("unsorted: " + new String(test2));
        insertionSort(test2);
        System.out.println("sorted:   " + new String(test2));
    }

    public static void insertionSort(char[] string) {
        for (int i = 1; i < string.length; i++) {
            char h = string[i];
            int j = i;

            while ((j > 0) && isBefore(string[j - 1], h)) {

                string[j] = string[j - 1];
                j = j - 1;

            }

            string[j] = h;
        }
    }

    private static boolean isBefore(char a, char b) {
        String lowA = Character.toString(Character.toLowerCase(a));
        String lowB = Character.toString(Character.toLowerCase(b));

        if (vowels.contains(lowA)) {
            if (vowels.contains(lowB)) {
                //both are vowels
                return chooseLowerCaseFirst(a, b);
            }
            else {
                //only a is a vowel
                return false;
            }
        }
        else if (vowels.contains(lowB)) {
            //only b is a vowel
            return true;
        }
        else {
            //none is a vowel
            return chooseLowerCaseFirst(a, b);
        }
    }

    private static boolean chooseLowerCaseFirst(char a, char b) {
        String lowA = Character.toString(Character.toLowerCase(a));
        String lowB = Character.toString(Character.toLowerCase(b));

        if (lowA.equals(lowB)) {
            //both are the same character

            if (Character.isLowerCase(a)) {
                if (Character.isLowerCase(b)) {
                    //both are lower case
                    return Character.toLowerCase(a) > Character.toLowerCase(b);
                }
                else {
                    //only a is lower case
                    return false;
                }
            }
            else if (Character.isLowerCase(b)) {
                //only b is lower case
                return true;
            }
            else {
                //both are upper case
                return Character.toLowerCase(a) > Character.toLowerCase(b);
            }
        }
        else {
            //different characters
            return Character.toLowerCase(a) > Character.toLowerCase(b);
        }
    }
}