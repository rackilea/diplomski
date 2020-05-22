import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Johnann {
    private static Map<Long, Long> jMem;
    private static Map<Long, Long> aMem;


    public static long fAnn(long n) {
      if (n < 2) {
        aMem = new HashMap<Long, Long>();
        aMem.put(n, (long)1);
        return 1;
      }
      else if (aMem.keySet().contains(n)) {
        return aMem.get(n);
      }
      else {
        long res = n - fJohn(fAnn(n-1));
        aMem.put(n, res);
        return res;
      }
    }


    public static long fJohn(long n) {
      if (n < 2) {
        jMem = new HashMap<Long, Long>();
        jMem.put(n, (long)0);
        return 0;
      }
      else if (jMem.keySet().contains(n)) {
        return jMem.get(n);
      }
      else {
        long res = n - fAnn(fJohn(n-1));
        jMem.put(n, res);
        return res;
      }
    }

    public static List<Long> john(long n) {
        List<Long> res = new ArrayList<Long>();

        for (long i = 0; i < n; i++) {
          res.add(fJohn(i));
        }

        return res;
    }

    public static List<Long> ann(long n) {
        System.out.println(n);
        List<Long> res = new ArrayList<Long>();

        for (long i = 0; i < n; i++) {
          res.add(fAnn(i));
        }

        return res;
    }


    public static long sumJohn(long n) {
        if (n == 0) return 0;
        else if (n < 2) return 1;
        long sum = 0;
        for (long i = 0; i < n; i++) sum += fJohn(i);
        return sum;
    }
    public static long sumAnn(long n) {
        if (n == 0) return 0;
        else if (n < 2) return 1;
        long sum = 0;
        for (long i = 0; i < n; i++) sum += fAnn(i);
        return sum;
    }
}