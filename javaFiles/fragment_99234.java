@FXML
    void openWithAction(ActionEvent event) {
        boolean flag = false;
        Task task = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                try {
                    Desktop.getDesktop().open(new File(fileModel.getFileLocation()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }
        };
        new Thread(task).start();
    }