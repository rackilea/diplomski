public static void main(String args[]) {
  Scanner str = new Scanner(System.in);
  System.out.print("The grammer is : S->AB, A->aA, A->a,B->Bb,B->b\n ");
  System.out.print("Enter your string\n ");
  boolean accepted = str.nextLine().matches("a+b+");

  if (!accepted) {
     System.out.println("String is not accepted ");
  } else {
      System.out.println("The string is accepted");
  }
}