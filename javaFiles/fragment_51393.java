public void demote(int position) {
    int size = items.size();  
    String itemAtSpot = items.get(position); 
    items.remove(itemAtSpot); 
    if (itemAtSpot.startsWith("urgent: ")) {
        itemAtSpot = itemAtSpot.substring("urgent: ".length());
    }
    items.add(itemAtSpot); 
}