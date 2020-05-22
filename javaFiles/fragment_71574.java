Document document = Jsoup.connect("http://www.earnings.com/company.asp?client=cb&ticker=gd").get();
Elements dateColumn = document.select("table:eq(0) tr:eq(0) table:eq(7) tr:eq(2) table:eq(4) td:eq(6):not(.dataHdrText02)");

for (Element dateCell : dateColumn) {
    System.out.println(dateCell.text());
}