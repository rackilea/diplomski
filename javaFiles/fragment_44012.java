String u = "http://www.thehindu.com/business/";
Document docu = (Document) Jsoup.connect(u).get();

Elements lnk = docu.select("h3 a[href]");
for (Element an : lnk) {
    String s = an.attr("abs:href");
    String name = an.text();

    System.out.println(name);
    System.out.println(s);
    System.out.println("--------");

}