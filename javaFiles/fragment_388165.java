do{
    try{
        System.out.println("Enter how much money you will start with: ");
        money=input_var.nextInt();
    }catch (InputMismatchException e){
        System.out.println("Sry, not a valid integer");
        input_var.next();
    }
}while (money<=0);