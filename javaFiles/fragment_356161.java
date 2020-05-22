Document doc = Jsoup.connect("http://www.novaprojecten.nl/roosters/lbl/basis/38/c/c00086.htm").get();
List<String> days = new ArrayList<String>();
for (Element col: doc.select("body > center > table > tbody > tr:lt(1) font")) {
    days.add(col.text());
}
System.out.println(days); // Maandag 17-09, Dinsdag 18-09, Woensdag 19-09...