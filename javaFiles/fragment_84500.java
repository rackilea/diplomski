for (int i = 0; i < 10; i++) {
    System.out.print(i + 1 + ": ");
    input = TextIO.getlnInt();  // Retrieves input
    intArray[i] = input;
    highestNumber = Math.max(input, highestNumber);
}