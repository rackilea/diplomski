public static void display(String prog, String progPath){
    Stage primaryStage=new Stage();

    primaryStage.setTitle("Please Wait");
    primaryStage.setMinWidth(350);

    ProgressIndicator indicator = new ProgressIndicator();

    Label label1=new Label();
    label1.setText("Please wait for "+prog+" to finish...");

    HBox layout=new HBox(20);
    layout.getChildren().addAll(indicator, label1);
    layout.setAlignment(Pos.CENTER);
    layout.setPadding(new Insets(20,20,20,20));

    Scene scene =new Scene(layout);
    primaryStage.setScene(scene);
    primaryStage.show();

    Task<Void> task = new Task<Void>() {
        @Override
        public Void call() throws Exception {

            try {
                Process p = Runtime.getRuntime().exec(progPath);
                p.waitFor();        
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
            return null;
    };

    task.setOnSucceeded(e -> primaryStage.close());

    Thread thread = new Thread(task);
    thread.setDaemon(true); // thread will not prevent application from exiting
    thread.start();
}