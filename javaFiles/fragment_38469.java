if(command.equals("additem")) {
    int itemNumber = Integer.parseInt(tokens[1]);
    int quantity = Integer.parseInt(tokens[2]);
    inventoryManager.addItem(itemNumber,quantity);
    continue;
}