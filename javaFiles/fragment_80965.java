int n = 5368;
int result = 0;

if (n > 0) {
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;

    while (n > 0) {
        int digit = n % 10;

        max = Math.max(max, digit);
        min = Math.min(min, digit);

        n /= 10;
    }

    result = min + max;
}

System.out.println(result);