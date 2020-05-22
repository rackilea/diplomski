public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int option;
    do{
        System.out.println("Enter 1 or 2");
        System.out.println();
        try{
            option = input.nextInt();
            switch(option){
                case 1: 
                    System.out.println("option: "+option);
                    break;
                case 2:
                    System.out.println("option: "+option);
                    break;
                default: 
                    throw new InputMismatchException();
            }
        }
        catch(InputMismatchException ex){
            input.nextLine();
            System.out.println("Invalid menu number entered. A valid menu option is required. Enter you choice again: ");
        }
    }while(true);
}