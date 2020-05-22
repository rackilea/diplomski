Document doc1 = Jsoup.parse(s);
Elements type1 = doc1.select("[class=\"style3\"]");
try {       
    String text =type1.first().html();
    String[] textSplitResult = text.split("<br>");
    if (null != textSplitResult) {
         for (String t : textSplitResult) {
             System.out.println(t);
         }
    }
} catch (Exception e) {
    e.printStackTrace();
}