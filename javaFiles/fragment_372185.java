import java.util.Random;

public class Hashing {

    public static void main(String[] args) {
        int[] array = new int[3];
        Random generator = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = generator.nextInt(80);

                System.out.println("array= " + array[i]);

       }
            System.out.print("\n");
            int[] newarray = new int[3];

            for (int j = 0; j < newarray.length; j++) {


           newarray[j] = array[j] % 19;

           System.out.println("residuals=" + newarray[j]);

        }
    }
}