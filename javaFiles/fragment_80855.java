String alpha = "aeiou";
  int n = 5;

  String pattern = String.format("[%s]{%s}", alpha, n);

  System.out.println(pattern);
  // [aeiou]{5}