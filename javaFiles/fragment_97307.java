int option = 0;
boolean inputOk = false;
do{
    try {
        option = myscan.nextInt();
        inputOk = true;
    } catch (InputMismatchException  e) {
        System.out.println("Error, this is not an integer.");
        myscan.nextLine(); // to consume the \n that remains at the end of the line after using nextInt();
    }
}while (!inputOk);