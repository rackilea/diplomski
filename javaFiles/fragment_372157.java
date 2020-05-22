public class JavaApplication255 {


public static void main(String[] args) {

    String inputString = "1+3,432.123*4535-24.4";   

    char[] destArray = inputString.toCharArray();

    for (int i = 0 ; i < destArray.length ; i++){
        char c = destArray[i];

        if (isBreakCharacter(c)){
            System.out.println("\n" + c);
        } else {
            System.out.print(c);
        }

    }
}

public static boolean isBreakCharacter(char c){
    return c == '+' || c == '*' || c == '-' || c == '.' || c == ',' ;
}