Document doc = Jsoup.connect("http://tamilblog.ishafoundation.org/nalvazhvu/vazhkai/").get();

for (Element a : doc.select("section#content article a")) {
    System.out.println("Title : \n" + a.text());
    System.out.println(a.absUrl("href")); // absUrl is used here for *always* having absolute urls.
}