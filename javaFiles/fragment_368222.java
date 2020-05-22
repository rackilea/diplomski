...
   public static void main(String[] args) {
      System.out.println(rank("/"));
      String infix = "a * b * c + d ^ e / f";
      System.out.println(toPostfix(infix));
      System.out.print("Using applyOperator method, 7 * 3 = ");
      System.out.println(applyOperator("*", 3, 7));
      System.out.print("Using applyOperator method, 50 + 12 = ");
      System.out.println(applyOperator("+", 50, 12));
   } 
} // you lost this bracket.