Scanner scanner = null;
try {
    scanner = new Scanner(System.in);
    //rest of the code
}
finally {
    if(scanner!=null)
        scanner.close();
}