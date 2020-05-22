...
try {
    System.out.print("Enter Number:");
    num = s.nextInt();
}
catch (InputMismatchException e) {
    System.out.println("False=> This is Not Integer");
}
s.nextLine();
...