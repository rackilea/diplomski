if (g1 == a1) {
        numDigitsCorrect++;
        sumDigitsCorrect += a1;
}
... //other if statements
if (guess == answer) {
    System.out.println("****HOORAY!  You solved it.  You are so smart****");
    break;
}
System.out.println("Number of digits correct: " + numDigitsCorrect);
System.out.println("Sum of digits correct: " + sumDigitsCorrect);