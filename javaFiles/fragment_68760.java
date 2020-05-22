public void login(ActionEvent event) {
    Task task = new javafx.concurrent.Task<Void>() {

        @Override
        protected Void call() throws Exception  {
            if(Compte.login(username.getText(), password.getText())) {
                System.err.println("It's okey");
            } else {
                //TODO
            }
            return null;
        }

        @Override
        protected void succeeded() {
            loader.setVisible(false);
        }

        @Override
        protected void failed() {
            loader.setVisible(false);
        }

    };
    Thread thread = new Thread(task, "My Task");
    thread.setDaemon(true);
    loader.setVisible(true);
    thread.start();
}