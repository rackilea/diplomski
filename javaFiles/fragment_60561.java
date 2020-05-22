myTask.setOnSucceeded(new EventHandler<WorkerStateEvent>() {

    @SuppressWarnings("unchecked")
    @Override
    public void handle(WorkerStateEvent event) {
        ReturnType rt =  (ReturnType) event.getSource().getValue()
        // ... other stuff to do here ...
    }
});