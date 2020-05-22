trans.statusProperty().addListener((obs, oldStatus, newStatus) -> {
    if (newStatus == Animation.Status.STOPPED) {
        text.setVisible(true);
    }
});

trans.statusProperty().addListener((obs, oldStatus, newStatus) -> {
    if (newStatus == Animation.Status.STOPPED) {
        rec.setFill(Color.WHITE);
    }
});