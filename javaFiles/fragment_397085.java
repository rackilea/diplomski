Scanner input = new Scanner(System.in); //construct scanner
while(!input.hasNextInt()) {
    input.next(); // next input is not an int, so consume it and move on
}
int finalInput = input.nextInt();
input.close(); //closing scanner
System.out.println("finalInput: " + finalInput);