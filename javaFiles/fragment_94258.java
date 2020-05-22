Document doc = Jsoup.parse(htmlText);
Elements relLinks = doc.select("a[rel]");
//or if you want rel only with "prettyPhoto[gallery-113]" use
//Elements relLinks = doc.select("a[rel=prettyPhoto[gallery-113]]");//
System.out.println("number of `rel`: "+relLinks.size());
for (Element el : relLinks){
    System.out.println(el.attr("href"));
}