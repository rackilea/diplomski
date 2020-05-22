public class Example
{
   public static void main(String[] agrs) {
       String input = "big workshop";
       char[] charToRemove = {'b', 'm', 'w'};
       String charsToRemove = new String(charToRemove);
       StringBuilder sb = new StringBuilder();
       Example ex = new Example();
       ex.removeChar(input, 0, charsToRemove, sb);
       System.out.println(sb);

   }

   public void removeChar(String input, int index, String charToRemove, StringBuilder target) {

       if(input.length() == index) {
           return;
       }

       char c = input.charAt(index);
       if(charToRemove.indexOf(c) == -1) {
           target.append(c);
       }

       removeChar(input, index + 1, charToRemove, target);

   }

}