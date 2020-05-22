Scanner scanner = new Scanner(new File("input.txt"));
scanner.useDelimiter("\\Z");
String htmlString = scanner.next();
scanner.close();

Document doc = Jsoup.parse(htmlString);
// or to get connect of some page use
// Document doc = Jsoup.connect("http://example.com/").get();
Elements elements = doc.select("a[href]");//find all anchors with href attribute
for (Element el : elements) {
    URL url = new URL(el.attr("href"));
    if (url.getPath().matches(".*\\.(?:avi|flv|mp4)")) {
        System.out.println("url: " + url);
        //System.out.println("file: " + url.getPath());
        System.out.println("file name: "
                + new File(url.getPath()).getName());
        System.out.println("------");
    }
}