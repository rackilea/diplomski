class Attribute<T extends Enum<T>> {
    final T value;

    Attribute(T value) {
        this.value = value;
    }
}