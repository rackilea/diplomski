SyndFeed feed = ..
for(SyndEntry entry : feed.getEntries()) {
    for (Module module : entry.getModules()) {
        System.out.println(module.getClass());

        if (module instanceof EntryInformation) {
            EntryInformation itunesEntry = (EntryInformation)module;
            ..
        }
    }
}