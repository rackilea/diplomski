public  static void printArray(ArrayList<Integer> primes){
    // You need to have a counter as you iterate over the list
    int count = 1;
    // Integer is autoboxed into an int when interating over prime
    for(int prime : primes){
        // "%7d" instead of "%7s" as d is used for integer but s is used for strings
        System.out.printf("%7d ", prime);
        // count++ will icrement count after this statement is called
        if (count++ % 10 == 0){
            System.out.println();
        }
    }
}