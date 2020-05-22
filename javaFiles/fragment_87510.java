public final class Poo implements Serializable {
    private volatile boolean invalid = false;
    public String getInfo() {
         synchronized (this) {
             if (invalid) {
                 throw new IllegalStateException("Object shouldn't be used until deserialized");
             }
         }
         // do something
    }

    // do the same to other methods
    // if necessary Object methods like equals and hashCode too

    private class SerializationProxy implements Serializable {
        private Object readResolve() {
            Poo.this.invalid = false;
            return Poo.this;
        }
    }

    private synchronized Object writeReplace() {
        invalid = true;
        return new SerializationProxy();
    }
}