response.getFirstNodes().stream()
  .flatMap(first->first.getSndNodes().stream()
    .map(snd->new AbstractMap.SimpleImmutableEntry<>(first, snd)))
  .filter(e->e.getValue().isValid())
  .findFirst().ifPresent(e-> {
    result.setKey(e.getKey().getKey());
    result.setContent(e.getValue().getContent());
  });