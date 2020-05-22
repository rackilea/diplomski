/**
 * Creates a new unsorted {@link PageRequest}.
 *
 * @param page zero-based page index.
 * @param size the size of the page to be returned.
 * @since 2.0
 */
public static PageRequest of(int page, int size) {
    return of(page, size, Sort.unsorted());
}