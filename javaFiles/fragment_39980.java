ParseQueryAdapter<ParseObject> adapter =
  new ParseQueryAdapter<ParseObject>(this, new ParseQueryAdapter.QueryFactory<ParseObject>() {
    public ParseQuery<ParseObject> create() {
      // Here we can configure a ParseQuery to our heart's desire.
      ParseQuery query = new ParseQuery("Band");
      query.whereContainedIn("genre", Arrays.asList({ "Punk", "Metal" }));
      query.whereGreaterThanOrEqualTo("memberCount", 4);
      query.orderByDescending("albumsSoldCount");
      query.setCachePolicy(ParseQuery.CachePolicy.CACHE_ELSE_NETWORK)
      return query;
    }
  });