import java.util.ArrayList;
import java.util.Arrays;

public class Test{
    public static void main(String[] args) {
        ArrayList<Integer> numberList = Arrays.asList(10234, 20233, 34546, 43546, 59865, 70002, 92435, 200354);

        for(int nbr : numberList){              //goes through the list
            if( nbr > 20000 && nbr < 50000){
                System.out.println(nbr);
            }
        }
    }
}