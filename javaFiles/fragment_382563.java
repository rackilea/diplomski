public static void decimalToBinary(){
    Scanner input = new Scanner (System.in);
    while (!*terminatingCondition*) {
      System.out.println ("Input decimal number");
      String decimal = input.next();
      System.err.println(Integer.toString(new Integer(decimal), 2));
  }
}