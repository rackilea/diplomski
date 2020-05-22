//flag to keep track of if the item exists in the menu
boolean exists = false;
for (int i = 0; i < menu.length; i++) {
    //set exists to false at the beginning of the loop
    exists = false;
    if (userOrder.equals(menu[i])) {
        Order.add(userOrder);
        System.out.println("You ordered " + userOrder);
        TotalPrice.add(price[i]);
        //if the item exists in the menu, set the flag to true
        exists = true;
    } 
}
//checks if the item was never found in the menu
if (!exists) { 
    System.out.println("Sorry, we don't have that");
}