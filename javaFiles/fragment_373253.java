/**
 * Used to send message updates in a thread-safe manner from the subclass
 * to the FX application thread. AtomicReference is used so as to coalesce
 * updates such that we don't flood the event queue.
 */
private AtomicReference<String> messageUpdate = new AtomicReference<>();

private final StringProperty message = new SimpleStringProperty(this, "message", "");
@Override public final String getMessage() { checkThread(); return message.get(); }
@Override public final ReadOnlyStringProperty messageProperty() { checkThread(); return message; }

/**
 * Updates the <code>message</code> property. Calls to updateMessage
 * are coalesced and run later on the FX application thread, so calls
 * to updateMessage, even from the FX Application thread, may not
 * necessarily result in immediate updates to this property, and
 * intermediate message values may be coalesced to save on event
 * notifications.
 * <p>
 *     <em>This method is safe to be called from any thread.</em>
 * </p>
 *
 * @param message the new message
 */
protected void updateMessage(String message) {
    if (isFxApplicationThread()) {
        this.message.set(message);
    } else {
        // As with the workDone, it might be that the background thread
        // will update this message quite frequently, and we need
        // to throttle the updates so as not to completely clobber
        // the event dispatching system.
        if (messageUpdate.getAndSet(message) == null) {
            runLater(new Runnable() {
                @Override public void run() {
                    final String message = messageUpdate.getAndSet(null);
                    Task.this.message.set(message);
                }
            });
        }
    }
}

private void checkThread() {
    if (started && !isFxApplicationThread()) {
        throw new IllegalStateException("Task must only be used from the FX Application Thread");
    }
}