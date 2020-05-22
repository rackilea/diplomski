Scanner input = new Scanner(System.in);

    System.out.print("Choose letter in range [a - p]");
    letter = input.next().charAt(0);

    if (Character.toString(letter).matches("^[a-pA-P0-9]*$")) {
         System.out.println("valid input");
    }else{
         System.out.println("invalid input");
    }