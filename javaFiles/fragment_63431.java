/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
    public static void main (String[] args) throws java.lang.Exception
    {
        HashMap<BigInteger, Prime> primelist = new HashMap<BigInteger, Prime>();
        BigInteger bigint = new BigInteger("12000000000");
        BigInteger one = BigInteger.valueOf(1);
        for(int c=0;c<100;c++) {
            primelist.put(bigint, new Prime());
            bigint = bigint.add(one);
        }
        System.out.println(primelist);
    }
}
class Prime {
    // your stuff here
    public Prime() {
        // your prime initialisation
    }
}