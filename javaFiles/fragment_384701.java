Scanner z = new Scanner(System.in):
    double first = z.nextInt();
    double second = z.nextInt();
    double third = z.nextInt();
    double d = (second * second - 4 * first * third);
    double re = -second / (2 * first);
     if (d >= 0) {  // i.e. "if roots are real"
        System.out.println(Math.sqrt(d) / (2 * first) + re);
        System.out.println(-Math.sqrt(d) / (2 * first) + re);
    } else {
      System.out.println(re + " + " + (Math.sqrt(-d) / (2 * first)) + "i");
      System.out.println(re + " - " + (Math.sqrt(-d) / (2 * first)) + "i");
    }