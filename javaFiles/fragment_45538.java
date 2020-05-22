AtomicInteger dataIndex = new AtomicInteger();
final List<DataIndex> indexData = fusionedData.values().stream()
    .flatMap(models-> models.values().stream()) // Stream<ModelList>
    .map(ModelList::getIds)
    .map(ids -> new DataIndex(dataIndex.incrementAndGet(), ids))
    .collect(Collectors.toList());