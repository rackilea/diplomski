source.flatMap(item ->
        locationProvider
                .getLastKnownLocation()
                .map(location -> new ItemWithLocation<>(item, location))
);

class ItemWithLocation<T> {
    private final T item;
    private final Location location;

    public ItemWithLocation(T item, Location location) {
        this.item = item;
        this.location = location;
    }

    public T getItem() {
        return item;
    }

    public Location getLocation() {
        return location;
    }
}