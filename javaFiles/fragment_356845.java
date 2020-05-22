final ImageView imageViewObj = new ImageView();
Task<Void> task = new Task<Void>() {
    @Override protected Void call() throws Exception {
        //Some Operations are carried out
        //..

        //Then I want to set Image in ImageView
        // use Platform.runLater()
        Platform.runLater(() -> imageViewObj.setImage(myImage));

        // Some Code Here
        //..

        // Set Progress
        updateProgress(0.1, 1);

        // Some Code Here
        //..

        // Set Progress
        updateProgress(0.2, 1);

        int variable = 2;
        final int immutable = variable;

        // Maybe change some other Controls
        // run whatever block that updates the controls within a Platform.runLater block.
        Platform.runLater(() -> {
            // execute the control update logic here...
            // be careful of updating control state based upon mutable data in the task thread.
            // instead only use immutable data within the runLater block (avoids race conditions).
        });

        variable++;

        // some more logic related to the changing variable.

        return null;
    }
};

ProgressBar updProg = new ProgressBar();
updProg.progressProperty().bind(task.progressProperty());

Thread thread = new Thread(task, "my-important-stuff-thread");
thread.setDaemon(true);
thread.start();