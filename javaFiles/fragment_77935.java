//result map
HashMap<BigDecimal, List<Item>> map = new HashMap<>();

for (Item item : items) {
    List<Item> itemsWithSameNumber = map.get(item.getItemNumber());
    if (itemsWithSameNumber == null) { //does not exist in map yet
        itemsWithSameNumber = new ArrayList<Item>();
        map.put(item.getItemNumber(), itemsWithSameNumber);
    }
    itemsWithSameNumber.add(item); //now add the item to the list for this key
}