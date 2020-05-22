List<String> allStyles = Arrays.asList("info", "debug", "warning", "error");

debugListView.setCellFactory(listCell -> new ListCell<String>() {
    @Override
    public void updateItem(String content, boolean isEmpty) {
        super.updateItem(content, isEmpty);

        getStyleClass().removeAll(allStyles);

        if (isEmpty || content == null) {
            setText("");
            setStyle("");
        } else {
            setText(content);
            if (content.contains("INFO")) {
                getStyleClass().addAll("info", "debug");
            } else if (content.contains("WARN")) {
                getStyleClass().addAll("warning", "debug");
            } else if (content.contains("ERROR")) {
                getStyleClass().addAll("error", "debug");
            }
        }
    }
});