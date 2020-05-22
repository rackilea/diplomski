public class Foo {
    public static void runTask(Runnable task) throws InterruptedException {
        task.run();
        if (Thread.interrupted()) throw new InterruptedException();
    }
    Runnable[] frobnicateTasks = new Runnable[] {
        () -> { System.out.println("task1"); },
        () -> { Thread.currentThread().interrupt(); }, //Interrupt self only as example
        () -> { System.out.println("task2"); }
    };
    public int frobnicate() {
        return resumeFrobnicate(0);
    }
    public int resumeFrobnicate(int taskPos) {
        try {
            while (taskPos < frobnicateTasks.length)
                runTask(frobnicateTasks[taskPos++]);
        } catch (InterruptedException ex) {
        }
        if (taskPos == frobnicateTasks.length) {
            return -1; //done
        }
        return taskPos;
    }
    public static void main(String[] args) {
        Foo foo = new Foo();
        int progress = foo.frobnicate();
        while (progress != -1) {
            System.out.println("Paused");
            progress = foo.resumeFrobnicate(progress);
        }
        System.out.println("Done");
    }
}
-->
task1
Paused
task2
Done