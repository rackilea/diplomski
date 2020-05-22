public static void main(String[] args) {
    Scanner in= new Scanner(System.in);
    int customerID = in.nextInt();
    int sum = 0;
    // sum needs to be initialized outside the while loop
    // or else you wouldn't be able to use it outside it
    while(customerID > 0) {
        int Reminder = customerID % 10;
        sum = sum+ Reminder;
        customerID = customerID / 10;
    }
    if(sum%5 == 0 || sum%8 == 0) {
        //You cannot use int as a condition in if
        System.out.println("Lucky Customer");
    } else {
        System.out.println("Unlucky Customer");
    }
    if(sum <0) {
        System.out.println("Invalid Input");
    }
}