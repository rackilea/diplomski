public static String addTask(String taskText, Double progress) {
    //TODO: do Add Task Logic here
    long longTaskId = System.currentTimeMillis(); //Define TaskID
    String taskId = ""+longTaskId;

    Platform.runLater(() -> {

        Label lblTaskEntry = new Label();
        lblTaskEntry.setText(taskText);
        lblTaskEntry.getStyleClass().add("TaskEntryLabel");
        lblTaskEntry.setId(taskId + "Label");

        Separator separatorTasks = new Separator();
        separatorTasks.setPrefWidth(230);

        ProgressIndicator piTaskEntry = new ProgressIndicator();
        piTaskEntry.getStyleClass().add("TaskEntryProgressIndicator");
        piTaskEntry.setId(taskId + "ProgressIndicator");
        if (progress != 0){
            piTaskEntry.setProgress(progress);
            piTaskEntry.setMaxSize(55, 55); // set maxsize of Progress Indicator if he has progress > 0 and Determinate
        }else {
            piTaskEntry.setMaxSize(35,35);//set maxsize for Progress Indicator if he has state of Indeterminate
        }

        HBox hBoxProgressPaneInnerTaskEntry = new HBox();
        hBoxProgressPaneInnerTaskEntry.setAlignment(Pos.CENTER_LEFT);
        hBoxProgressPaneInnerTaskEntry.setId(taskId + "Hbox");
        hBoxProgressPaneInnerTaskEntry.getChildren().addAll(piTaskEntry, lblTaskEntry);
        vBoxProgressPaneInner.getChildren().add(0, separatorTasks);
        vBoxProgressPaneInner.getChildren().add(1, hBoxProgressPaneInnerTaskEntry);
    });

    return taskId;
}