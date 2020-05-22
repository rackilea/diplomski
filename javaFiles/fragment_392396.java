public static CompletableFuture<List<FlightInfo>> getResults(String origin,List<String> destinations)  {
    final String uri = "https://api.searchflight.com/";
    List<CompletableFuture<FlightInfo>> collect = destinations
           .stream()
           .map(destination -> CompletableFuture.supplyAsync(() -> {
                 RestTemplate restTemplate = new RestTemplate();
                 String params = getParams(origin,destination);
                 FlightInfo result = restTemplate.postForObject(uri+params,FlightInfo.class);
                 return result;            
           })).collect(Collectors.toList());
    return sequence(collect);       //line-1 
}

public static <T> CompletableFuture<List<T>> sequence(List<CompletableFuture<T>> com) {
    return CompletableFuture.allOf(com.toArray(new CompletableFuture[com.size()]))
            .thenApply(v -> com.stream()
                            .map(CompletableFuture::join)
                            .collect(Collectors.toList())
            );
}