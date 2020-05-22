import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Fun implements Runnable {

    int[] numbers;

    public Fun(int[] numbers)
    {
        this.numbers = numbers;
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Please enter the amount of threads: ");
        final int qtyThreads = in.nextInt();

        int[] numbers = new int[qtyThreads];

        for(int i = 0; i<numbers.length; i++)
        {
            numbers[i] = 0;
        }

        ExecutorService exs = Executors.newFixedThreadPool(qtyThreads);

        for(int i = 0; i<qtyThreads; i++)
        {
            exs.submit(new Fun(numbers));
        }

        // already awaits termination
        exs.shutdown();

        int sum = 0;

        for(int number : numbers)
        {
            sum += number;
        }

        System.out.println("ArraySum: "+sum);



    }


    @Override
    public void run() {

        int max = -1;
        for(int i = 0; i<numbers.length; i++)
        {
            if(numbers[i] > max)
            {
                max = numbers[i];
            }
        }

        for(int i = 0; i<numbers.length; i++)
        {
            if(numbers[i] == 0)
            {
                numbers[i] = ++max;
                break;
            }
        }

    }

}