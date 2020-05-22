{
...
adapter = new ItemArrayAdapter(...);
...
deleteExtraElementsFromEnd(2, itemList)
adapter.addAllItems(itemList);
adapter.notifyDataSetChanged();
}