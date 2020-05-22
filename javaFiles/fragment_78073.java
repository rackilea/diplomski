if (input % 2 == 0) {
    System.out.println("The input was even");
} else if (input % 2 == 1) {
    System.out.println("The input was odd");
} else {
    System.out.println("The input was not an integer");
}


reader.nextLine();//<<--------------Clear your Scanner so you can read the next input


//example with user string input
System.out.println("Verify by typing the word 'FooBar': ");
String input2 = reader.nextLine();
System.out.println("The string equal 'FooBar': " + input2.equals("FooBar"));