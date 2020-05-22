Stream<Class<?>> stream = Stream.of(ArrayList.class);

Map<Class<?>, List<Class<?>>> map = stream.collect(
    Collectors.toMap(
        Class::getSuperclass,
        Collections::singletonList,
        (List<Class<?>> oldList, List<Class<?>> newEl) -> {
        List<Class<?>> newList = new ArrayList<>(oldList.size() + 1);
        newList.addAll(oldList);
        newList.addAll(newEl);
        return newList;
        }));