package com.example.math;

public class QuickHash {
    interface Hasher
    {
        public int hash(int n); 
    }
    static class MultiplicativeHasher1 implements Hasher
    {
        /* multiplicative random number generator
         * from L'Ecuyer is x[n+1] = 1223106847 x[n] mod (2^32-5)
         * http://dimsboiv.uqac.ca/Cours/C2012/8INF802_Hiv12/ref/paper/RNG/TableLecuyer.pdf
         */
        final static long a = 1223106847L;
        final static long m = (1L << 32)-5;
        /*
         * iterative step towards computing mod m
         *   (j*(2^32)+k) mod (2^32-5)
         * = (j*(2^32-5)+j*5+k) mod (2^32-5)
         * = (j*5+k) mod (2^32-5)
         * repeat twice to get a number between 0 and 2^31+24 
         */
        private long quickmod(long x)
        {
            long j = x >>> 32;
            long k = x & 0xffffffffL;
            return j*5+k;
        }
        // treat n as unsigned before computation
        @Override public int hash(int n) {
            long h = a*(n&0xffffffffL);
            long h2 = quickmod(quickmod(h));            
            return (int) (h2 >= m ? (h2-m) : h2);
        }       
        @Override public String toString() { return getClass().getSimpleName(); } 
    }

    /** 
     * computes (2^n) mod P where P is the polynomial in GF2
     * with coefficients 2^(k+1) represented by the bits k=31:0 in "poly";
     * coefficient 2^0 is always 1
     */
    static class GF32Hasher implements Hasher
    {
        static final public GF32Hasher CRC32 = new GF32Hasher(0x82608EDB, 32);

        final private int poly;
        final private int ofs;
        public GF32Hasher(int poly, int ofs) {
            this.ofs = ofs;
            this.poly = poly;
        }

        static private long uint(int x) { return x&0xffffffffL; }
        // modulo GF2 via repeated subtraction
        int mod(long n) {
            long rem = n;
            long q = uint(this.poly);
            q = (q << 32) | (1L << 31);
            long bitmask = 1L << 63;
            for (int i = 0; i < 32; ++i, bitmask >>>= 1, q >>>= 1)
            {
                if ((rem & bitmask) != 0)
                    rem ^= q;
            }
            return (int) rem;
        }
        int mul(int x, int y)
        {
            return mod(uint(x)*uint(y));
        }
        int pow2(int n) {
            // compute 2^n mod P using repeated squaring
            int y = 1;
            int x = 2;
            while (n > 0)
            {
                if ((n&1) != 0)
                    y = mul(y,x);
                x = mul(x,x);
                n = n >>> 1;
            }
            return y;
        }
        @Override public int hash(int n) {
            return pow2(n+this.ofs);
        }
        @Override public String toString() { 
            return String.format("GF32[%08x, ofs=%d]", this.poly, this.ofs); 
        }
    }
    static class QuickHasher implements Hasher
    {
        @Override public int hash(int n) {
            return (int) ((131111L*n)^n^(1973*n)%7919);
        }
        @Override public String toString() { return getClass().getSimpleName(); }       
    }

    // adapted from http://www.w3.org/TR/PNG-CRCAppendix.html
    static class CRC32TableHasher implements Hasher
    {
        final private int table[];
        static final private int polyval = 0xedb88320;

        public CRC32TableHasher() 
        {           
            this.table = make_table();
        }

        /* Make the table for a fast CRC. */
        static public int[] make_table()
        {
            int[] table = new int[256]; 
            int c;
            int n, k;

            for (n = 0; n < 256; n++) {
                c = n;
                for (k = 0; k < 8; k++) {
                    if ((c & 1) != 0)
                        c = polyval ^ (c >>> 1);
                    else
                        c = c >>> 1;
                }
                table[n] = (int) c;
            }
            return table;
        }

        public int iterate(int state, int i)
        {
            return this.table[(state ^ i) & 0xff] ^ (state >>> 8);
        }
        @Override public int hash(int n) {
            int h = -1;
            h = iterate(h, n >>> 24); 
            h = iterate(h, n >>> 16); 
            h = iterate(h, n >>> 8); 
            h = iterate(h, n); 
            return h ^ -1;
        }
        @Override public String toString() { return getClass().getSimpleName(); } 
    }

    static class TrigHasher implements Hasher
    {       
        @Override public String toString() { return getClass().getSimpleName(); }
        @Override public int hash(int n) { 
            double s = Math.sin(n);
            return (int) Math.floor((1<<31)*s);
        }       
    }

    private static void test(Hasher hasher) {
        System.out.println(hasher+":");
        for (int i = 0; i < 64; ++i)
        {
            int h = hasher.hash(i);
            System.out.println(String.format("%08x -> %08x   %%2 = %d", 
                    i,h,(h&1)));
        }
        for (int i = 0; i < 256; ++i)
        {
            System.out.print(hasher.hash(i) & 1);
        }
        System.out.println();       
        analyzeBits(hasher);
    }

    private static void analyzeBits(Hasher hasher) {
        final int N = 65536;
        final int maxrunlength=32;
        int[][] runs = {new int[maxrunlength], new int[maxrunlength]};
        int[] count = new int[2];
        int prev = -1;
        System.out.println("Run length test of "+N+" bits");
        for (int i = 0; i < maxrunlength; ++i)
        {
            runs[0][i] = 0;
            runs[1][i] = 0;
        }
        int runlength_minus1 = 0;
        for (int i = 0; i < N; ++i)
        {
            int b = hasher.hash(i) & 0x1;
            count[b]++;
            if (b == prev)
                ++runlength_minus1;
            else if (i > 0)
            {
                ++runs[prev][runlength_minus1];
                runlength_minus1 = 0;
            }
            prev = b;
        }
        ++runs[prev][runlength_minus1];

        System.out.println(String.format("%d zeros, %d ones", count[0], count[1]));
        for (int i = 0; i < maxrunlength; ++i)
        {
            System.out.println(String.format("%d runs of %d zeros, %d runs of %d ones", runs[0][i], i+1, runs[1][i], i+1));         
        }
    }

    public static void main(String[] args) {
        Hasher[] hashers = {
            new MultiplicativeHasher1(), 
            GF32Hasher.CRC32, 
            new QuickHasher(),
            new CRC32TableHasher(),
            new TrigHasher()
        };
        for (Hasher hasher : hashers)
        {
            test(hasher);
        }
    }
}