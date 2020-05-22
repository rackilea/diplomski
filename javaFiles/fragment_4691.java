public class Main {
    public static void main(String args[]) {
        // Create a String to test with
        String testString = "some test text";

        // Prints out the number of characters in the String
        System.out.println(testString.length());

        // Prints out the character at the index of '2'
        System.out.println(testString.charAt(2));

        // Prints out a new String starting at index '5' and ending at index '9' 
        System.out.println(testString.substring(5, 9));

        // Prints out the index number that the word 'text' starts at
        System.out.println(testString.indexOf("text"));
    }

}