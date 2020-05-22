public class OverlappingIntervals
{
    private static final long INTERVAL_SIZE = 24;

    public static void main(String[] args)
    {
        test(6,23, 2,17);
        test(0,12, 12,2);

        test(11,4, 12,3);
        test(12,4, 11,3);
    }

    private static void test(
        long s0, long e0, long s1, long e1)
    {
        System.out.println(createString(s0, e0, s1, e1));
        System.out.println(findOverlappingInterval(s0, e0, s1, e1));
    }

    private static String createString(
        long s0, long e0, long s1, long e1)
    {
        StringBuilder sb = new StringBuilder();
        sb.append(createString(s0, e0, "A")).append("\n");
        sb.append(createString(s1, e1, "B"));
        return sb.toString();
    }

    private static String createString(long s, long e, String c)
    {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<INTERVAL_SIZE; i++)
        {
            if (s < e)
            {
                if (i >= s && i <= e)
                {
                    sb.append(c);
                }
                else
                {
                    sb.append(".");
                }
            }
            else 
            {
                if (i <= e || i >= s)
                {
                    sb.append(c);
                }
                else 
                {
                    sb.append(".");
                }
            }
        }
        return sb.toString();
    }



    public static long findOverlappingInterval(
        long s0, long e0, long s1, long e1)
    {
        return compute(s0, e0+1, s1, e1+1);
    }

    public static long compute(
        long s0, long e0, long s1, long e1)
    {
        if (s0 > e0)
        {
            return 
                compute(s0, INTERVAL_SIZE, s1, e1) +
                compute(0, e0, s1, e1);
        }
        if (s1 > e1)
        {
            return 
                compute(s0, e0, s1, INTERVAL_SIZE) +
                compute(s0, e0, 0, e1);
        }
        return Math.max(0, Math.min(e0, e1) - Math.max(s0, s1));
    }
}