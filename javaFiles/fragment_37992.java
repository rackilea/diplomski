/**
 * Accessor method to retrieve a random element from this ArrayBag and will
 * remove the grabbed element from the ArrayBag
 *
 * @return A randomly selected element from this ArrayBag
 * @throws java.lang.IllegalStateException Indicated that the ArrayBag is
 * empty
 */
public E grab() {
    int i;
    E n;

    if (items == 0) {
        throw new IllegalStateException("ArrayBag size is empty");
    }

    i = (int) (Math.random() * items + 1);

    n = elementArray[i - 1];

    remove(n);

    trimToSize();

    return n
}