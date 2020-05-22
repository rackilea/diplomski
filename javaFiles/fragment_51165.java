int total = 0;
System.out.println("Please enter some numbers with a space between each");
String lineWithNumbers = kb.nexLine();
String[] numbers = lineWithNumbers.split(" ");
for (String number : numbers) {
    total += Integer.parseInt(number);
}