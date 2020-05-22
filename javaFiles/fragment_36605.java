boolean found = false;
for (int i = 0; i < items.length; i++) {
    if (items[i].equals(item)) {
        System.out.printf("%nYes, we have %s. Price:%s Inventory:%s", items[i], 
                prices[i], inventory[i]);
        System.out.print("%nHow many would you like to purchase? -->");
        int quantity = input.nextInt();
        if (inventory[i] >= quantity) {
            double total = quantity * prices[i];
            System.out.printf("%nThank you for your purchase of: Item: %s %n" 
                    + "Your total bill is: %2.2f", items[i], total);
        } else {
            System.out.printf("%nSorry, we only have Inventory:%s of Item: %s", 
                    inventory[i], items[i]);
        }
        found = true;
        break;
    }
}
if (!found) {
    System.out.printf("%nSorry, we don't have %s", item);
}