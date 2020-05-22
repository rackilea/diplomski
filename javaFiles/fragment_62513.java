System.out.println("Please enter a letter indicating your tax category: A is no tax deduction, B is 10% of gross pay, \nC is 20% of gross pay, D is 29% of gross pay, E is 35% of gross pay");
letter = in.next().charAt(0);
while (letter!='A'&&letter!='a'&&letter!='B'...) { // WHILE THE LETTER IS INVALID 
    System.out.println("You must enter a letter between A and E.");
    letter = in.next().charAt(0);
}
NOW DO ALL THE COMPUTATION