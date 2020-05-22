Set<String> keywords = Set.of("foo", "bar", "baz");
List<String> words = Arrays.asList(event.getMessage().getContentRaw().split("\\s+"));

if (!Collections.disjoint(keywords, words)) {
  event.getMessage().addReaction("").queue();
}