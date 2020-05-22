public List<SummaryResult> toSummaryResultList(Map<String, Integer> resultMap) {
  List<SummaryResult> list = new ArrayList<>(resultMap.size());
  for (Map.Entry<String, Integer> entry : resultMap.entrySet()) {
    String name = entry.getKey();
    Integer value = entry.getValue();

    // replace below with construction method you actually have
    list.add(SummaryResult.withName(name).andResult(value));
  }
  return list;
}