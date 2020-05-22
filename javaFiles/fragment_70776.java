public class Alphabet {

          public static String LetterChanges(String str) {
            String alphabet = "AbcdEfghIjklmnOpqrstUvwxyz";


            char[] string = str.toLowerCase().toCharArray();
            for (int i=0; i < string.length; i++) {
                char d = alphabet.charAt(((alphabet.toLowerCase().indexOf(string[i]))+1) % 26);

                string[i]=d;
            }

            return new String(string);
          }    
    public static void main(String[] args) {
        System.out.println(Alphabet.LetterChanges("aabb"));


    }       
}