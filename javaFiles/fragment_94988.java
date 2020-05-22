/**
 * Searches for all children of the given component which are instances of the given class.
 *
 * @param aRoot start object for search.
 * @param aClass class to search.
 * @param <E> class of component.
 * @return list of all children of the given component which are instances of the given class. Never null.
 */
public static <E> List<E> getAllChildrenOfClass(Container aRoot, Class<E> aClass) {
    final List<E> result = new ArrayList<>();
    final Component[] children = aRoot.getComponents();
    for (final Component c : children) {
        if (aClass.isInstance(c)) {
            result.add(aClass.cast(c));
        }
        if (c instanceof Container) {
            result.addAll(getAllChildrenOfClass((Container) c, aClass));
        }
    }
    return result;
}