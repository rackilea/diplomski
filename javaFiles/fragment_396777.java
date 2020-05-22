// This method returns the Resource ID to be used to make the copy
public String loadDocsSpreadsheetEntryId(String sourceName) {
    String resourceId = null;
    try {

    Logger.info("Loading feed URL");
    URL url = new URL("https://docs.google.com/feeds/default/private/full" );
    DocumentQuery query = new DocumentQuery(url);
    query.setTitleQuery(sourceName);
    query.setTitleExact(true);

    Logger.info("Loaded feed URL");
    DocumentListFeed dfeed = this.dService.getFeed(query, DocumentListFeed.class);
    Logger.info("got feed");
    for (DocumentListEntry entry : dfeed.getEntries()) {
        Logger.info(entry.getTitle().getPlainText());
        if(entry.getTitle().getPlainText().equalsIgnoreCase(sourceName))
        {
            Logger.info("found doc");
            resourceId = entry.getResourceId();
        }
     }
    } catch(Exception e) {
        logException(e, "Loading Source Spreadsheet to copy");
    }

    return resourceId;
}

    public void createSpreadsheetFrom(String destination, String source) {
        try {
        URL entryUrl = new URL("http://docs.google.com/feeds/default/private/full");
        Map<String, String> parameters = new HashMap<String, String>();
        String resourceID = loadDocsSpreadsheetEntryId(source);
        Logger.info("Resource id %s", resourceID);

        DocumentListEntry newEntry = new DocumentListEntry();
        newEntry.setId(resourceID);
        newEntry.setTitle(new PlainTextConstruct(destination));
        this.dService.insert(entryUrl, newEntry);

        } catch(Exception e) {
            logException(e, "Copying Spreadsheet");
        }

}