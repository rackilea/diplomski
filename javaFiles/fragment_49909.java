public static PaginatedResult<Track> getRecentTracks(String user, int page, 
    int limit, String apiKey, int from, int to) {
    Map<String, String> params = new HashMap<String, String>();
    params.put("user", user);
    params.put("limit", String.valueOf(limit));
    params.put("page", String.valueOf(page));
    params.put("from", String.valueOf(from));
    params.put("to", String.valueOf(to));
    Result result = Caller.getInstance().call("user.getRecentTracks", apiKey, params);
    return ResponseBuilder.buildPaginatedResult(result, Track.class);
}