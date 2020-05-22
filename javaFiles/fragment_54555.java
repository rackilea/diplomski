String temp = scanner.nextLine();
System.out.println(temp);

System.out
        .println(" Would you like to update this information ? ");
String yellow = forget.nextLine();
if (yellow.equals("yes")) {
    removedata(temp); // NoSuchElementException
                                    // error
} else if (yellow.equals("no")) {

    System.out.println("Have a good day");
    // break;
}