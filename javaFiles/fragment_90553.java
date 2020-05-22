String url = "http://www.gmdu.net/corp-902113.html";

Document doc = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64; rv:5.0) Gecko/20100101 Firefox/5.0")
                    .get();

Element content = doc.select("div.content").get(0);

doc = Jsoup.parse( content.html().replaceAll("</div>", "</div><span>").replaceAll("<div", "</span><div") );

Elements labels = doc.select("div.label");
for (Element label : labels) {
    System.out.println(String.format("%s %s", label.text().trim(),
            label.nextElementSibling().text()));
}