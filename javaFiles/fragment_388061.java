Map<Function<? super MyObject, ? extends String>, Consumer<? super String>> map = new HashMap<>();
map.put(MyObject::getF1, bar::setF1);
map.put(MyObject::getF2, bar::setF2);
map.put(MyObject::getF10, bar::setF10);
// ...

map.forEach((function, consumer) -> {
        Optional.of(bar).map(function).map(this::replaced).ifPresent(consumer);
});