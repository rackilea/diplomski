URL cellFeedUrl = new URL(worksheet.getCellFeedUrl().toString() + "?min-row=1&max-row=1");
CellFeed cellFeed = service.getFeed(cellFeedUrl, CellFeed.class);
for(CellEntry cellEntry : cellFeed.getEntries()) {
    System.out.print(cellEntry.getCell().getValue() + ",");
}
System.out.println();