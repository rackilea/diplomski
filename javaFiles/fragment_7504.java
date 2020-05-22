task.setOnSucceeded(event -> {});
task.setOnCancelled(event -> {});
task.setOnFailed(event -> {});

// or even something like
task.addEventHandler(WorkerStateEvent.ANY, event -> {
    // Test event type and do something as needed...
});