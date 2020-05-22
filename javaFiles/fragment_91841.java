public static void main(String[] args) throws Exception {
    URL feedUrl = new URL("https://stackoverflow.com/jobs/feed");
    SyndFeedInput input = new SyndFeedInput();
    SyndFeed feed = input.build(new XmlReader(feedUrl));

    feed.getEntries()
        .forEach(entry -> {
            System.out.println(get("author", entry.getForeignMarkup()));
            System.out.println(get("updated", entry.getForeignMarkup()));
        });

}

private static String get(String name, List<Element> foreignMarkup) {
    return foreignMarkup.stream()
                        .filter(e -> name.equals(e.getName()))
                        .map(Element::getValue)
                        .findFirst()
                        .orElse(null);
}