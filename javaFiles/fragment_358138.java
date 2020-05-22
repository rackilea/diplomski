@FXML
    void initialize () {
        assert bar != null : "fx:id=\"bar\" was not injected: check your FXML file 'Check.fxml'.";
        loadAppConfigurationFile();
    }

    private void loadAppConfigurationFile () {
        Task task = new Task<Void>() {
            @Override
            public Void call() throws InterruptedException {
                int max = 1000000;
                for (int i = 1; i <= max; i = i + 10) {
                    if (isCancelled()) {
                        break;
                    }
                    updateProgress(i, max);
                    System.out.println("somethings is here");
                }
                return null;
            }
        };
        bar.progressProperty().bind(task.progressProperty());
        new Thread(task).start();
    }