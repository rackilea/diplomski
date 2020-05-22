final Document document = Jsoup.parse(test);
final Element entireRow = document.select("tr:contains(STRING TO CAPTURE)").get(0);
for (final Element column : entireRow.select("td")) {
    System.out.println("Column text is: " + column.text());
}
final Elements link = entireRow.select("td:contains(STRING TO CAPTURE) + td > a[href]");
System.out.println("Target link is: " + link.attr("href"));