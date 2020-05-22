public class TEST{
 public static void main(String[] args){
     System.out.println(getWordByNumber(1091));
 }

 private static String[] letters = {"J", "A", "B", "C", "D", "E", "F", "G", "H", "I"};
 private String  getWordByNumber(int number){
     StringBuilder sb = new StringBuilder();
     while (number > 0) {
         sb.append( letters[number % 10]);
         number = number / 10;
     }
     return sb.toString();
 }