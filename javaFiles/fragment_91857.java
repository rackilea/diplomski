public void google() throws IOException {
        Document doc = Jsoup.connect("https://www.google.com/finance/converter?a=1&from=USD&to=BDT").get();
        Element element = doc.getElementById("currency_converter_result");
        String text = element.text();
        System.out.println(text);
    }