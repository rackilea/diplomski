public abstract class InternalFrame<T> {

    protected abstract Collection<? extends T> getElements();

    protected abstract Serializable getRecord(final T t);

    public void serialize(final File file) {
        try (final ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            for(final T t : getElements()) {
                oos.writeObject(getRecord(t));
            }
        } catch (IOException ex) {
            //handle
        }
    }
}