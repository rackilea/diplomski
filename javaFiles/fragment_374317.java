// Feed header
SyndFeed feed = new SyndFeedImpl();
feed.setFeedType("rss_2.0");
feed.setTitle("Sample Feed");
feed.setLink("http://example.com/");

// Feed entries
List entries = new ArrayList();
feed.setEntries(entries);

SyndEntry entry = new SyndEntryImpl();
entry.setTitle("Entry #1");
entry.setLink("http://example.com/post/1");
SyndContent description = new SyndContentImpl();
description.setType("text/plain");
description.setValue("There is text in here.");
entry.setDescription(description);
entries.add(entry);

// Write the feed to XML
StringWriter writer = new StringWriter();
new SyndFeedOutput().output(feed, writer);
System.out.println(writer.toString());