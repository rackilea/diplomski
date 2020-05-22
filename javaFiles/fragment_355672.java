private List<HighWay> getWillSave(List<HighWay> total, HighWayRepository repository) {
    List<HighWay> willSave = new ArrayList<HighWay>();
    int size = total.size();
    int index = 
        IntStream.range(0,size)
            .mapToObj(i -> new Pair<>(i,size - i - 1))
            .filter(p -> !repository.exists(p.getValue().getId()))
            .findFirst()
            .orElseGet(() -> new Pair<>(0,null)).getKey();
    return total.subList(0,index);
}