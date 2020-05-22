class SimpleComparator implements Comparator<InventoryItem> {
    @Override
    public int compare(InventoryItem o1, InventoryItem o2) {       
            return new Integer(o1.getItemNumber()).compareTo(o2.getItemNumber());
    }
}
//Sorting based on the  itemNumber.
Collections.sort(inventory,new SimpleComparator());

int newItemNumber = inventory.get(inventory.size() - 1).getItemNumber();
newItemNumber ++;