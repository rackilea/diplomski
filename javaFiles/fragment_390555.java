import java.util.Random;

public class Yay {

    public static void main(String[] args) {
        String[] arr={"1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "_"};

        for (int f=0; f<10; f++) {
            for (int i=0; i<3; i++) {
                Random r=new Random();
                int randomNumber=r.nextInt(arr.length);
                System.out.print(arr[randomNumber]);
            }
            System.out.println(); // Outside of the for loop
        }
    }
}