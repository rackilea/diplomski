Document doc = Jsoup.connect("http://www.eleicoes2012.info/adeilza-psb-40656/").get();
Elements spans = doc.select("span.legenda");

for(Element span: spans) {
    System.out.println(span.nextSibling());
}