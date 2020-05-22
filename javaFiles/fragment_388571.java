@FXML
void changeFont(ActionEvent event) {
    try {
        Locale locale = Localization.getLocale(); 
        Localization.setLocale(new Locale("en", "US")); 
        FontSelectorDialog fs = new FontSelectorDialog(null);
        fs.show();
        fs.setOnCloseRequest(e->{
            if (fs.getResult() != null) {
                category1.setStyle(null);
                category1.setFont(fs.getResult());
            }
            Localization.setLocale(locale); // Reset locale
        });
    } catch (Exception e) {
        System.out.println("can't load new window");
    }
}