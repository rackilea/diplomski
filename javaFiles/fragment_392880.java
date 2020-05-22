private int myIntGetter(String caption, boolean forcePositive) {
    System.out.println(caption);
    Scanner input = new Scanner(System.in);
    int intValue = input.nextInt();
    while ((forcePositive) && (intValue <=0)) {
      System.out.println("Number must be greater than \0");
      System.out.println(caption);
      intValue = input.nextInt();
    }
    // here intValue is valid
    return intValue;
  }