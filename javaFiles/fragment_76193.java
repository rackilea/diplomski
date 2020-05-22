Document doc = Jsoup.connect("http://www.x-rates.com/table/?from=USD&amount=1").get();

Elements rows = doc.select("table.ratesTable > tbody > tr");

for (Element row : rows) {
    Elements tds = row.select("td");

    String currency = tds.get(0).text();
    Double rate1 = Double.valueOf(tds.get(1).text());
    Double rate2 = Double.valueOf(tds.get(2).text());

    System.out.printf("Currency: %s, rate1: %s, rate2: %s%n", currency, rate1, rate2);
}