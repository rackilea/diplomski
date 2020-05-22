package isPrime.isPrime;
import java.util.*;

public class Primusnumberus {
    public static void main(String[] args) {
        int num = 0;
        int numberCount = 24;
        int counter = 0;
        Random rand = new Random();
        List<Integer> primeList = new ArrayList<>();

        while (counter < numberCount) {
            num = rand.nextInt(1000) + 1;
            while (!isPrime(num)) {
                num = rand.nextInt(1000) + 1;
            }
            if (!primeList.contains(num)) {
                primeList.add(num);
                counter ++;
            }
        }
        Collections.sort(primeList);
        System.out.println(primeList);
    }

    private static boolean isPrime(int inputNum){
        if (inputNum <= 3 || inputNum % 2 == 0)
            return inputNum == 2 || inputNum == 3;
        int divisor = 3;
        while ((divisor <= Math.sqrt(inputNum)) && (inputNum % divisor != 0))
            divisor += 2;
        return inputNum % divisor != 0;
    }
}