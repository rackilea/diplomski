import java.io.*; 
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws IOException 
    {

        int counter = 1;

        FileWriter out = null;
        try{
        out = new FileWriter("out.txt");
        for(BigInteger number : FibanocciNumbers())
        {
            out.write("Spot:");
            out.write(counter + " ");
            out.write(String.valueOf(number) + "\r\n");
            System.out.println(number);
            counter++;
        }
        }catch(IOException e)
        {
        System.out.println("Error!");
        }
        finally
        {
        out.close();
        }
    }

    public static BigInteger[] FibanocciNumbers()
    {
        BigInteger[] fibNumbers = new BigInteger[64];
        fibNumbers[0] = new BigInteger("1");
        fibNumbers[1] = new BigInteger("2");
        BigInteger lastNumber;
        for(int i = 2; i < 64; i++)
        {
            lastNumber = fibNumbers[i-1];
            fibNumbers[i] = lastNumber.multiply( new BigInteger("2") );
        }
        return fibNumbers;
    }
}