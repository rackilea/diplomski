package x;
import java.util.Random;

public class x {

    class qsort0 implements Runnable
    {
        int[] a;
        int lo;
        int hi;

        private qsort0(int[] a, int lo, int hi)
        {
            this.a = a;
            this.lo = lo;
            this.hi = hi;
        }
        @Override
        public void run()
        {
            if(this.lo >= this.hi)
                return;
            int pi = partition(this.a, this.lo, this.hi);
            Thread lt = new Thread(new qsort1(a, this.lo, pi));
            Thread rt = new Thread(new qsort1(a, pi+1, this.hi));
            lt.start();
            rt.start();
            try {lt.join();} catch (InterruptedException ex){}
            try {rt.join();} catch (InterruptedException ex){}
        }
    }

    class qsort1 implements Runnable
    {
        int[] a;
        int lo;
        int hi;

        private qsort1(int[] a, int lo, int hi)
        {
            this.a = a;
            this.lo = lo;
            this.hi = hi;
        }
        @Override
        public void run()
        {
            if(this.lo >= this.hi)
                return;
            int pi = partition(this.a, this.lo, this.hi);
            Thread lt = new Thread(new qsort2(a, this.lo, pi));
            Thread rt = new Thread(new qsort2(a, pi+1, this.hi));
            lt.start();
            rt.start();
            try {lt.join();} catch (InterruptedException ex){}
            try {rt.join();} catch (InterruptedException ex){}
        }
    }

    class qsort2 implements Runnable
    {
        int[] a;
        int lo;
        int hi;
        private qsort2(int[] a, int lo, int hi)
        {
            this.a = a;
            this.lo = lo;
            this.hi = hi;
        }
        @Override
        public void run() {
            if(this.lo >= this.hi)
                return;
            qsort(this.a, this.lo, this.hi);
        }
    }

    // quicksort multi-threaded
    @SuppressWarnings("empty-statement")
    public static void qsortmt(int[] a, int lo, int hi)
    {
        if(lo >= hi)
            return;
        int pi = partition(a, lo, hi);
        Thread lt = new Thread(new x().new qsort0(a, lo, pi));
        Thread rt = new Thread(new x().new qsort0(a, pi+1, hi));
        lt.start();
        rt.start();
        try {lt.join();} catch (InterruptedException ex){}
        try {rt.join();} catch (InterruptedException ex){}
    }

    @SuppressWarnings("empty-statement")
    public static int partition(int []a, int lo, int hi)
    {
        int  md = lo+(hi-lo)/2;
        int  ll = lo-1;
        int  hh = hi+1;
        int t;
        int p = a[md];
        while(true){
            while(a[++ll] < p);
            while(a[--hh] > p);
            if(ll >= hh)
                break;
            t     = a[ll];
            a[ll] = a[hh];
            a[hh] = t;
        }
        return hh;
    }

    @SuppressWarnings("empty-statement")
    public static void qsort(int[] a, int lo, int hi)
    {
        while(lo < hi){
            int ll = partition(a, lo, hi);
            int hh = ll+1;
            // recurse on smaller part, loop on larger part
            if((ll - lo) <= (hi - hh)){
                qsort(a, lo, ll);
                lo = hh;
            } else {
                qsort(a, hh, hi);
                hi = ll;
            }
        }
    }

    public static void main(String[] args)
    {
        int[] a = new int[16*1024*1024];
        Random r = new Random(0);
        for(int i = 0; i < a.length; i++)
            a[i] = r.nextInt();
        long bgn, end;
        bgn = System.currentTimeMillis();
        qsortmt(a, 0, a.length-1);
        end = System.currentTimeMillis();
        for(int i = 1; i < a.length; i++){
            if(a[i-1] > a[i]){
                System.out.println("failed");
                break;
            }
        }
        System.out.println("milliseconds " + (end-bgn));
    }
}