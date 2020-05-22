public static void doit(int n) {
        if (n < 1) {
            return;
        }
        System.out.println("Value of n before call: " + n);
        doit(n-1);
        // previous n's will be listed here in reverse order.
        System.out.println("Value of n when returning: " + n);
    }