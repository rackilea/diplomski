final CountDownLatch latch = new CountDownLatch(works.size());
WorkListener listener = new WorkListener() {
    public void workAccepted(WorkEvent we) {}
    public void workStarted(WorkEvent we) {}
    public void workCompleted(WorkEvent we) {
        latch.countDown();
    }
    public void workRejected(WorkEvent we) {
        latch.countDown();
    }
};
for (Work work : works) {
    workItems.add(wm.startWork(work, WorkManager.INDEFINITE, listener));
}
latch.await();