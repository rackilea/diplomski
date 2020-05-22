public class Test {
    public static void main(String[] args) {
        int K = 44;
        List<Integer> inputs = Arrays.asList(19,23,41,5,40,36);

        int opt = 0;                // optimal solution so far          

        Set<Integer> sums = new HashSet<>();
        sums.add(opt);

        // loop over all input values
        for (Integer input : inputs) {
            Set<Integer> newSums = new HashSet<>();

            // loop over all sums so far                        
            for (Integer sum : sums) {
                int newSum = sum + input;

                // ignore too big sums
                if (newSum <= K) {
                    newSums.add(newSum);

                    // update optimum                       
                    if (newSum > opt) {
                        opt = newSum;
                    }
                }
            }

            sums.addAll(newSums);
        }

        System.out.println(opt);
    }
}