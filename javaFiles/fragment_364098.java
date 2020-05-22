public static int factorial (int n) {
    int f = 1;
    for (int i = 1; i <= n; ++i) {
      f *= i;
      // return f; // Not needed - this is causing the problem
    }
    return f; // This is your required return
}