import java.math.BigInteger;

public class If {

    //The first prime number
    public static final BigInteger INIT_NUMBER = new BigInteger("2");

    public static void main(String[] args) {

        //Initialise n and p
        BigInteger n = new BigInteger("77");
        BigInteger p = INIT_NUMBER;

        //For each prime p
        while(p.compareTo(n.divide(INIT_NUMBER)) <= 0){

            //If we find p
            if(n.mod(p).equals(BigInteger.ZERO)){
                //Calculate q
                BigInteger q = n.divide(p);
                //Displays the result
                System.out.println("(" + p + ", " + q + ")");
                //The end of the algorithm
                return;
            }
            //p = the next prime number
            p = p.nextProbablePrime();
        }
        System.out.println("No solution exists");
    }
}