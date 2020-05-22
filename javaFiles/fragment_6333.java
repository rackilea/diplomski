public class InputObjectGsonQueue {

    private Queue<String> queue = new ArrayDeque<>();

    public boolean pushInputObject(String json) {
        return queue.offer(json);
    }

    public void processQueue() {
        InputObjectGsonBuilder gb = new InputObjectGsonBuilder();
        String json;
        while(null != (json = queue.poll())) {
            QueueTaskAble queueTaskAble = gb.create().fromJson(json,
                               QueueTaskAble.class);
            processQueueInputObject(queueTaskAble);
        }
    }

    private void processQueueInputObject(QueueTaskAble queueObject) {
        queueObject.getQueueTask().run();
        // or for asynchronous processing
        // new Thread(queueObject.getQueueTask()).start();
    }
}