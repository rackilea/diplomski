public class Program {
    public static String revSentence (String str) {
        String retString = "";
        String [] givenString = str.split(" ");

        for (int i=givenString.length-1; i>=0; i--) {
            retString += givenString[i] + " "; 
        }
        return retString;
    }


    public static void main(String[] args) {
        String m = "how are you";
        System.out.print(revSentence(m));
    }

}