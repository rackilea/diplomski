int dependentsRerun = 0;//makes user enter valid input for dependents
    while(dependentsRerun == 0) {
        System.out.println("Please enter number of dependents: ");
        try{
                int dependents = stdin.nextInt();
                if(dependents>=0) {
                    dependentsRerun = 1;
                }
                else {
                    System.out.println("Invalid input");
                }
            }catch(InputMismatchException e){
                System.out.println("Invalid input");
                //catches input and clears
                stdin.nextLine();
           }
        }

}