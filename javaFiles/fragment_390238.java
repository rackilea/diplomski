List<Item> itemToRemove = new LinkedList<Item>(); 

for (Items i: itemList) {

    if(i.getName().contains(name) && i.getPrice() == price)) {

        itemToRemove.add(i);
    }
}

itemList.removeAll(itemToRemove);