System.out.println("Confirm if you find blah blah working? Enter Y/N ");

System.setIn(new ByteArrayInputStream(data.getBytes()));
Scanner scanner = new Scanner(System.in);
String userInput = scanner.nextLine();

if(userInput.equalsIgnoreCase("Y")) {
   // Pass the test case
} else {
   //Fail the test case
}