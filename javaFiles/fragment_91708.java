Document doc = (Document) Jsoup.parse(new File(input), "UTF-8");
Elements paragraphs = ((Element) doc).select("td.text");

for (Element p : paragraphs) {
    System.out.println(p.text());
    Elements links =  p.getElementsByTag("a");
    for (Element link : links) {
        String linkHref = link.attr("href");
        String linkText = link.text();
        System.out.println("\n\n" + linkText + ">\r\n" + linkHref + "\r\n");
    }
}