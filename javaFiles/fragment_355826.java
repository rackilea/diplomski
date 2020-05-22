public class Main {

        public static void main(String[] args) {
            int[][] seq={{ 42, 22, 40, 1, 11, 5, 43 },
                         { 13, 11, 18, 45, 3, 44, 19 },
                         { 46, 1, 32, 47, 35, 7, 36 },
                         { 48, 21, 38, 29, 3, 12, 11 },
            };

            for (int i=0; i < seq.length; i++) {
                int[] x=seq[i];

                Arrays.sort(x);
                for (int number : x) {
                        System.out.print(number  + " ");}
                        System.out.print("\n");
                    }
                }
            }