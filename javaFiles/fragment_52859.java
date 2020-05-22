public class ReverseByWord {

    public static String reversePart (String in){
        // Reverses the complete string
        String reversed = "";
        for (int i=0; i<in.length(); i++){
            reversed=in.charAt(i)+reversed;
        }
        return reversed;
    }

    public static String reverseByWord (String in){
        // First reverses the complete string
        // "I am going there" becomes "ereht gniog ma I"
        // After that we just need to reverse each word.
        String reversed = reversePart(in);
        String word_reversal="";
        int last_space=-1;
        int j=0;
        while (j<in.length()){
            if (reversed.charAt(j)==' '){
                word_reversal=word_reversal+reversePart(reversed.substring(last_space+1, j));
                word_reversal=word_reversal+" ";
                last_space=j;
            }
            j++;
        }
        word_reversal=word_reversal+reversePart(reversed.substring(last_space+1, in.length()));
        return word_reversal;
    }

    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println(reverseByWord("I am going there"));
    }
}