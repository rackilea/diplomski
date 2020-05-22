Scanner s = new Scanner(System.in);
String input = s.nextLine();

try {
    int i = Integer.parseInt(input);
    System.out.println("It is integer.");

} catch (NumberFormatException e) {
    try {

        Double d = Double.parseDouble(input);
        System.out.println("It is double.");
    } catch (NumberFormatException e1) {

        System.out.println(input + " is neither an integer or a double");
    }
}