list.setCellFactory(lv -> new ListCell<WordType>() {

    private final TextField word = new TextField();
    private final TextField translate = new TextField();
    private final ToolBar root = new ToolBar(word, new Separator(), translate);

    {
        // anonymous constructor:

        itemProperty().addListener((obs, oldWordType, newWordType) -> {
            if (oldWordType != null) {
                word.textProperty().unbindBidirectional(oldWordType.firstProperty());
                translate.textProperty().unbindBidirectional(oldWordType.secondProperty());
            }

            if (newWordType != null) {
                word.textProperty().bindBidirectional(newWordType.firstProperty());
                translate.textProperty().bindBidirectional(newWordType.secondProperty());
            }
        });
    }

    @Override
    protected void updateItem(WordType item, boolean empty) {
        super.updateItem(item, empty);
        setGraphic(empty ? null : root);
    }
});