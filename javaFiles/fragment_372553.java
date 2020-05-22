Scanner i = new Scanner(System.in);
int day;
do {
    System.out.println("Enter number 2 to get week day names (7)");
    day = i.nextInt(); //This fixes infinite loop, you missed to read everytime you entered the loop.
    //Your switch here
} while (day != 3);