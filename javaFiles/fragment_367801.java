response.getFirstNodes().stream()
  .flatMap(first->first.getSndNodes().stream()
     .filter(snd->snd.isValid())
     .map(snd->new AbstractMap.SimpleImmutableEntry<>(first, snd)))
  .findFirst().ifPresent(e-> {
    result.setKey(e.getKey().getKey());
    result.setContent(e.getValue().getContent());
  });