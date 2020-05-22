public static int getPrimes(int start, int stop) {
        int countprime = 0;
        boolean b1 = true;
        for (int j = start; j <= stop; j++) {
            b1 = true;
            for (int i = 2; i <= j / 2; i++) {
                if (j % i == 0) {
                    b1 = false;
                    break;
                }
            }

            if (b1 == true)
                countprime++;
        }
        return countprime;
    }