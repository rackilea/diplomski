public final class Example {
    public static void main(String[] args) {
        //Instead of randomly choosing the predicate, use your condition here
        Random random = new Random();
        IntPredicate intPredicate = random.nextBoolean() ? i -> i % 2 == 0 : i -> i % 3 != 1;

        int k = 0;
        while(k<50){
            /*
             *At this point the predicate is either k%2==0 or k%3!=1,
             * depending on which lambda you assigned earlier.
             */
            if(intPredicate.test(k)){ 
                // Code logic goes here
                k++;
            }
        }
    }
}