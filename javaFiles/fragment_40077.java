if(scanner.hasNextInt()) {
    int x = 0;

    try {
         x = Integer.parseInt(scanner.nextLine());
    } catch (NumberFormatException e) {
         e.printStackTrace();
    }

    list.add(x);
    System.out.println("user input: " + x);
}