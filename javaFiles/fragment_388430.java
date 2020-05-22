public void setMainApp(MainApp mainApp) {
    this.mainApp = mainApp;
    tableView.setItems(mainApp.getPersonData());
    if(mainApp.primaryStage.isShowing())
        fitColumns();
    else {
        mainApp.primaryStage.showingProperty().addListener((obs, oldVal, newVal) -> {
            if(newVal)
                fitColumns();
        });
    }
}