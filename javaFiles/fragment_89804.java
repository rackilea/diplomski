try {
    Tab tab = new Tab();
    //...
    FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/connectionTab.fxml"));
    tab.setContent(loader.load());

    ConnectionTabController controller = loader.getController();

    // ...
}