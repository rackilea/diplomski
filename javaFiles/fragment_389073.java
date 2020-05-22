public static int gcd (int n, int m) {

    if (m > n) {
      if ((m % n) == 0) 
         return n;
      else
         return gcd(n, m % n);
    }
    else {
        if ((n % m) == 0) 
             return m;
          else
             return gcd(m, n % m);
    }
}

public static void main(String[] args) {    

    for (int n = 1; n <= 10; n++) {

        for (int m = 1; m <= 10; m++) {
            System.out.println("n: " + n + " m: " + m + " gcd: " + gcd(n, m));
        }
    }
}