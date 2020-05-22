public class Taskee extends Task<Void>{

    private Stage stage;

    public Taskee() {
        setOnSucceeded(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent event) {
                if (stage != null) {
                    stage.hide();
                }
            }
        });
    }
    @Override
    protected Void call() throws Exception {
        for(int i=0;i<10;i++){
            //@DoSomething()
            for(long l=0;l<10000;l++);
            System.out.println("i=" + i);
        }
        return null;
    }
    public Stage getStage() {
        return stage;
    }
    public void setStage(Stage stage) {
        this.stage = stage;
    }
}