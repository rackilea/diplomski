final Runnable swingTask = new Runnable() {
    public void run() {
        UI.init();
        UI.buildJTree(xml);
    }
};
if (EventQueue.isDispatchThread()) {
    swingTask.run();
} else {
    EventQueue.invokeAndWait(swingTask);
}