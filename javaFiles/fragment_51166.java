int total = 0;
System.out.println("Please enter some numbers with a space between each");
String lineWithNumbers = kb.nexLine();
Scanner lineScanner = new Scanner(lineWithNumbers);
while (lineScanner.hasNext()) {
    total += lineScanner.nextInt();
}