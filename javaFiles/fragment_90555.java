String url = "http://www.gmdu.net/corp-902113.html";

Document doc = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (Linux; U; Android 2.2; en-us; Nexus One Build/FRF91) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1")
                    .get();

Elements units = doc.select("div.unit");
System.out.println("Company Name: " + units.get(1).getElementsByTag("h1").get(0).text());
System.out.println("About Us: " + units.get(2).select("div.text").get(0).text());
for(int i = 1; i < 4; i++) {
    Elements elements = units.get(i).getElementsByTag("li");
    for(Element element : elements) 
        System.out.println(element.text());
}