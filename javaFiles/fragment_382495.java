public CompletionStage<Result> getSites() {
    ObjectNode hosts = Json.newObject();
    return ws.url("https://www.facebook.com").get()
            .thenCompose(res ->  {
                hosts.put("facebook", res.getStatus());
                return ws.url("https://www.google.com").get();
            })
            .thenCompose(res -> {
                hosts.put("google", res.getStatus());
                return ws.url("https://www.twitter.com").get();
            })
            .thenApply(res -> {
                hosts.put("twitter", res.getStatus());
                return ok(hosts);
            });
    }