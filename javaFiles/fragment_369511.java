BloombergSession session = new DefaultBloombergSession();
session.start();

RequestBuilder<HistoricalData> hrb = new HistoricalRequestBuilder("SPX Index",
     "PX_LAST", DateTime.now().minusDays(7),
     DateTime.now())
     .fill(HistoricalRequestBuilder.Fill.NIL_VALUE)
     .days(HistoricalRequestBuilder.Days.ALL_CALENDAR_DAYS);
HistoricalData result = session.submit(hrb).get();
Map<DateTime, TypedObject> data = result.forSecurity("SPX Index").forField("PX_LAST").get();
for (Map.Entry<DateTime, TypedObject> e : data.entrySet()) {
    DateTime dt = e.getKey();
    double price = e.getValue().asDouble();
    System.out.println("[" + dt + "] " + price);
}