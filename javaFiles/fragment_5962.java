while(true) {
        System.out.println("Please enter number of dependents: ");
        try{
                int dependents = stdin.nextInt();
                if(dependents >= 0) {
                    //stops loop and moves on
                    break;
                }
                else {
                    System.out.println("Can't enter a negative number.");
                }
            }catch(InputMismatchException e){
                System.out.println("Invalid input");
                //catches input and clears
                stdin.nextLine();
           }
        }
}