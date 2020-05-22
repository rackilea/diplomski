import java.util.ArrayList;

    public class Main {

        static ArrayList<Integer> numbersList = new ArrayList<Integer>();
        static ArrayList<String> prefixList = new ArrayList<String>();

        public static void main(String[] args) {
            String number = "83241232";

            permutation(number);

            System.out.printf("Found %d unique permutations!%n", numbersList.size());
            for(int i=0; i<numbersList.size(); i++)
            {
                System.out.printf("%d%n", numbersList.get(i));
            }
        }

        public static void permutation(String str) { 
            permutation("", str); 
        }

        private static void permutation(String prefix, String str) {
            int n = str.length();
            if (n == 0) 
            {
                if(!prefixList.contains(prefix))
                {
                    prefixList.add(prefix);
                    numbersList.add(Integer.parseInt(prefix));
                }
            }
            else {
                for (int i = 0; i < n; i++)
                {
                    permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
                }
            }
        }
    }