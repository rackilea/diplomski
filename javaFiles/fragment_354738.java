public static int countDigitx(int n, int x) {
        int count = 0;

        if (n == 0) {
            count = 0;
        } else if (n%10 == x) {
            count++;
          count += countDigitx(n/10,x);
        } else {
           count += countDigitx(n/10,x);
        }

        return count;
    }