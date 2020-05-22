String confirmation = br.readLine();
if (confirmation.equals("1")) {
    totalPrice += ticketType.getPrice() * quantity;
    System.out.println("Current total is: " + totalPrice);
} else {
    System.out.println("You did not press 1 so ticket purchase cancelled");
    System.out.println("Current cost is still: " + totalPrice);
}