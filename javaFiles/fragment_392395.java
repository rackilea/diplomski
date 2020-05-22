public static Stream<FlightInfo> getResults(String origin,List<String> destinations)  {
    final String uri = "https://api.searchflight.com/";
    return destinations.stream().map(destination -> {
        RestTemplate restTemplate = new RestTemplate();
        String params = getParams(origin,destination);
        FlightInfo result = restTemplate.postForObject(uri+params,FlightInfo.class);
        return result;
    })    
}