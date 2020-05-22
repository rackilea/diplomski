public <T> List<T> removeDuplicate(List<T> dataList, Function<? super T, ?> keyFunction, BinaryOperator<T> chooser) {
    return
            new ArrayList<>(dataList.stream()
                    .collect(Collectors.toMap(keyFunction,
                                              Function.identity(),
                                              chooser))
                    .values());
}