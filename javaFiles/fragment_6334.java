public class InputObjectFooImpl implements QueueTaskAble {
    @Override
    public Runnable getQueueTask() {
        return new InputObjectFooTaksImpl();
    }
}

public class InputObjectBarImpl implements QueueTaskAble {
    @Override
    public Runnable getQueueTask() {
        return new InputObjectBarTaksImpl();
    }
}

public class InputObjectFooTaksImpl implements Runnable {
    @Override
    public void run() {
        System.out.println("Foo!");
    }
}

public class InputObjectBarTaksImpl implements Runnable {
    @Override
    public void run() {
        System.out.println("Bar!");
    }
}