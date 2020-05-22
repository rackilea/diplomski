new Thread(() -> {
    Platform.runLater(()-> messageField.getStyleClass().add("smallLoading"));

    submitImpl();

    Platform.runLater(()-> messageField.getStyleClass().remove("smallLoading"));
}).start();