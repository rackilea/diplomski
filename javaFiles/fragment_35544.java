public class CFRunnableComparator implements Comparator<Runnable> {

    @Override
    @SuppressWarnings("unchecked")
    public int compare(Runnable r1, Runnable r2) {
        // T might be AsyncSupply, UniApply, etc., but we want to
        // compare our original Runnables.
        return ((Comparable) unwrap(r1)).compareTo(unwrap(r2));
    }

    private Object unwrap(Runnable r) {
        try {
            Field field = r.getClass().getDeclaredField("fn");
            field.setAccessible(true);
            // NB: For performance-intensive contexts, you may want to
            // cache these in a ConcurrentHashMap<Class<?>, Field>.
            return field.get(r);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            throw new IllegalArgumentException("Couldn't unwrap " + r, e);
        }
    }
}