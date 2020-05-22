import java.util.Random;

public class Prog433a {

    public static void main(String[] args) {

        Random randslct = new Random();

        int[] list = new int[20];
        int counter = 0;
        int index = 0;
        int min2 = 0;

        System.out.println("\nAfter");

        for(int k = 0; k < list.length - 1; k++) {

            list[k] = randslct.nextInt(30) + 1;
            boolean unique = true;
            for(int z = k - 1; z >= 0; z--) {
                if(list[k] == list[z]) {
                    if(list[k] == list[z]) {
                        unique = false;
                        break;
                    }
                }
            }
            if(!unique) {
                // Repeat last index
                --k;
            }
        }

        int min = list[0];
        while(counter < list.length - 1) {
            for(int x = 0; x < list.length - 1; x++) { // scroll through the indexes.
                if(list[x] < min) {
                    min = list[x];
                    index = x; // keep the index of the biggest number.
                }
            }
            System.out.println(list[index]);
            min = 100 * (list[index]);

            list[index] = 100 * (list[index]); // change the value in the original array so it won't find the same max again
            counter++;
        }

    }

}