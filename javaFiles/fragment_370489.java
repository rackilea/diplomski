public static void mainTabLoader() {
FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("main_overview_tab.fxml"));
    // fxmlLoader.setRoot(content);
    // fxmlLoader.setController(this);      

    try {
        fxmlLoader.load();
    } catch (Exception e) {
        e.printStackTrace();
    }