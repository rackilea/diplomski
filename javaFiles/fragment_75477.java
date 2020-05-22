package stackoverflow;
import java.util.Random;
import java.util.Arrays;
/**
 *
 * @author User
 */
public class StackOverFlow {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Random g = new Random();

        int [] number = new int [1000];

        System.out.print("Random Numbers:");
        for (int d = 0 ; d<number.length ; d++){
            int RandomG = g.nextInt(1000)+1;
            number[d] = RandomG;
            System.out.print(" " +RandomG);
            }

        System.out.print("\nSorted Numbers:"+Arrays.toString(BubbleSortAsceMethod(number)));

    }
    public static int [] BubbleSortAsceMethod(int[] number){
        int temp;

        for(int i = 0 ; i < number.length-1 ; i++){
            for ( int j = 1 ; j < number.length-i-1 ; j++){
                if ( number[j-1] > number[j]){
                    temp = number[j-1];
                    number[j-1] = number[j];
                    number[j] = temp;
                }
            }
        }
        return number;  
    }

}