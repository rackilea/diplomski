if(command.equals("additem")) {
    int itemNumber = Integer.parseInt(tokens[1]);
    int quantity = Integer.parseInt(tokens[2]);
    if(items.contains(itemNumber) { // exists, add to current
        int currentQuantity = items.get(itemNumber);
        int newQuantity = quantity + currentQuantity;
        items.put(itemNumber,newQuantity);
    } else { // doesn't exist, make new entry
        items.put(itemNumber,quantity);
    }
    continue;
}