import java.util.Scanner;
public class Excercise5{
    public static void main(String[] arg) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Type a string: ");
        String word = keyboard.nextLine(); 
        if(checkString(word)) {
            System.out.printf("%s begins and ends with the same letter.\r\n" , word);
        } else {
            System.out.printf("%s does not begin and end with the same letter.\r\n", word);
        }
    }

    public static boolean checkString (String word) {
      int length = word.length();
      word = word.toUpperCase(); //since you are testing them as upper case
      char firstLetter = word.charAt(0);
      char lastLetter = word.charAt(length - 1);
      return firstLetter == lastLetter;
   }
}