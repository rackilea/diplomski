Scanner scanner = new Scanner(System.in);
List<String> acceptedAnswers = Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i");
String input;
do {
    System.out.println(
            "Please enter the location of your battleship, starting with the first letter value. Make sure it is from the letters a-i.");
    input = scanner.nextLine();
} while (!acceptedAnswers.contains(input));
scanner.close();
System.out.println("Got correct input: " + input);