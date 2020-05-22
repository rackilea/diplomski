class ReadHashMap implements Runnable {

    Semaphore sem;
    String name;
    Shared shared;

    ReadHashMap(Semaphore sem, String name, Shared shared) {
        this.sem = sem;
        this.name = name;
        this.shared = shared;
        new Thread(this, name).start();
    }
    ....
}

class WriteData implements Runnable {

    Semaphore sem;
    String name;
    Shared shared;

    WriteData(Semaphore sem, String name, Shared shared) {
        this.sem = sem;
        this.name = name;
        this.shared = shared;
        new Thread(this, name).start();
    }

    ....
}

public class SemaphoreDemo {
    public static void main(String args[]) {
        Semaphore sem = new Semaphore(1);
        Shared shared = new Shared();

        new WriteData(sem, "write", shared);
        new ReadHashMap(sem, "read", shared);
    }
}