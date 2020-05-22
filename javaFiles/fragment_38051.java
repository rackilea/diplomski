AssistantGUI gui = new AssistantGUI();

public static void main(String[] args) throws IOException {
    new LinkExctractor().execute();
}

private void execute() {
    //Validate.isTrue(args.length == 1, "usage: supply url to fetch");
    String base = "http://uk.ask.com/web?q=";
    String keyword ="flowers";
    String tail = "&search=&qsrc=0&o=312&l=dir";
    String url = base + keyword + tail;

    print("Fetching %s...", url);

    Document doc = Jsoup.connect(url).get();
    Elements links = doc.select("a[href]");

    print("\nLinks: (%d)", links.size());
    for (Element link : links) {
        print(" * a: <%s>  (%s)", link.attr("abs:href"), trim(link.text(), 35));
    }
}

private void print...