//result list
List<Item> itemsWithSameNumber = new ArrayList<>();

for (Item item : items) {
    if (item.getItemNumber().equals(yourKey)) {
        itemsWithSameNumber.add(item);
    }
}