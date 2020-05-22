public static void main(String[] args) throws IOException {
        Document doc = Jsoup.connect("http://www.myfxbook.com/forex-market/currencies/GBPUSD-historical-data").get();

        Element table = doc.getElementById("symbolMarket");

        List<Entry> entries = new ArrayList<Entry>();

        Elements elements = table.select("tr");
        Iterator<Element> itr = elements.iterator();
        itr.next(); //skip header data

        while ( itr.hasNext() ) {
            int index = 0;
            Entry tableEntry = new Entry();
            Elements data = itr.next().select("td");

            tableEntry.setDate(data.get(index++).text());
            tableEntry.setOpen(data.get(index++).text());
            tableEntry.setHigh(data.get(index++).text());
            tableEntry.setLow(data.get(index++).text());
            tableEntry.setClose(data.get(index++).text());
            tableEntry.setChangePips(data.get(index++).text());
            tableEntry.setChangePercent(data.get(index++).text());
            entries.add(tableEntry);

        }       




    }