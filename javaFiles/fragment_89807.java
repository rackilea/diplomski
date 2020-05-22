@Override
public void connectionCreatedEvent(Connection connection) {
    try {
        ConnectionTab tab = new ConnectionTab();
        //...

        Platform.runLater(() -> {
            tabPane.getTabs().add(tab);
            tabPane.getSelectionModel().select(tab);
        });
        connectionTabs.put(connection, tab);
    } catch (IOException e) {
        e.printStackTrace();
    }
}