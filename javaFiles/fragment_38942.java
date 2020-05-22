Document document = Jsoup.connect("http://www.librarything.com/work/9767358/78536487").get();
Elements tags = document.select(".tags .tag a");

for (Element tag : tags) {
    System.out.println(tag.text());
}