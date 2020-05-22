RequestBuilder<IntradayTickData> tickRequest =
    new IntradayTickRequestBuilder("SPX Index",
        DateTime.now().minusHours(2),
        DateTime.now());

RequestBuilder<IntradayBarData> barRequest =
    new IntradayBarRequestBuilder("SPX Index",
        DateTime.now().minusHours(2),
        DateTime.now())
        .period(5, TimeUnit.MINUTES);

RequestBuilder<ReferenceData> refRequest =
    new ReferenceRequestBuilder("SPX Index", "NAME");

Future<IntradayTickData> ticks = session.submit(tickRequest);
Future<IntradayBarData> bars = session.submit(barRequest);
Future<ReferenceData> name = session.submit(refRequest);