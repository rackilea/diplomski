if (input.matches("S")) {
    System.out.println("Enter an array postion from 1 to 5 to show paitient's details");

    int number = enterNumber0.nextInt();

    if (number >= 1 && number <= 5) {
        System.out.println("Name: " +clientsDetails[number - 1].nameLable);
        System.out.println("Age: " +clientsDetails[number - 1].howOld);
        System.out.println("Postcode: " +clientsDetails[number - 1].postcode);
        System.out.println("Phone Number: " + clientsDetails[number - 1].cellPhoneNumber);
    }
}