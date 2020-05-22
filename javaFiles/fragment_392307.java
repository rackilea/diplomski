Document doc1 = Jsoup.parse(s);
Elements type1 = doc1.select("[class=\"style3\"]");
try {       
    String text =type1.first().html();
    text = text.replaceAll("<br>", "\n");
    System.out.println(text);
} catch (Exception e) {
    e.printStackTrace();
}