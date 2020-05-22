findPrimeNumbers(int from, int to){
   ArrayList<Integer> primes = new ArrayList<>();  // arrays don't grow dynamically, so you need a list and convert it in the end to an array
   for( ; from<to; from++){
        if(isPrimeNum(from)){
           primes.add(from);
        }
   }
   // at this point you have all your prime numbers from "from" to "to" in the primes list
   // now convert it and return it:
   return primes.toArray(new Integer[primes.size()]);   // ugly but it does the job
}