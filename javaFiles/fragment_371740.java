if( scan.hasNextDouble() ) {
    ...
} else {
    System.out.print( "Error: You must enter a number! Try again: " );
    Amount = scan.nextDouble();  // problem is here, remove it!
}