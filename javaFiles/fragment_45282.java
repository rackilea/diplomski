public class MapDbPersistentStorage<V> {
    private DB db;
    private HTreeMap<String, V> storage;
    private final Serializer ser;

    public MapDbPersistentStorage(GenericSerializer<V> serFactory) {
        this.ser = serFactory.get();
    }

    public MapDbPersistentStorage(String filename) {
        db = DBMaker
                .fileDB(filename)
                .fileMmapEnable()
                .make();

        storage = (HTreeMap<String, V>) db
                .hashMap("section", Serializer.STRING, ser)
                .createOrOpen();
    }

    ...
}