protected static void searchByCategoryAndDateOldVersion() throws Exception{
    ItemView view = new ItemView(Integer.MAX_VALUE);
    view.getOrderBy().add(ItemSchema.DateTimeReceived, SortDirection.Ascending);

    Calendar calendar = new GregorianCalendar(2017, 2, 21, 10, 35, 0);
    Date time = calendar.getTime();

    DateFormat dateFormat = new SimpleDateFormat();
    String dateLimit = dateFormat.format(time);

    String aqs = String.format("category:categoryToSearch AND received:>=%s", dateLimit);

    FindItemsResults<Item> findResults = service.findItems(WellKnownFolderName.Inbox, aqs, view);

    service.loadPropertiesForItems(findResults, PropertySet.FirstClassProperties);

    System.out.println("Items found: " + findResults.getTotalCount());

    for (Item item : findResults) {
            System.out.println(item.getSubject());
    }
}