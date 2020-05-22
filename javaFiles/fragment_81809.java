/*
 * (non-Javadoc)
 * @see java.util.function.Supplier#get()
 */
default Stream<T> get() {
    return stream();
}