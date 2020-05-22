input = input.replaceAll("[^0-9]"," ");
Scanner lineRead = new Scanner(input);
System.out.println(input);

try {
  xPosition = lineRead.nextInt();
  yPosition = lineRead.nextInt();
} catch ( 
    InputMismatchException |
    NoSuchElementException |
    IllegalStateException ex) {
  bad input
}