public static void main(String[] args) {

  welcome();

  while (true){
    System.out.flush();
    System.out.println("\n1) Addition");
    System.out.println("2) Substraction");
    System.out.println("3) Multiplication");
    System.out.println("4) Division");
    System.out.println("5) Quit");
    System.out.println("\nChoose A Basic Operator:");

    Scanner operandOne = new Scanner(System.in);
    int inpOperation = operandOne.nextInt();

    switch(inpOperation) {
      case 1: additionMethod();
        break;

      case 2: substractionMethod();
        break;

      case 3: multiplicationMethod();
        break;

      case 4: divisionMethod();
        break;

      case 5: System.exit(0);

      default: System.out.println("\n(Invalid Argument)");
        return;
    }
  }
}