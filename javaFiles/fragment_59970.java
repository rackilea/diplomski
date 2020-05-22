import java.util.*;
    import java.lang.*;

    /**
     *
     * @author aoubidar
     */
    public class Main {

        public static void main(String[] args) {

            Scanner in = new Scanner(System.in);

            // number of test cases
            int T = Integer.parseInt(in.nextLine());


            int[] N = new int[T];
            int[] A = new int[T];
            int[] B = new int[T];

            double[] Probability = new double[T];

            for (int t = 0; t < T; t++) {

                String[] input = in.nextLine().split(" ");

                N[t] = Integer.parseInt(input[0]);
                A[t] = Integer.parseInt(input[1]);
                B[t] = Integer.parseInt(input[2]);

                int total, pa = 0, pb = 0 ;

                String[] faces = in.nextLine().split(" ");
                total = faces.length;

                for (String f : faces) {

                    if (Integer.parseInt(f) == A[t]) {
                        pa++;
                    }
                    if (Integer.parseInt(f) == B[t]) {
                        pb++;
                    }
                }

                double pn = (double) (total * total);

                Probability[t] = (pa * pb) / pn ;
            }

            for (double d : Probability) {
                System.out.println(d);
            }


        }

    }