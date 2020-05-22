if (scanner.hasNextFloat()) {
    System.out.println("float");
    float myValue = scanner.nextFloat();
    // do something with the float myValue
}else if (scanner.hasNextInt()) {
    System.out.println("int")
    int myValue = scanner.nextInt();
    // do something with the int myValue
} else { // fallback on string
    String myValue = scanner.next();
    // do something with the string myValue
}