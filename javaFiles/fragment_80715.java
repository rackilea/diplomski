// Marsaglia2003.java

import java.util.*;

class Marsaglia2003
{
    final static private int sz=4096;
    final static private int mask=4095;
    final private int[] Q = new int[sz];
    private int c=362436;
    private int i=sz-1;

    public Marsaglia2003()
    {
        // a real program would seed this with a good random seed
        // i'm just putting in something that makes the output interesting
        for (int j = 0; j < sz; ++j)
            Q[j] = j + (j << 16);
    }

  public int next() 
    // note: returns a SIGNED 32-bit number.
    // if you want to use as unsigned, cast to a (long), 
    // then AND it with 0xffffffffL
    {
        long t, a=18782;
        int x;
        int r=0xfffffffe;
        i = (i+1)&mask;
        long Qi = ((long)Q[i]) & 0xffffffffL; // treat as unsigned 32-bit
        t=a*Qi+c;
        c=(int)(t>>32); 
           // because "a" is relatively small this result is also small

        x=((int)t) + c;
        if (x<c && x>=0) // tweak to treat x as unsigned
        {
            x++;
            c++;
        }
        return (Q[i]=r-x);
    }

    public static void main(String args[])
    {
        Marsaglia2003 m2003 = new Marsaglia2003();

        int n = 100;
        if (args.length > 0)
            n = Integer.parseInt(args[0]);
        for (int i = 0; i < n; ++i)
        {
            System.out.printf("%08x\n", m2003.next());
        }
    }
};