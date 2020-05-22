public class InputObjectGsonBuilder {
    private final static GsonBuilder gb;
    static {
        gb = new GsonBuilder();
        gb.registerTypeAdapter(QueueTaskAble.class,
                    new GenericGsonTypeAdapter<QueueTaskAble>());
    }

    public Gson create() {
        return gb.create();
    }
}