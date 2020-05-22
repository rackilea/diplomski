Map<Class, List<?>> repo =new HashMap<>();

public <T> List<T> get(Class<T> c){
    return Optional.ofNullable((List<T>)repo.get(c)).orElse(new ArrayList<>());
}

public <T> void put(Class<T> c,List<T> l){
    repo.put(c, l);
}

public <T> List<T> find(Class<T> c, Predicate<T> predicate){
    return get(c).stream().filter(predicate).collect(Collectors.toList());
}