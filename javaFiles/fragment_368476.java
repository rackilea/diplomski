else if (input.equals("c")) {
    System.out.println("What column? (1-4)");

    try{
        int column = s.nextInt();
        s.nextLine();
        if (column <= 4){
            rotateColumn(currentarr,column - 1);
            print(currentarr);
            b++;
        }
        else
           System.out.println("Invalid Input");
     }catch (InputMismatchException ex){
         System.out.println("Invalid Input");
     }