Document doc = Jsoup.connect("http://www.movieplus.com/hollywood/upcoming/").get();
Elements elements = doc.select(".ListDetails .ListData");
for (Element el : elements) {
    System.out.println(el.select("a[href]").first().attr("href"));
    System.out.println(el.select("img[title]").first().attr("title"));
    System.out.println(el.select(".mRate ,want").text());
    System.out.println(el.select(".relDate").text());
    System.out.println("----------");           
}