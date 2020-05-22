for (int i = 0; i < n; i++) {
  for (int j = 0; j < n; j++) {
    if (i == n - 1) {
      System.out.print(1);
    } else {
      System.out.print(j % 2);
    }
  }
  System.out.println();
}