import java.util.Scanner;

public class binary {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter Binary Number Please:");
        String aString = keyboard.next();
        int sizeOf = aString.length();
        int[] binArray = new int[sizeOf];
        char digitBin = ' ';
        int digitChar = 0;
        for(int i = 0; i < sizeOf; i++){
            digitBin = aString.charAt(0);
            digitChar = Character.getNumericValue(digitBin);
            binArray[i] = digitChar;
        }
        int total = 0;
        int multiplyNum = 1;
        for(int i = sizeOf - 1; i > -1; i--){
            total = (binArray[i] * multiplyNum) + total;
            multiplyNum = multiplyNum * 2;
        }
        System.out.println(total);

    }

}