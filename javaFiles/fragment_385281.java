public AlertTreeCell() {

    FXMLLoader fxmlLoader = new FXMLLoader(
            MainController.class
                    .getResource("/fxml/alert_list_item.fxml"));
    try {
        cell = (Node) fxmlLoader.load();
        rectSeverity = (Rectangle) cell.lookup("#rectSeverity");
        mIncedentname = (Label) cell.lookup("#lblIncidentName");
        mAlertTitle = (Label) cell.lookup("#lblAlertTitle");
        mSentTime = (Label) cell.lookup("#lblSentTime");
        mSender = (Label) cell.lookup("#lblSender");
        ivCategory = (ImageView) cell.lookup("#ivCategory");

        this.selectedProperty().addListener((obs, wasSelected, isNowSelected) -> {
            String col ;
            if (isNowSelected) {
                col = "_black.png" ;
            } else {
                col = "_white.png" ;
            }
            if (getItem() != null) {
                Image img = new Image("/images/ic_cat_" + item.getCategoryIcon().toLowerCase() + col);
                ivCategory.setImage(img);
            }
        });

    } catch (IOException ex) {
        mLogger.error(ex.getLocalizedMessage(),ex);
    }           
}