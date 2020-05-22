public static String[] searchIUPACName(String chemicalFormula) throws IOException {
    org.jsoup.nodes.Document doc = org.jsoup.Jsoup.connect("http://www.endmemo.com/chem/chemsearch.php")
            .data("Search", "Search").data("name", chemicalFormula).data("sel", "f").post();
    org.jsoup.select.Elements elements = doc.getElementById("note").getElementsByClass("cmline");
    if (elements.isEmpty())
        return new String[] { "No results" };
    String[] names = new String[elements.size() - 1];
    for (int i = 1; i < elements.size(); i++) {
        names[i - 1] = elements.get(i).getElementsByClass("cmname").get(0).getElementsByTag("a").get(0).text();
    }
    return names;
}