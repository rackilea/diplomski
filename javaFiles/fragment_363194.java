Map<Date, Map<String, Long>> result = new LinkedHashMap<>();
for(Foo fr : data) {
    Map<String, Long> inner
      = result.computeIfAbsent(fr.getDate(), date -> new LinkedHashMap<>());
    inner.merge(inner.size() >= 25 && !inner.containsKey(fr.getAirlineName())?
      "Other": fr.getAirlineName(), fr.getNumbers(), Long::sum);
}