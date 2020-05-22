import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

class TestClass {

    public static void main(String args[]) throws Exception {
        FastReader sc = new FastReader();
        Set<Integer> perfectNumbers = new HashSet<>();
        for (int i = 0; i <= 20; i++) {
            perfectNumbers.add(i * i * i);
        }
        for (int i = 1; i <= 44; i++) {
            perfectNumbers.add(i * i);
        }

        int t = sc.nextInt();
        for (int k = 0; k < t; k++) {
            int db = 0;
            int n = sc.nextInt();
            int[] a = new int[1001];
            int[] b = new int[1001];
            int[] numbers = new int[n];
            for (int j = 0; j < n; j++) {
                int x = sc.nextInt();
                numbers[j] = x;
                for (Integer perfect : perfectNumbers) {
                    if (x == perfect - x) {
                        b[x]++;
                    } else if (perfect - x >= 0 && perfect - x <= 1000)
                        a[perfect - x]++;
                }
            }
            for (int j = 0; j < n; j++) {
                db += a[numbers[j]];
            }
            for (int j = 0; j <= 1000; j++) {
                if (b[j] > 1) {
                    db += b[j] * (b[j] - 1);
                }
            }
            System.out.println(db / 2);
        }
    }


    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            Integer nr=null;
            try {
                nr = Integer.parseInt(next());
            } catch (Exception e) {
                //something went wrong
            }
            return nr;
        }


    }

}