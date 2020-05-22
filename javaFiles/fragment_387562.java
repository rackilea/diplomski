Scanner input = new Scanner(System.in);
List<Double> numbers = new ArrayList<Double>(25);
boolean done = false;
do {
    System.out.println("Enter a number");
    String value = input.nextLine();
    done = value.equalsIgnoreCase("done");
    if (!done) {
        try {
            double number = Double.parseDouble(value);
            numbers.add(number);
        } catch (NumberFormatException fnfe) {
            System.out.println("Not valid");
        }

    }
} while (!done);

System.out.println("What is the filename?");
String filename1 = input.nextLine();
try (BufferedWriter finalFile = new BufferedWriter(new FileWriter(filename1))) {
    for (double number : numbers) {
        finalFile.write(Double.toString(number));
        finalFile.newLine();
    }
} catch (IOException ex) {
    ex.printStackTrace();
}