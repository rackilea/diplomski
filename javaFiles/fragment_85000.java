private void analyze() {
    Task<Void> task = new Task<Void>() {
        public Void call() {
            updateMessage("Analyzing");
            // time consuming task here
            updateMessage("Analysis complete");
        }
    };
    labelString.bind(task.messageProperty());
    new Thread(task).start();
}