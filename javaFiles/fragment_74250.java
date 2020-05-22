int marks = 0;

while (true) { // Just keep running
    System.out.println("Enter Students Test Marks Here (<0 or >100 to quit)");
    int newMark = input.nextInt();
    if ((newMark<0) || (newMark>100)) break; // Skip out of while loop
    marks = newMark; // Only happens if newMark is between 0 and 100
}