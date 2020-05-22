Set<String> itemIds = new HashSet<String>();

//...
itemId = p.getItemId();
itemIds.add(itemId);

//... later ...
int uniqueItemIdCount = itemIds.size();