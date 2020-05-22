String str="http://www.gsmarena.com/"; Document doc=Jsoup.connect(str).userAgent(" Mozilla//5.0 (Windows NT 6.1; WOW64) AppleWebKit//537.36 (KHTML, like Gecko) Chrome//49.0.2623.110 Safari//537.36").get();
Elements links = doc.select("li[class=news-column-list-item]");

for (Element link : links) {

    System.out.println(link.select("a[href]").attr("href"));
}