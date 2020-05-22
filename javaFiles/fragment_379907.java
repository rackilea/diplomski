import java.util.Stack;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Executor {

    /**
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        int NumberOfThreads = Integer.parseInt("10");

        ExecutorService executor = Executors.newFixedThreadPool(NumberOfThreads);
        while (true) {

            Stack<Job> jobStack = MrMestri.buildJobs();
            int jobToken = 0;
            while (true) {
                if (jobStack.size() > 0) {
                    jobToken++;
                    MrRunnable worker = new MrRunnable(jobStack.pop());
                    executor.execute(worker);
                    if (jobToken % Integer.parseInt("4") == 0) {
                        // executor.shutdown();
                        System.out.println("short waiting...");
                        Thread.sleep(2000);

                    }
                } else {
                    System.out.println("long waiting...");
                    Thread.sleep(10000);
                    break;
                }
            }
        }
    }
}

class MrMestri {

    public static Stack<Job> buildJobs() {
        Stack<Job> stack = new Stack<Job>();
        stack.push(new Job("A"));
        stack.push(new Job("B"));
        stack.push(new Job("C"));
        stack.push(new Job("D"));
        stack.push(new Job("E"));
        stack.push(new Job("F"));
        return stack;
    }

}

class MrRunnable implements Runnable {
    private Job job;

    public MrRunnable(Job j) {
        job = j;
    }

    @Override
    public void run() {
        System.out.println(job.getName());
    }
}

class Job {
    private String name;

    public Job(String n) {
        name = n;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}