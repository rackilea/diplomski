int marks = -1; // Start with an "illegal" marks value

while ((marks<0) || (marks>100)) { // while we have an illegal mark ...
    System.out.println("Enter Students Test Marks Here (0..100)");

    marks = input.nextInt(); // ... ask for a new one
}