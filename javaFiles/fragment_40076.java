if(scanner.hasNextInt()){
    int x = scanner.nextInt();
    scanner.nextLine();  // Add a blank nextLine
    list.add(x);
    System.out.println("user input: " + x);
}