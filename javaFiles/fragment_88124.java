for (int i = 2; i * i <= n; i++) {

    // if i is a factor of N, repeatedly divide it out
    while (n % i == 0) {
        n = n / i;
        factors.append(Integer.toString(i));
        print(i + " ");
    }
}