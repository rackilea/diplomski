public void AddItem(Item item) {
    if(numItems < itemsToBuy.length){
        itemsToBuy[numItems] = item; //insert item in the array
        numItems++; //increment the number of items
    } else {
        System.out.println("Your cart is full.");
    }
}