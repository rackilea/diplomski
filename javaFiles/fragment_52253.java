int i = -1; // <-- give it a default value.
Scanner scan = new Scanner(System.in);
while (scan.hasNext()) { // <-- check for any input.
    if (scan.hasNextInt()) { // <-- check if it is an int.
        i = scan.nextInt(); // <-- get the int.
        break; // <-- end the loop.
    } else {
        // Read the non int.
        System.out.println("Invalid input! " + scan.next()); 
    }
}