double first = 0.0;
double second= 0.0;
int lines = 0;

if (scanner.hasNextLine()) {
    String line = scanner.nextLine();
    String[] numbers = line.split("\\s+"); // split on white spaces
    first += Double.parseDouble(numbers[0]);
    second += Double.parseDouble(numbers[1]);
    lines++;
}
if (lines > 0) {
    System.out.println(first / lines);
    System.out.println(second / lines);
}