for (int i = 0; i < items.length; i++ ) {
    System.out.println("Would you like to order a " + items[i] + "?");
    String itemSelected = scanner.nextLine();
    if (itemSelected.equals("yes"))
        System.out.println("Your total is " + selection[i] + ".");
}