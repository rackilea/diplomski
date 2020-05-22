import java.util.*;
import java.io.*;
public class Lottery {
    private int lotteryNumber[] = new int[5];
    public Lottery() {
        Random myRan = new Random();
        for (int i = 0; i < lotteryNumber.length; i++)
        {
            lotteryNumber[i] = myRan.nextInt(9)+1;
            for (int j = 0; j < i; j++)
            {
                if( (lotteryNumber[i] == (lotteryNumber[j])) && (i != j) )
                {
                    i=0;
                }
            }
        }
        System.out.println("final values are");
        for(int i = 0; i < lotteryNumber.length; i++){
            System.out.println(lotteryNumber[i]);
        }
    }
}