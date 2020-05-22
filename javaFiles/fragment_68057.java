import junit.framework.Assert;

import org.junit.Test;

public class TestScheduler {
    private static class Task implements Runnable {
        public boolean didRun = false;
        public void run() {
            didRun = true;
        }       
    }
    Runnable fail = new Runnable() {
        @Override
        public void run() {
            Assert.fail();
        }
    };

    @Test
    public void queue() {
        Scheduler scheduler = new Scheduler();
        Task task = new Task();
        scheduler.addTask(task, 0);
        scheduler.addTask(fail, 1);
        Assert.assertFalse(task.didRun);
        scheduler.executeNextInterval();
        Assert.assertTrue(task.didRun);
    }
    @Test
    public void queueWithGaps() {
        Scheduler scheduler = new Scheduler();
        scheduler.addTask(fail, 1);
        scheduler.executeNextInterval();
    }
    @Test
    public void queueLonger() {
        Scheduler scheduler = new Scheduler();
        Task task0 = new Task();
        scheduler.addTask(task0, 1);
        Task task1 = new Task();
        scheduler.addTask(task1, 1);
        scheduler.addTask(fail, 2);
        scheduler.executeNextInterval();
        scheduler.executeNextInterval();
        Assert.assertTrue(task0.didRun);
        Assert.assertTrue(task1.didRun);
    }
}