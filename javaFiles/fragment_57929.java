public static List<Integer> primesRecursive(int n) {
    return primesRecursive(n, 2);
 }

 //overload a private method that also takes f as argument:
 private static List<Integer> primesRecursive(int n, int f) {
     if (n == 1) return new ArrayList<Integer>();
     if (n % f == 0) {
         List<Integer> factors = primesRecursive(n/f, f);
         factors.add(f);
         return factors;
     } else
         return primesRecursive(n, f+1);
 }