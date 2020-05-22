public interface Predicate<T> {
    boolean matches(T obj);
}
...
public List<Entity> get(Predicate<Entity> filter) {
    List<Entity> filtered = new ArrayList<>();
    for (Entity obj : ...blah...) {
        if (filter.matches(obj)) {
            filtered.add(obj);
         }
    }
    return filtered;
}