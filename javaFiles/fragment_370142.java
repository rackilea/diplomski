while (!scanner.hasNext()) {
    // sleep here
}
if (scanner.hasNextInt()) {
   selection = scan.nextInt();
} else {
    selection = 0;
    scan.next();  // reads the garbage.
}