public class App {
    public static void main(String... args) {
        InputObjectGsonBuilder gb = new InputObjectGsonBuilder();

        InputObjectGsonQueue gq = new InputObjectGsonQueue();
        gq.pushInputObject(gb.create().toJson(new InputObjectFooImpl(), 
                    QueueTaskAble.class));
        gq.pushInputObject(gb.create().toJson(new InputObjectBarImpl(), 
                    QueueTaskAble.class));

        gq.processQueue();
    }
}