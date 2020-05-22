Scanner keyboard = new Scanner(System.in);
System.out.println("Enter a number of length and width of the first blocks and I will draw some stairs!");
int number = keyboard.nextInt();
for (int n = 1; n <= number; n++) { // loop over the steps
    for (int i = 0; i < n * number; i++) { // for each step, make a rectangle of length "n * number"
        for (int j = 0; j < n * number; j++) {
            System.out.print("*");
        }
        System.out.println("");
    }
}