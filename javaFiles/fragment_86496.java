public void displayRootSelection(Consumer<String> callback){//EDIT, usage see below
    Stage window = new Stage();
    currentWindow = window;
    Main.setRootInSelection(true);
    try {
        BorderPane root = ...;
        /*...*/
        window.showAndWait();
        // When the code reaches this position, your modal window is closed
        String tempId = AreaManagement.getTempAreaId();
        // You can call just about anything here
        callback.accept(tempId);
    } catch (IOException e) {
        e.printStackTrace();
    }
}