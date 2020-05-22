System.out.println("Please select your menu option: ");
while(true) {
    try {
        MenuSelect = Input.nextInt();   
        break;        
    }
    catch (InputMismatchException e) {
        System.out.println("That's not a valid number!");
        Input.nextLine(); // consumes the invalid int.
    }
}
// do stuff with the input here...