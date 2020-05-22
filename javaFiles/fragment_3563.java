CountDownLatch done = new CountDownLatch(1);
target.onJobComplete(new Runnable() { public void run() {
    done.countdown();
}});
Scheduler sched = (Scheduler) Whitebox.getInternalState(target, "scheduler");
done.await(timeout);