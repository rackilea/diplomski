import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
public final class Enumerations {

    /**
     * Allows using of {@link Enumeration} with the for-each statement. The
     * implementation is not using any heap space and such is able to serve
     * virtually endless Enumerations, while {@link Collections#list} is limited
     * by available RAM. As a result, this implementation is much faster than
     * Collections.list.
     * 
     * @param enumeration
     *            The original enumeration.
     * @return An {@link Iterable} directly calling the original Enumeration.
     */
    public static final <T> Iterable<T> iterable(final Enumeration<T> enumeration) {
        return new Iterable<T>() {
            public final Iterator<T> iterator() {
                return new Iterator<T>() {
                    public final boolean hasNext() {
                        return enumeration.hasMoreElements();
                    }

                    public final T next() {
                        return enumeration.nextElement();
                    }

                    /**
                     * This method is not implemeted as it is impossible to
                     * remove something from an Enumeration.
                     * 
                     * @throws UnsupportedOperationException
                     *             always.
                     */
                    public final void remove() {
                        throw new UnsupportedOperationException();
                    }
                };
            }
        };
    }

}