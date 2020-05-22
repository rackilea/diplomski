import java.util.*;
public class Roulette 
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        Random r = new Random();
        int number = r.nextInt(37);
        BetOnce.gameRunner(in, number);
    }
}

class BetOnce
{
    public void gameRunner(Scanner in, int number)
    {
        //Code
    }
}