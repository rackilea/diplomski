return getUser(userId).flatMap(user -> {
    Observable<Map<String, Object>> catalog = getPersonalizedCatalog(user)
            .flatMap(catalogList -> catalogList.videos().<Map<String, Object>> flatMap(
                    video -> {
                        Observable<Bookmark> bookmark = getBookmark(video);
                        Observable<Rating> rating = getRatings(video);
                        Observable<VideoMetadata> metadata = getVideoMetadata(video);
                        return Observable.zip(bookmark, rating, metadata, (b, r, m) -> combineVideoData(video, b, r, m));
                    }));

    Observable<Map<String, Object>> social = getSocial(user).map(s -> {
        return s.getDataAsMap();
    });

    return Observable.merge(catalog, social);
}).flatMap(data -> {
    String json = SimpleJson.mapToJson(data);
    return response.writeStringAndFlush("data: " + json + "\n");
});