**Main.java**

Timeline TimerTaskExec = new Timeline(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {

@Override
public void handle(ActionEvent event) {

    count++;

    if(count==30){
        // do the task
        stage.close();
    }

}

}));

TimerTaskExec.setCycleCount(Timeline.INDEFINITE);
TimerTaskExec.play();