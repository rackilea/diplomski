Platform.runLater(new Runnable() {
    @Override
    public void run() {
        Pane root = ...; //if you set any properties of the pane, do it here.
        dashBoardController.addToDashBoard(root);
    }
}