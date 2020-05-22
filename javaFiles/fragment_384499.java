Scanner input = new Scanner(System.in);
System.out.println("Enter integer values: ");
for (int i = 0; i < Array1.length; i++){
    try {
        Array1[i]= input.nextInt();
    } catch (InputMismatchException e) {
        System.out.println("Please enter integers only");
        i--;
    }
}
// Now your Array1 is filled with ints