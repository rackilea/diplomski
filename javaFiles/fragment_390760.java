int sumOfCubes() {
    int d, sum = 0;
    while (n != 0)
        { d = n % 10;
          n /= 10;
          sum += d;
        }
    return sum;
}