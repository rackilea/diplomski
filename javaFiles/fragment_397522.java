BloombergSession session = new DefaultBloombergSession();
 LocalDate now = LocalDate.now();
 RequestBuilder<HistoricalData> hrb = new HistoricalRequestBuilder("S X5 Comdty",
                          Arrays.asList("PX_LAST", "OPEN"),
                          now.minusDays(7), now);

 HistoricalData result = session.submit(hrb).get();
 Map<LocalDate, TypedObject> data = result.forSecurity("SPX Index").forField("PX_LAST").get();
 for (Map.Entry<LocalDate, TypedObject> e : data.entrySet()) {
     LocalDate dt = e.getKey();
     double price = e.getValue().asDouble();
     System.out.println("[" + dt + "] " + price);
 }