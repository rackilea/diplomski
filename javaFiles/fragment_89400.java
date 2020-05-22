public Set<Source> getSources(String searchText) {

  Set<String> urls = this.crawlerService.getUrls(searchText);

  return urls.stream()
             .map(e -> Source.builder().url(e).build())
             .collect(Collectors.toSet());
}