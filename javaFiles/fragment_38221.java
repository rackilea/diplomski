public void viewaccount() {

    Scanner getinput = new Scanner(System.in);
    System.out.println("Enter your account number to log in");
    int login = getinput.nextInt();

    // Correct account number:
    int correctAccountNumber = 1234567;

    if (login == correctAccountNumber) {
        // Hooray! Success.


    }else{
        System.out.println("You have entered the incorrect account number.");
    }

}