public ServiceCall<NotUsed, Source<GreetingMessage, ?>> getGreetings() {
    return request ->
         CompletableFuture.completedFuture(
              session.select("SELECT * FROM greetings")
                     .map(row -> new GreetingMessage(row.getString(0)))
          );
 }