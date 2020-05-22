/**
 * Dispose the contents of the OpenHashSet by suppressing non-fatal
 * Throwables till the end.
 * @param set the OpenHashSet to dispose elements of
 */
void dispose(OpenHashSet<Disposable> set) {
    if (set == null) {
        return;
    }
    List<Throwable> errors = null;
    Object[] array = set.keys();
    for (Object o : array) {
        if (o instanceof Disposable) {
            try {
                ((Disposable) o).dispose();
            } catch (Throwable ex) {
                Exceptions.throwIfFatal(ex);
                if (errors == null) {
                    errors = new ArrayList<Throwable>();
                }
                errors.add(ex);
            }
        }
    }
    if (errors != null) {
        if (errors.size() == 1) {
            throw ExceptionHelper.wrapOrThrow(errors.get(0));
        }
        throw new CompositeException(errors);
    }
}