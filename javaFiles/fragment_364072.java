txt.setOnAction(event -> {
    try {
        engine.load(txt.getText());
    }catch (Exception e) {
        showError("Unable to load site");
    }
});