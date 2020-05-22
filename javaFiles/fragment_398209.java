case 2:
{
    Scanner keyboardScanner = new Scanner(System.in);
    int[] array;
    array = new int[12];

    // creates for loop 
    for (int i=0; i<12; i++) {
        System.out.println("Enter Rental for month");
        array[i] = keyboardScanner.nextInt();
    }
}

// prints i in the for loop

for (int i=0; i<array.length; i++) {
    System.out.println(array[i]);
}