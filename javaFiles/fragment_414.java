URL metafeedUrl = new URL("https://spreadsheets.google.com/feeds/spreadsheets/private/full");
SpreadsheetFeed feed = service.getFeed(metafeedUrl, SpreadsheetFeed.class);
List<SpreadsheetEntry> spreadsheets = feed.getEntries();
for (int i = 0; i < spreadsheets.size(); i++) {
  SpreadsheetEntry entry = spreadsheets.get(i);
  System.out.println("\t" + entry.getTitle().getPlainText());
}