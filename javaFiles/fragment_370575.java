Pageable pageRequest = new PageRequest(0, 10);
Page<Website> result = elasticSearchTemplate.query(searchQuery, new ResultsExtractor<Page<Website>>() {
    @Override
    public Page<Website> extract(SearchResponse response) {
        List<Website> content = new ArrayList<>();
        SearchHit[] hits = response.getHits().getHits();
        for (SearchHit hit : hits) {
            Website website = entityMapper.mapToObject(hit, Website.class);
            content.add(website);
            float documentScore = hit.getScore(); // <---- score of a hit
        }
        return new PageImpl<Website>(content, pageRequest, response.getHits().getTotalHits());
    }
});