public Class QuoteService{
    public String checkQuote(String symbol) {
        try {
            String url = "http://finance.yahoo.com/q?s=" + symbol + "&ql=0";
            this.url = url;
            Document doc = Jsoup.connect(url).get();
            Elements css = doc.select("p > span:first-child > span");
            return css.text();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}