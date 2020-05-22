interface QueueTaskAble {
    Runnable getQueueTask();
}

class InputObjectFooQueueTask implements Runnable {
    @Override
    public void run() {
        // TODO Auto-generated method stub            
    }
}

class InputObjectFooImpl implements QueueTaskAble {
    @Override
    public Runnable getQueueTask() {
        return new InputObjectFooQueueTask();
    }
}

void processQueueInputObject(QueueTaskAble queueObject) {
    queueObject.getQueueTask().run();
}