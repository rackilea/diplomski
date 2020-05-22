import java.math.BigInteger;
import java.util.*;

public class prng2 
{

    static List<BigInteger> seq = new ArrayList<>();

    static final BigInteger one=BigInteger.valueOf(1);
    static final BigInteger two=BigInteger.valueOf(2);
    static final BigInteger BigFor=BigInteger.valueOf(4);

    public List<BigInteger> clcg(int mul_1,int seed_1,int inc_1,int mod_1,int mul_2,int seed_2,int inc_2,int mod_2,int mul_3,int seed_3,int inc_3,int mod_3,int mul_4,int seed_4,int inc_4,int mod_4,int newno,int more)
    {
        BigInteger BigSeed1=BigInteger.valueOf(seed_1);
        BigInteger BigSeed2=BigInteger.valueOf(seed_2);
        BigInteger BigSeed3=BigInteger.valueOf(seed_3);
        BigInteger BigSeed4=BigInteger.valueOf(seed_4);

        BigInteger a1=BigFor.multiply(BigInteger.valueOf(mul_1)).add(one);
        BigInteger c1=two.multiply(BigInteger.valueOf(inc_1)).subtract(one);
        BigInteger m1=two.pow(mod_1 +more);

        BigInteger a2=BigFor.multiply(BigInteger.valueOf(mul_2)).add(one);
        BigInteger c2=two.multiply(BigInteger.valueOf(inc_2)).subtract(one);
        BigInteger m2=two.pow(mod_2 +more);

        BigInteger a3=BigFor.multiply(BigInteger.valueOf(mul_3)).add(one);
        BigInteger c3=two.multiply(BigInteger.valueOf(inc_3)).subtract(one);
        BigInteger m3=two.pow(mod_3 +more);

        BigInteger a4=BigFor.multiply(BigInteger.valueOf(mul_4)).add(one);
        BigInteger c4=two.multiply(BigInteger.valueOf(inc_4)).subtract(one);
        BigInteger m4=two.pow(mod_4 +more);

        BigInteger X=BigInteger.valueOf(0);

        // TRACE HERE
        System.out.println("M1="+m1+" M2="+m2+" M3="+m3+" M4="+m4);

        BigInteger period=m1.subtract(one).multiply( m2.subtract(one)).multiply( m3.subtract(one)).multiply( m4.subtract(one)).divide(BigInteger.valueOf(8));        
        BigInteger pc=BigInteger.valueOf(0);
        int newlim=0;

        // TRACE HERE
        System.out.println("PC="+pc+" PERIOD="+period);

        // pc < period
        while (pc.compareTo(period)<0)
        {
            // TRACE HERE
            System.out.println("LOOP");
            System.out.println("PC="+pc+" PERIOD="+period);

            int i=1;
            int p=0;

            BigSeed1=a1.multiply(BigSeed1).add(c1).mod(m1);
            BigSeed2=a2.multiply(BigSeed2).add(c2).mod(m2);
            BigSeed3=a3.multiply(BigSeed3).add(c3).mod(m3);
            BigSeed4=a4.multiply(BigSeed4).add(c4).mod(m4);

            BigInteger m1minus1=m1.subtract(one);

            X=BigSeed1.add(BigSeed2).add(BigSeed3).add(BigSeed4).mod(m1minus1);

            BigInteger R=X.mod(BigInteger.valueOf(256));

            // System.out.println("for the "+i+" time R: "+R+" seq:"+seq.get(p) );
            seq.add(R);

            newlim= newlim + 1;
            if (newlim == newno)
               {
                break;
               }               
            else
                {
                pc=pc.add(one);
                }
       // i++;
       // p++;
        }
        return seq;
        }

    public static void main (String[] args)
    {
        prng2 objprng2 = new prng2();
        objprng2.clcg(2,10,50,44,54,67,6,6,4,6,2,5,5,4,5,5,50,5);
        //System.out.println(objprng2.clcg(2,10,50,44,54,67,6,6,4,6,2,5,5,4,5,5,4,5));

        System.out.println("RESULTS:"+seq.size());

            for(BigInteger element : seq) 
            {   
            System.out.println((element));
            } 
    }
    }