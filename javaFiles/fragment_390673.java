public class PersistenceLayer {
    private Object object;

    void write(Object object) {
        this.object = object;
    }

    Object read(Long id) {
        return object;
    }
}