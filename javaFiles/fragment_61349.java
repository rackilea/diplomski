String yourHtml = "<someHtml/>"; 
Document doc = Jsoup.parseBodyFragment(yourHtml);

Element table = doc.getElementByTag("tbody");
Elements rows = table.getElementsByTag("tr");
for (Element row : rows) {
    for (Element cell : row.getElementsByTag("td")) {
        String content = cell.text();
    }
}