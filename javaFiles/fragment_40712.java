public static int isBishal(int n){
   Set<Integer> factors = new HashSet<>();  // Create a Set for factors 
   for (int i = 2; i < n; i++) { 
       if (n % i == 0) {   // CHeck if i is factor of n using %
           factors.add(i);  // If i is a factor add it to factors
       }
   }
   if (factors.contains(factors.size())) {
        return 1;   // If a factor is equal to the number of factors return 1
   }
   return 0;   // If none factor equals number of divisors return 0
}