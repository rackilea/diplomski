while (n <= endNum) {
    sum = 0; // add this
    for (int i = 1; i < n; i++) {
        if (n % i == 0) {
            sum = sum + i;
        }
    }

    if (sum == n && n != 0) {
        System.out.println(n + " is perfect");
    }

    if (sum > n) {
        System.out.println(n + " is imperfect abundant");
    }

    if (sum < n) {
        System.out.println(n + " is imperfect deficient");
    }

    if (n == 0) {
        System.out.println(n + " has no factors");
    }
    n++;
}