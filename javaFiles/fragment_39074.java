public void findItems()
{
ItemView view = new ItemView(10);
view.getOrderBy().add(ItemSchema.DateTimeReceived, SortDirection.Ascending);
view.setPropertySet(new PropertySet(BasePropertySet.IdOnly, ItemSchema.Subject,
        ItemSchema.DateTimeReceived));


FindItemsResults<Item> findResults = service.findItems(WellKnownFolderName.Inbox, new SearchFilter.SearchFilterCollection(
LogicalOperator.Or, new SearchFilter.ContainsSubstring(ItemSchema.Subject, "EWS"), 
new SearchFilter.ContainsSubstring(ItemSchema.Subject, "API")),view);

System.out.println("Total number of items found: " + findResults.getTotalCount());

for (Item item : findResults)
    {
            System.out.println(item.getSubject());
            System.out.println(item.getBody());
            // Do something with the item.
    }
}