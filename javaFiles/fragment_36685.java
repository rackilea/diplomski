public static Promise<Result> selectFeed() {

      F.Promise<WS.Response> response1 = WS.url(<firstUrl>).get();
      F.Promise<WS.Response> response2 = WS.url(<SecondUrl>).get();
      F.Promise<List<WS.Response>> responses = F.Promise.sequence(response1, response2);

     F.Promise<Result> resultPromise= responses.map(new F.Function<List<WS.Response>,Result>()     {

            @Override
            public Result apply(List<WS.Response>  o) throws Throwable {

                //some code;
                String s= o.get(0).asJson().toString();


                String s2 = o.get(1).asJson().toString();
                return ok(s+s2);
            }
        });

    return resultPromise;
   }