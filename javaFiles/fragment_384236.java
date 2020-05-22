public ListView<String> lvGroup;
    private ExecutorService threadPool;



    private void OpenDbClick(ActionEvent event) {
        Task<Void> task = new Task<Void>() {

            @Override
            protected Void call() throws Exception {
                System.out.println("open db");
                final ObservableList<String> ol = WeddingGuestList.DatabaseConn.getGroups();
                Platform.runLater(new Runnable() {

                    @Override
                    public void run() {
                        lvGroup.setItems(ol);
                    }
                }); 
                return null;
            }
        };
        getPool().execute(task); 
    }

    private ExecutorService getPool() {
        if (threadPool == null) {
            threadPool = Executors.newCachedThreadPool();
        }
        return threadPool;
    }
}